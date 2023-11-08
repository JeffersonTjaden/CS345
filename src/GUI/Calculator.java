package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import utilities.*;

public class Calculator extends JFrame implements ActionListener
{
  private Container content = getContentPane();
  private GridBagConstraints c = new GridBagConstraints();
  private JPanel display = new JPanel(new BorderLayout());
  private JTextArea displayExpression = new JTextArea(1, 5);
  private JTextArea displayOperand = new JTextArea(1, 5);
  private String whole = "_";
  private String numerator = "_";
  private String denominator = "_";
  private String inputOperand = whole + " " + numerator + "/" + denominator;

  private IrreducedMixedFraction left;
  private IrreducedMixedFraction right;
  private IrreducedMixedFraction result;
  private String currentOperation;
  private String partialCurrentExpression;
  private String evaluatedCurrentExpression;
  private int currentTextArea = 0;

  private JButton zero;
  private JButton one;
  private JButton two;
  private JButton three;
  private JButton four;
  private JButton five;
  private JButton six;
  private JButton seven;
  private JButton eight;
  private JButton nine;

  private JButton add;
  private JButton minus;
  private JButton multiply;
  private JButton divide;
  private JButton equals;

  private JButton reset;
  private JButton clear;
  private JButton back;
  private JButton sign;
  private JButton bar;

  public Calculator()
  {
    setupLayout();
  }

  private void setupMenu()
  {
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
    aboutItem.addActionListener(e -> {
      About aboutDialog = new About(Calculator.this);
      aboutDialog.setVisible(true);
    });
    JMenuItem helpItem = new JMenuItem("Help");
    // TODO: add an action listener to helpItem
    helpMenu.add(aboutItem);
    helpMenu.add(helpItem);

    // Add menus to menu bar
    menuBar.add(fileMenu);
    menuBar.add(viewMenu);
    menuBar.add(helpMenu);

    // Set the menu bar to the frame
    setJMenuBar(menuBar);
  }

  private void setupLayout()
  {
    setupMenu();
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setTitle("Fragile Calculator");

    content = getContentPane();
    content.setLayout(new GridBagLayout());
    
    
    display();
    softButtons();
    displayLogo();
    

    setVisible(true);
    setSize(400, 600);
  }
  

  
  private void displayLogo() {
    ImageIcon picture = new ImageIcon(getClass().getResource("/resources/Fragile_Logo.png"));
    
    Image img = picture.getImage();
    Image scaledImage = img.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
    picture = new ImageIcon(scaledImage);

    JLabel icon = new JLabel(picture);
    icon.setHorizontalAlignment(SwingConstants.LEFT);

    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 5;
    c.gridheight = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.fill = GridBagConstraints.BOTH;
    content.add(icon, c);
}

  private void display()
  {
    displayExpression.setEditable(false);
    displayOperand.setEditable(false);
    displayOperand.setText(inputOperand);
    display.setBackground(displayExpression.getBackground());
    display.add(displayExpression, BorderLayout.NORTH);
    display.add(displayOperand, BorderLayout.EAST);
    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 2;
    c.gridwidth = 5;
    c.fill = GridBagConstraints.HORIZONTAL;
    content.add(display, c);
    
  }
  

