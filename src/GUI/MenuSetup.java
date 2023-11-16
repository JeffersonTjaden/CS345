package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

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
    helpItem.addActionListener(e ->{
      File htmlFile = new File("src/resources/help.html");
      try
      {
        Desktop.getDesktop().browse(htmlFile.toURI());
      }
      catch (IOException e1)
      {
        e1.printStackTrace();
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
}

