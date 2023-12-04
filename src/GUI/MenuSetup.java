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
import java.util.Locale;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import GUI.Display.BarDisplay;
import GUI.Display.SlashDisplay;
import GUI.Display.SolidusDisplay;
import GUI.pieChart.PieChart;
import Recording.CalculationRecorder;
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
    properItem.addActionListener(e -> calculator.setProperForm(properItem.isSelected()));
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
    });
    JRadioButtonMenuItem slashItem = new JRadioButtonMenuItem(messages.getString("slash.item"));
    slashItem.addActionListener(e -> {
      calculator.changeDisplay(new SlashDisplay());
    });
    JRadioButtonMenuItem solidusItem = new JRadioButtonMenuItem(messages.getString("solidus.item"));
    solidusItem.addActionListener(e -> {
      calculator.changeDisplay(new SolidusDisplay());
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
      String htmlContent = generateTranslatedHtmlContent(messages);
      File tempHtmlFile = createTempHtmlFile(htmlContent);
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
  private String generateTranslatedHtmlContent(ResourceBundle messages) {
    StringBuilder htmlBuilder = new StringBuilder();
    String imagePath1 = extractImage("Picture1.png");
    String imagePath2 = extractImage("Picture2.png");
    String imagePath3 = extractImage("Picture3.png");
    String imagePath4 = extractImage("Picture4.png");
    String imagePath5 = extractImage("Picture5.png");
    String imagePath6 = extractImage("Picture6.png");
    String imagePath7 = extractImage("Picture7.png");
    String imagePath8 = extractImage("Picture8.png");
    String imagePath9 = extractImage("Picture9.png");
    String imagePath10 = extractImage("Picture10.png");
    String imagePath11 = extractImage("Picture11.png");
    String imagePath12 = extractImage("Picture12.png");
    String imagePath13 = extractImage("Picture13.png");
    String imagePath14 = extractImage("Picture14.png");
    String imagePath15 = extractImage("Picture15.png");
    String imagePath16 = extractImage("Picture16.png");

    // Add the HTML header with the title
    htmlBuilder.append("<html><head><title>")
               .append(messages.getString("fractal.title"))
               .append("</title></head><body>");

    // Add the main title
    htmlBuilder.append("<h1>").append(messages.getString("fractal.title")).append("</h1>");

    // General/Navigation section
    htmlBuilder.append("<h2>").append(messages.getString("generalnav.title")).append("</h2>")
               .append("<p>").append(messages.getString("launch.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath1).append("' alt='Launch Icon'>")
               .append("<p>").append(messages.getString("close.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath2).append("' alt='Close Icon'>")
               .append("<p>").append(messages.getString("close.menu.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath3).append("' alt='Launch Icon'>");

    // Menu Bar Options section
    htmlBuilder.append("<h2>").append(messages.getString("menubaropt.title")).append("</h2>")
               .append("<p>").append(messages.getString("print.file.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath4).append("' alt='Launch Icon'>")
               .append("<p>").append(messages.getString("mode.option.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath5).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath6).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath7).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath8).append("' alt='Launch Icon'>")
               .append("<p>").append(messages.getString("view.option.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath9).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath10).append("' alt='Launch Icon'>")
               .append("<p>").append(messages.getString("style.option.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath11).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath12).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath13).append("' alt='Launch Icon'>")
               .append("<p>").append(messages.getString("help.option.instruction")).append("</p>")
               .append("<img src='file:/").append(imagePath14).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath15).append("' alt='Launch Icon'>")
               .append("<img src='file:/").append(imagePath16).append("' alt='Launch Icon'>");

    // Session History section
    htmlBuilder.append("<h2>").append(messages.getString("sesh.title")).append("</h2>")
               .append("<p>").append(messages.getString("session.history.instruction")).append("</p>");

    // Calculator Functions section
    htmlBuilder.append("<h2>").append(messages.getString("calculator.display.instruction")).append("</h2>")
               .append("<p>").append(messages.getString("position.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("number.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("reset.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("clear.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("backspace.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("sign.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("operation.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("equals.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("mediant.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("integerPower.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("simplification.button.instruction")).append("</p>")
               .append("<p>").append(messages.getString("invert.button.instruction")).append("</p>");

    // Keyboard Usage section
    htmlBuilder.append("<h2>").append(messages.getString("keyboard.title")).append("</h2>")
               .append("<p>").append(messages.getString("keyboard.usage.instruction")).append("</p>")
               .append("<p>").append(messages.getString("keyboard.operations.instruction")).append("</p>")
               .append("<p>").append(messages.getString("decimal.key.instruction")).append("</p>");

    // Close the HTML content
    htmlBuilder.append("</body></html>");

    // Convert the StringBuilder content to a String and return it
    return htmlBuilder.toString();
  }
  
  private File createTempHtmlFile(String htmlContent) {
    File tempFile = null;
    try {
        // Create a temporary file
        tempFile = File.createTempFile("help", ".html");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(htmlContent);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return tempFile;
  }
  
  private String extractImage(String imageName) {
    File tempDir = new File(System.getProperty("java.io.tmpdir"), "myapp-resources");
    File tempImageFile = new File(tempDir, imageName);

    try {
        if (!tempDir.exists() && !tempDir.mkdirs()) {
            return null;
        }

        // Get the URL of the image resource from the classpath
        java.net.URL imageUrl = getClass().getResource("/resources/" + imageName);
        if (imageUrl == null) {
            return null;
        }

        // Copy the image resource to the temporary directory
        try (InputStream in = imageUrl.openStream();
             FileOutputStream out = new FileOutputStream(tempImageFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    return tempImageFile.getAbsolutePath();
  }

  private void fetchPreferences() throws IOException{
        
    BufferedReader in = new BufferedReader(new FileReader("src/resources/Preferences"));
    proper = Boolean.parseBoolean(in.readLine());
    reduced = Boolean.parseBoolean(in.readLine());
    display = in.readLine();
  }

  public String getDisplay(){
    return display;
  }
}

