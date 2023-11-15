package Operations;

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
    //window.setTitle("Fraction Calculator");        
    window.setVisible(true);    
  }  
}
