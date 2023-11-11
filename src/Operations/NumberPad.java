import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A numeric keypad
 */
public class NumberPad extends JPanel
{
  private static final Font BUTTON_FONT = new Font("DejaVu Sans", Font.PLAIN, 12);
  private ActionListener listener;
  private GridBagLayout gbl = new GridBagLayout();;
  private GridBagConstraints gbc;

  /**
   * Default Constructor
   */
  public NumberPad(ActionListener listener)
  {
    super();

    this.listener = listener;
    setupLayout();

    // ClickAction
    InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "0");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "1");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "2");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "3");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "4");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "5");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), "6");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "7");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), "8");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0), "9");

    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "\u232B");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
  }

  /**
   * Setup and layout this NumberPad
   */
  private void setupLayout()
  {
    this.setLayout(gbl);
    gbc = new GridBagConstraints();
    
    // First Row
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("R", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("C", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton(Character.toString((char) 171), gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("+", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 4;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton(Character.toString((char) 171), gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 5;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton(Character.toString((char) 177), gbc);

    
    // Second Row
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("7", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("8",gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("9", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("-", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 4;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("?", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 5;
    gbc.gridy = 1;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("Inv", gbc);

    // Third Row
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("4", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("5", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    addButton("6", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("x", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 5;
    gbc.gridy = 2;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("↡", gbc);

    // Fourth Row
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("1", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("2", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("3", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 3;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton(Character.toString((char) 247), gbc);

    // Fifth Row
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridheight = 1;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(5,5,5,5);
    gbc.fill = GridBagConstraints.BOTH;
    addButton("0", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("P", gbc);
    
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 4;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    gbc.insets = new Insets(5,5,5,5);
    addButton("=", gbc);
  }

  //Blank labels
  private void addBlank()
  {
    JLabel label = new JLabel();
    add(label);
  }

  private void addButton(String text, GridBagConstraints gbc)
  {
    //JButton button = new JButton(text);
    //MyButton button = new MyButton(text, this);
    MyButton button = new MyButton(text);
    //button.setFont(BUTTON_FONT);
    add(button, gbc);
  
    button.addActionListener(listener);
    ActionMap actionMap = this.getActionMap();
    actionMap.put(text, new ClickAction(button));
  }
  
  
  
}