  private void softButtons() // This method will create the button scheme
  {
    c.fill = GridBagConstraints.BOTH;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weightx = .5;
    c.weighty = .5;

    reset = new JButton("R");
    reset.setActionCommand("reset");
    reset.addActionListener(this);
    c.gridx = 0;
    c.gridy = 3;
    content.add(reset, c);

    clear = new JButton("C");
    clear.setActionCommand("clear");
    clear.addActionListener(this);
    c.gridx = 1;
    c.gridy = 3;
    content.add(clear, c);

    back = new JButton(Character.toString((char) 171));
    back.setActionCommand("back");
    back.addActionListener(this);
    c.gridx = 2;
    c.gridy = 3;
    content.add(back, c);

    add = new JButton("+");
    add.setActionCommand("add");
    add.addActionListener(this);
    c.gridx = (3);
    c.gridy = (3);
    content.add(add, c);

    sign = new JButton(Character.toString((char) 177));
    sign.setActionCommand("sign");
    sign.addActionListener(this);
    c.gridx = (4);
    c.gridy = (3);
    content.add(sign, c);

    seven = new JButton("7");
    seven.setActionCommand("seven");
    seven.addActionListener(this);
    c.gridx = 0;
    c.gridy = 4;
    content.add(seven, c);

    eight = new JButton("8");
    eight.setActionCommand("eight");
    eight.addActionListener(this);
    c.gridx = 1;
    c.gridy = 4;
    content.add(eight, c);

    nine = new JButton("9");
    nine.setActionCommand("nine");
    nine.addActionListener(this);
    c.gridx = 2;
    c.gridy = 4;
    content.add(nine, c);

    minus = new JButton("-");
    minus.setActionCommand("minus");
    minus.addActionListener(this);
    c.gridx = 3;
    c.gridy = 4;
    content.add(minus, c);

    four = new JButton("4");
    four.setActionCommand("four");
    four.addActionListener(this);
    c.gridx = 0;
    c.gridy = 5;
    content.add(four, c);

    five = new JButton("5");
    five.setActionCommand("five");
    five.addActionListener(this);
    c.gridx = 1;
    c.gridy = 5;
    content.add(five, c);

    six = new JButton("6");
    six.setActionCommand("six");
    six.addActionListener(this);
    c.gridx = 2;
    c.gridy = 5;
    content.add(six, c);

    multiply = new JButton("X");
    multiply.setActionCommand("multiply");
    multiply.addActionListener(this);
    c.gridx = 3;
    c.gridy = 5;
    content.add(multiply, c);

    one = new JButton("1");
    one.setActionCommand("one");
    one.addActionListener(this);
    c.gridx = 0;
    c.gridy = 6;
    content.add(one, c);

    two = new JButton("2");
    two.setActionCommand("two");
    two.addActionListener(this);
    c.gridx = 1;
    c.gridy = 6;
    content.add(two, c);

    three = new JButton("3");
    three.setActionCommand("three");
    three.addActionListener(this);
    c.gridx = 2;
    c.gridy = 6;
    content.add(three, c);

    divide = new JButton(Character.toString((char) 247));
    divide.setActionCommand("divide");
    divide.addActionListener(this);
    c.gridx = 3;
    c.gridy = 6;
    content.add(divide, c);

    bar = new JButton("/");
    bar.setActionCommand("bar");
    bar.addActionListener(this);
    c.gridx = 2;
    c.gridy = 7;
    content.add(bar, c);

    equals = new JButton("=");
    equals.setActionCommand("equals");
    equals.addActionListener(this);
    c.gridx = 3;
    c.gridy = 7;
    content.add(equals, c);

    zero = new JButton("0");
    zero.setActionCommand("zero");
    zero.addActionListener(this);
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 7;
    content.add(zero, c);
  }

  private void clearText() {
    whole = "_";
    numerator = "_";
    denominator = "_";
    updateCurrentOperand();
  }

  private void operatorButtonClicked() {
    if (left == null) {
          left = new IrreducedMixedFraction(Integer.parseInt(whole), Integer.parseInt(numerator), Integer.parseInt(denominator));
        }
        partialCurrentExpression = left.toString() + currentOperation;
        displayExpression.setText(partialCurrentExpression);
        clearText();
        currentTextArea = 0;
  }
  
