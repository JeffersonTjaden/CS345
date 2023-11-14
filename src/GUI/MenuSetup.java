package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuSetup
{
  private JFrame parentFrame;
  private JMenuItem pieChartItem;
  
  public MenuSetup(JFrame parentFrame) {
    this.parentFrame = parentFrame;
  }
  
  public JMenuBar createMenuBar() {
    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create File menu with Exit item
    JMenu fileMenu = new JMenu("File");
    JMenuItem printSessionItem = new JMenuItem("Print Session");
    // TODO: Add action listener for printSessionItem
    fileMenu.add(printSessionItem);
    
    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.addActionListener(e -> System.exit(0)); // Close the application on selecting Exit
    fileMenu.add(exitItem);
    
    // Mode menu
    JMenu modeMenu = new JMenu("Mode");
    JCheckBoxMenuItem properItem = new JCheckBoxMenuItem("Proper");
    JCheckBoxMenuItem reducedItem = new JCheckBoxMenuItem("Reduced");
    // TODO: Add action listeners and manage state for properItem and reducedItem
    modeMenu.add(properItem);
    modeMenu.add(reducedItem);

    // Create View menu with Pie Chart item
    JMenu viewMenu = new JMenu("View");
    pieChartItem = new JMenuItem("Pie Chart");
    viewMenu.add(pieChartItem);
    
    // Style menu
    JMenu styleMenu = new JMenu("Style");
    ButtonGroup styleGroup = new ButtonGroup();
    JRadioButtonMenuItem barItem = new JRadioButtonMenuItem("Bar");
    JRadioButtonMenuItem slashItem = new JRadioButtonMenuItem("Slash");
    JRadioButtonMenuItem solidusItem = new JRadioButtonMenuItem("Solidus");
    // TODO: Add action listeners for style menu items
    styleGroup.add(barItem);
    styleGroup.add(slashItem);
    styleGroup.add(solidusItem);
    styleMenu.add(barItem);
    styleMenu.add(slashItem);
    styleMenu.add(solidusItem);

    // Create Help menu with About and Help items
    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener(e -> 
    {
      About aboutDialog = new About(parentFrame);
      aboutDialog.setVisible(true);
    });
    JMenuItem helpItem = new JMenuItem("Help");
    // TODO: add an action listener to helpItem
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
  
  public JMenuItem getPieChartMenuItem() {
    return pieChartItem;
  }
}

