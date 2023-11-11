import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Display extends JTextArea implements ActionListener
{
  private String contents;
  private String displayContents;
  private int COUNT = 0;

  private static final String CLEAR = "C";
  private static final String ERASE_TO_THE_LEFT = "\u232B";
  
  //Mathmatical Operators
  private static final String MULTIPLY = "x";
  private static final String DIVIDE = "\u00F7";
  private static final String SUBTRACT = "-";
  private static final String ADD = "+";
  
  //INTEGERS 0 - 9
  private static final String ZERO = "0";
  private static final String ONE = "1";
  private static final String TWO = "2";
  private static final String THREE = "3";
  private static final String FOUR = "4";
  private static final String FIVE = "5";
  private static final String SIX = "6";
  private static final String SEVEN = "7";
  private static final String EIGHT = "8";
  private static final String NINE = "9";

  

  public Display()
  {
    //super(" ", SwingConstants.RIGHT);
    setBorder(BorderFactory.createEtchedBorder());
    

    contents = "";
    updateDisplay();
  }

  public void actionPerformed(ActionEvent actionEvent)
  {
    String actionCommand = actionEvent.getActionCommand();
    
    switch(actionCommand) {
      case ZERO:
        contents = contents + actionCommand;
        break;
      case ONE:
        contents = contents + actionCommand;
        break;
      case TWO:
        contents = contents + actionCommand;
        break;
      case THREE:
        contents = contents + actionCommand;
        break;
      case FOUR:
        contents = contents + actionCommand;
        break;
      case FIVE:
        contents = contents + actionCommand;
        break;
      case SIX:
        contents = contents + actionCommand;
        break;
      case SEVEN:
        contents = contents + actionCommand;
        break;
      case EIGHT:
        contents = contents + actionCommand;
        break;
      case NINE:
        contents = contents + actionCommand;
        break;
      case MULTIPLY:
        contents = contents + "*";
        break;
      case DIVIDE:
        contents = contents + actionCommand;
        break;
      case SUBTRACT:
        contents = contents + actionCommand;
        break;
      case ADD:
        contents = contents + actionCommand;
        break;
        
    }
    /*
    if(actionCommand.equals(ONE)) {
      contents = contents + actionCommand;
    }
    
    /*
    String ac = ae.getActionCommand();
    if (ac.equals(CLEAR))
    {
      contents = "";
      setText("Enter your PIN");
    }
    else if (ac.equals(ERASE_TO_THE_LEFT))
    {
      if (!contents.equals(""))
      {
        contents = contents.substring(0, contents.length() - 1);
      }
    }
    else
    {
      contents = contents + ac;
    }
    */
    updateDisplay();
    
  }

  private void updateDisplay()
  {
    JTextArea fraction = new JTextArea(3,1);
    
    fraction.setSelectionStart(1);
    setText("1");
    fraction.setSelectionStart(2);
    setText("\u2015");
    fraction.setSelectionStart(3);
    setText("2");
    
    //
    /*
    if (contents.equals(""))
    {
      setForeground(Color.GRAY);
      setText("Enter your PIN");
    }
    else {
      //displayContents = "";
      setForeground(Color.RED);
      setText(contents);
    }
    /*
    else
    {
      String asterisks = "";

      for (int i = 0; i < contents.length(); i++)
      {
        asterisks += "*";
      }
      setForeground(Color.RED);
      setText(asterisks);
    }
    */
  }
}
