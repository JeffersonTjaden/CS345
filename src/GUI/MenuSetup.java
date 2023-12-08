package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import GUI.Displays.BarDisplay;
import GUI.Displays.SlashDisplay;
import GUI.Displays.SolidusDisplay;
import GUI.pieChart.PieChart;
import Recording.CalculationRecorder;
import Recording.PlaybackController;
import utilities.IrreducedMixedFraction;

public class MenuSetup
{
  private JFrame parentFrame;
  private JCheckBoxMenuItem pieChartItem;
  private PieChart pieChartWindow;
  private Calculator calculator;
  private ResourceBundle messages;
  private CalculationRecorder recorder;

  private Boolean proper;
  private Boolean reduced;
  private String display;
  private BufferedReader in;
  private BufferedWriter out;
  private FileWriter writer;
  
  Color menuColor;
  
  public MenuSetup(JFrame parentFrame, Calculator calculator, Locale locale, CalculationRecorder recorder) {
    this.parentFrame = parentFrame;
    this.calculator = calculator;
    this.messages = ResourceBundle.getBundle("resources.MessagesBundle", locale);
    this.recorder = recorder;
  }
  
  public JMenuBar createMenuBar() {
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    try {
      fetchPreferences();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try
    {
      // Read in the file
      BufferedReader in = new BufferedReader(new FileReader("src/resources/Customization"));
      
      // Create first color
      String color1 = in.readLine();
      
      //Create second color
      String color2 = in.readLine();
      String[] rgb2 = color2.split(",");
      int r2 = Integer.parseInt(rgb2[0].strip());
      int g2 = Integer.parseInt(rgb2[1].strip());
      int b2 = Integer.parseInt(rgb2[2].strip());
      menuColor = new Color(r2, g2, b2);
    }
    catch (IOException e)
    {
      System.out.println("File Not Found. Please ensure the file name is typed exactly");
      System.out.print("as it is displayed in the Resources Package.");
    }
    // set MenuBar Color
    menuBar.setBackground(menuColor);
    
    // Create File menu with Exit item
    JMenu fileMenu = new JMenu(messages.getString("file.menu"));
    
    JMenuItem openRecordingItem = new JMenuItem(messages.getString("openRecording.item"));
    openRecordingItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to open recording
          new PlaybackController(calculator, calculator.getDisplay());
        }
    });
    fileMenu.add(openRecordingItem);
    openRecordingItem.setBackground(menuColor);
    
    JMenuItem saveRecordingItem = new JMenuItem(messages.getString("saveRecording.item"));
    saveRecordingItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle(messages.getString("saveRecording.title"));
          int userSelection = fileChooser.showSaveDialog(parentFrame);

          if (userSelection == JFileChooser.APPROVE_OPTION) {
              File fileToSave = fileChooser.getSelectedFile();
              // Your CalculationRecorder instance should be accessible here
              recorder.showRecordingControlsDialog(fileToSave);
          }
        }
    });
    fileMenu.add(saveRecordingItem);
    
    fileMenu.addSeparator();
    saveRecordingItem.setBackground(menuColor);
    
    JMenuItem printSessionItem = new JMenuItem(messages.getString("printSession.item"));
    printSessionItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          calculator.printHistory();
      }
    });
    fileMenu.add(printSessionItem);
    
    fileMenu.addSeparator();
    
    JMenuItem newCalculatorItem = new JMenuItem(messages.getString("newCalculator.item"));
    newCalculatorItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Calculator();
        }
    });
    fileMenu.add(newCalculatorItem);
    
    fileMenu.addSeparator();
    printSessionItem.setBackground(menuColor);
    newCalculatorItem.setBackground(menuColor);
    
    JMenuItem exitItem = new JMenuItem(messages.getString("exit.item"));
    exitItem.addActionListener(e -> System.exit(0)); // Close the application on selecting Exit
    fileMenu.add(exitItem);
    exitItem.setBackground(menuColor);
    
    // Mode menu
    JMenu modeMenu = new JMenu(messages.getString("mode.menu"));
    JCheckBoxMenuItem properItem = new JCheckBoxMenuItem(messages.getString("proper.item"), proper);
    JCheckBoxMenuItem reducedItem = new JCheckBoxMenuItem(messages.getString("reduced.item"), reduced);
    properItem.addActionListener(e -> {
      calculator.setProperForm(properItem.isSelected());
      proper = !proper;
      try {
        writePreferences();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    reducedItem.addActionListener(e -> {
      calculator.setReducedForm(reducedItem.isSelected());
      reduced = !reduced;
      try {
        writePreferences();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    reducedItem.addActionListener(e -> calculator.setReducedForm(reducedItem.isSelected()));
    modeMenu.add(properItem);
    modeMenu.add(reducedItem);
    properItem.setBackground(menuColor);
    reducedItem.setBackground(menuColor);

    // Create View menu with Pie Chart item
    JMenu viewMenu = new JMenu(messages.getString("view.menu"));
    pieChartItem = new JCheckBoxMenuItem(messages.getString("pieChart.item"));
    pieChartItem.addActionListener(e -> {
      if (pieChartItem.isSelected()) {
          if (calculator.getCanCreatePieChart()) {
              pieChartWindow = new PieChart(
                  (IrreducedMixedFraction) calculator.getPieChartOps().get(0),
                  (IrreducedMixedFraction) calculator.getPieChartOps().get(1),
                  (IrreducedMixedFraction) calculator.getPieChartOps().get(2),
                  (String) calculator.getPieChartOps().get(3),
                  messages, this);
              pieChartWindow.setAlwaysOnTop(true);
          } else {
              pieChartItem.setSelected(false);  // Uncheck if creation not possible
              JOptionPane.showMessageDialog(parentFrame, messages.getString("error.dialog.message"),
                  messages.getString("error.dialog.title"), JOptionPane.ERROR_MESSAGE);
          }
      } else {
          if (pieChartWindow != null) {
              pieChartWindow.dispose();
              pieChartWindow = null;
          }
      }
    });
    viewMenu.add(pieChartItem);
    pieChartItem.setBackground(menuColor);
    
    // Style menu
    JMenu styleMenu = new JMenu(messages.getString("style.menu"));
    ButtonGroup styleGroup = new ButtonGroup();
    JRadioButtonMenuItem barItem = new JRadioButtonMenuItem(messages.getString("bar.item"));
    barItem.addActionListener(e -> {
      calculator.changeDisplay(new BarDisplay());
      display = "bar";
      try {
        writePreferences();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    JRadioButtonMenuItem slashItem = new JRadioButtonMenuItem(messages.getString("slash.item"));
    slashItem.addActionListener(e -> {
      calculator.changeDisplay(new SlashDisplay());
      display = "slash";
      try {
        writePreferences();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    JRadioButtonMenuItem solidusItem = new JRadioButtonMenuItem(messages.getString("solidus.item"));
    solidusItem.addActionListener(e -> {
      calculator.changeDisplay(new SolidusDisplay());
      display = "solidus";
      try {
        writePreferences();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    barItem.setBackground(menuColor);
    slashItem.setBackground(menuColor);
    solidusItem.setBackground(menuColor);
    
    // This will set the display according to the preferences
    if(display.equals("bar")){
      barItem.setSelected(true);
    } else if (display.equals("solidus")){
      solidusItem.setSelected(true);
    } else if (display.equals("slash")){
      slashItem.setSelected(true);
    }
    
    // TODO: Add action listeners for style menu items
    styleGroup.add(barItem);
    styleGroup.add(slashItem);
    styleGroup.add(solidusItem);
    styleMenu.add(barItem);
    styleMenu.add(slashItem);
    styleMenu.add(solidusItem);

    // Create Help menu with About and Help items
    JMenu helpMenu = new JMenu(messages.getString("help.menu"));
    JMenuItem aboutItem = new JMenuItem(messages.getString("about.item"));
    aboutItem.addActionListener(e -> 
    {
      About aboutDialog = new About(parentFrame, messages);
      aboutDialog.setVisible(true);
    });
    JMenuItem helpItem = new JMenuItem(messages.getString("help.item"));
    helpItem.addActionListener(e -> {
      HelpFile helpFile = new HelpFile(messages);
      String htmlContent = helpFile.generateTranslatedHtmlContent();
      File tempHtmlFile = helpFile.createTempHtmlFile(htmlContent);
      if (tempHtmlFile != null) {
          try {
              Desktop.getDesktop().browse(tempHtmlFile.toURI());
          } catch (IOException e1) {
          }
      } else {
      }
    });
    helpMenu.add(aboutItem);
    helpMenu.add(helpItem);
    aboutItem.setBackground(menuColor);
    helpItem.setBackground(menuColor);

    // Add menus to menu bar
    menuBar.add(fileMenu);
    menuBar.add(modeMenu);
    menuBar.add(viewMenu);
    menuBar.add(styleMenu);
    menuBar.add(helpMenu);
    
    return menuBar;
  }
  
  public JCheckBoxMenuItem getCheckBoxMenuItem() {
    return pieChartItem;
  }

  private void fetchPreferences() throws IOException {
    InputStream is = getClass().getClassLoader().getResourceAsStream("resources/Preferences");
    if (is != null) {
        in = new BufferedReader(new InputStreamReader(is));
        proper = Boolean.parseBoolean(in.readLine());
        reduced = Boolean.parseBoolean(in.readLine());
        display = in.readLine();
        in.close();
    } else {
        // Handle the case where the resource is not found
        // You can either log this or throw an exception
        throw new FileNotFoundException("Preferences file not found in resources");
    }
  }

  private void writePreferences() throws IOException{
    try {
      writer = new FileWriter("src/resources/Preferences");
      out = new BufferedWriter(writer);
      out.write(proper.toString() + "\n");
      out.write(reduced.toString() + "\n");
      out.write(display + "\n");
      out.close();
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String getDisplay(){
    return display;
  }
}