    @Override
    public void actionPerformed(ActionEvent e)
    {
      
      String command = e.getActionCommand();
      if (add.getActionCommand().equals(command))
      {
        currentOperation = "+";
        operatorButtonClicked();
      }
    else if (minus.getActionCommand().equals(command))
    {
      currentOperation = "-";
      operatorButtonClicked();
    }
    else if (multiply.getActionCommand().equals(command))
    {
      currentOperation = "*";
      operatorButtonClicked();
    }
    else if (divide.getActionCommand().equals(command))
    {
      currentOperation = "/";
      operatorButtonClicked();
    }
    else if (equals.getActionCommand().equals(command))
    {
      right = new IrreducedMixedFraction(Integer.parseInt(whole), Integer.parseInt(numerator), Integer.parseInt(denominator));
      switch (currentOperation)
      {
        case "+":
          result = Operations.add(left, right);
          break;         
        case "-":
          result = Operations.subtract(left, right);
          break;
        case "*":
          result = Operations.multiply(left, right);
          break;          
        case "/":
          result = Operations.divide(left, right);
          break;                 
      }
      evaluatedCurrentExpression = partialCurrentExpression + right.toString() + "=" + result.toString();
      displayExpression.setText(evaluatedCurrentExpression);
      clearText();
      currentTextArea = 0;
      left = result;
      right = null;
      currentOperation = null;
      whole = String.valueOf(left.getWhole());
      numerator = String.valueOf(left.getNumerator());
      denominator = String.valueOf(left.getDenominator());
      updateCurrentOperand();
    }
    else if (e.getActionCommand().equals("clear"))
    {
       clearText();
    }
    else if (e.getActionCommand().equals("sign"))
    {
        
        
    }
    else if(e.getActionCommand().equals("zero"))
    {
      buttonActionListener(0);     
    } 
    else if(e.getActionCommand().equals("one"))
    {
      buttonActionListener(1);
    }
    else if(e.getActionCommand().equals("two"))
    {
      buttonActionListener(2);
    }
    else if(e.getActionCommand().equals("three"))
    {
      buttonActionListener(3);
    }
    else if(e.getActionCommand().equals("four"))
    {
      buttonActionListener(4);
    }
    else if(e.getActionCommand().equals("five"))
    {
      buttonActionListener(5);
    }
    else if(e.getActionCommand().equals("six"))
    {
      buttonActionListener(6);
    }
    else if(e.getActionCommand().equals("seven"))
    {
      buttonActionListener(7);
    }
    else if(e.getActionCommand().equals("eight"))
    {
      buttonActionListener(8);
    }
    else if(e.getActionCommand().equals("nine"))
    {
      buttonActionListener(9);
    }
    else if(e.getActionCommand().equals("bar"))
    {
      currentTextArea++;
      
      
    }
    else if (command.equals(reset.getActionCommand())){
      left = null;
      right = null;
      result = null;
      displayExpression.setText("");
      clearText();
      currentTextArea = 0;
      currentOperation = null;
    }
    else if (command.equals(back.getActionCommand())) {
      if (currentTextArea % 3 == 0) {
          if (whole.length() > 1) {
              whole = whole.substring(0, whole.length() - 1);
          } else {
            whole = "_";
          }
      } else if (currentTextArea % 3 == 1) {
          if (numerator.length() > 1) {
              numerator = numerator.substring(0, numerator.length() - 1);
          } else {
            numerator = "_";
          }
      } else {
          if (denominator.length() > 1) {
              denominator = denominator.substring(0, denominator.length() - 1);              
          } else {
            denominator = "_";
          }
      }
      updateCurrentOperand();
  }
  }
  

  private void buttonActionListener(int number){
    if (currentTextArea % 3 == 0) {
      if (whole.equals("_")){
        whole = "" + number;
      } else {
      whole += number;
    }
    } else if (currentTextArea % 3 == 1) {
      if (numerator.equals("_")){
        numerator = "" + number;
      } else{
      numerator += number;}
    } else {
      if (denominator.equals("_")){
        denominator = "" + number;
      } else {
      denominator += number;}
    }
    updateCurrentOperand();
  }

  private void updateCurrentOperand() {
    
    inputOperand = whole + " " + numerator + "/" + denominator;
    displayOperand.setText(inputOperand);
  }
  

  public static void main(String[] args)
  {
    new Calculator();
  }
}
