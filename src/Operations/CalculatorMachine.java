import java.lang.reflect.*;
import javax.swing.*;

/**
 * The main class for the CalculatorMachine application.
 */
public class CalculatorMachine implements Runnable                                  //What is Runnable?
{
  /**
   * The entry point of the application (which is executed in the
   * main thread of execution).
   *
   * @param args   The command-line arguments
   */
  public static void main(String[] args) throws InterruptedException, InvocationTargetException
  {
    SwingUtilities.invokeAndWait(new CalculatorMachine());
  }
  
  /**
   * The code that is executed in the event dispatch thread.
   */
  public void run()
  {
    CalculatorWindow window = new CalculatorWindow();
    window.setTitle("ATM");        
    window.setVisible(true);
    
    //window.add
    
  }
  
  private JMenuBar setupMenu() {
 // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create File menu with Exit item
    JMenu fileMenu = new JMenu("File");
    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.addActionListener(e -> System.exit(0)); // Close the application on selecting Exit
    fileMenu.add(exitItem);

    // Create View menu with Pie Chart item
    JMenu viewMenu = new JMenu("View");
    JMenuItem pieChartItem = new JMenuItem("Pie Chart");
    // TODO: add an action listener to pieChartItem
    viewMenu.add(pieChartItem);

    // Create Help menu with About and Help items
    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    
    JMenuItem helpItem = new JMenuItem("Help");
    // TODO: add an action listener to helpItem
    helpMenu.add(aboutItem);
    helpMenu.add(helpItem);

    // Add menus to menu bar
    menuBar.add(fileMenu);
    menuBar.add(viewMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }
  
}
