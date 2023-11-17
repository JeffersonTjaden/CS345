package GUI;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import GUI.pieChart.PieChart;
import utilities.IrreducedMixedFraction;

public class MenuSetup
{
  private JFrame parentFrame;
  private JCheckBoxMenuItem pieChartItem;
  private PieChart pieChartWindow;
  private Calculator calculator;
  private ResourceBundle messages;
  
  public MenuSetup(JFrame parentFrame, Calculator calculator, Locale locale) {
    this.parentFrame = parentFrame;
    this.calculator = calculator;
    this.messages = ResourceBundle.getBundle("resources.MessagesBundle", locale);
  }
  
  public JMenuBar createMenuBar() {
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create File menu with Exit item
    JMenu fileMenu = new JMenu(messages.getString("file.menu"));
    JMenuItem printSessionItem = new JMenuItem(messages.getString("printSession.item"));
    // TODO: Add action listener for printSessionItem
    fileMenu.add(printSessionItem);
    
    JMenuItem exitItem = new JMenuItem(messages.getString("exit.item"));
    exitItem.addActionListener(e -> System.exit(0)); // Close the application on selecting Exit
    fileMenu.add(exitItem);
    
    // Mode menu
    JMenu modeMenu = new JMenu(messages.getString("mode.menu"));
    JCheckBoxMenuItem properItem = new JCheckBoxMenuItem(messages.getString("proper.item"));
    JCheckBoxMenuItem reducedItem = new JCheckBoxMenuItem(messages.getString("reduced.item"));
    properItem.addActionListener(e -> calculator.setProperForm(properItem.isSelected()));
    reducedItem.addActionListener(e -> calculator.setReducedForm(reducedItem.isSelected()));
    modeMenu.add(properItem);
    modeMenu.add(reducedItem);

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
    
    // Style menu
    JMenu styleMenu = new JMenu(messages.getString("style.menu"));
    ButtonGroup styleGroup = new ButtonGroup();
    JRadioButtonMenuItem barItem = new JRadioButtonMenuItem(messages.getString("bar.item"));
    JRadioButtonMenuItem slashItem = new JRadioButtonMenuItem(messages.getString("slash.item"));
    JRadioButtonMenuItem solidusItem = new JRadioButtonMenuItem(messages.getString("solidus.item"));
    barItem.setSelected(true);
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
}

