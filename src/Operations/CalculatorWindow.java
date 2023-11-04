import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * A window containing a PIN entry pad.
 */
public class CalculatorWindow extends JFrame
{
  private Container contentPane;
  /**
   * Default Constructor.
   */
  public CalculatorWindow()
  {
    super();
    setupLayout();

    // Set size for the CalculatorWindow to be static
    setResizable(false);
  }

  /**
   * Setup and layout this PINPadWindow
   */
  private void setupLayout()
  {
    setSize(400, 600);
    setTitle("CALCULATOR");

    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    Display display = new Display();
    //Adds padding to the top
    //display.setBounds(20,20,200,200);

    contentPane.add(display, BorderLayout.NORTH);
    

    NumberPad numberPad = new NumberPad(display);
    contentPane.add(numberPad);
    
    //Outside Border
    ((JComponent) contentPane).setBorder(new EmptyBorder(20,20,20,20));
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
