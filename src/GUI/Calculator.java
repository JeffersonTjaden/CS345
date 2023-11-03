package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.Operation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import utilities.*;

public class Calculator extends JFrame implements ActionListener
{
  private Container content = getContentPane();
  private GridBagConstraints c = new GridBagConstraints();
  private TextArea displayText = new TextArea(2, 2);
  private TextArea whole = new TextArea(2, 2);
  private TextArea numerator = new TextArea(2, 2);
  private TextArea denominator = new TextArea(2, 2);

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
    setupFocusListeners();
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
  
  private void setupFocusListeners() {
    FocusIndicatorListener focusIndicator = new FocusIndicatorListener();

    whole.addFocusListener(focusIndicator);
    numerator.addFocusListener(focusIndicator);
    denominator.addFocusListener(focusIndicator);
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
    displayText.setEditable(false);
    whole.setEditable(false);
    numerator.setEditable(false);
    denominator.setEditable(false);
    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 2;
    c.gridwidth = 2;
    c.fill = GridBagConstraints.HORIZONTAL;
    content.add(displayText, c);
    c.gridx = 2;
    c.gridwidth = 1;
    content.add(whole, c);
    c.gridx = 3;
    content.add(numerator, c);
    c.gridx = 4;
    content.add(denominator, c);
    
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
    whole.setText("");
    numerator.setText("");
    denominator.setText("");
  }
  
    @Override
    public void actionPerformed(ActionEvent e)
    {
      
      String command = e.getActionCommand();
      if (add.getActionCommand().equals(command))
      {
        currentOperation = "+";
        if (left == null) {
          left = new IrreducedMixedFraction(Integer.parseInt(whole.getText()), Integer.parseInt(numerator.getText()), Integer.parseInt(denominator.getText()));
        }
        partialCurrentExpression = left.toString() + currentOperation;
        displayText.setText(partialCurrentExpression);
        clearText();
        currentTextArea = 0;
      }
    else if (minus.getActionCommand().equals(command))
    {
      currentOperation = "-";
      if (left == null) {
        left = new IrreducedMixedFraction(Integer.parseInt(whole.getText()), Integer.parseInt(numerator.getText()), Integer.parseInt(denominator.getText()));
      }
      partialCurrentExpression = left.toString() + currentOperation;
      displayText.setText(partialCurrentExpression);
      clearText();
      currentTextArea = 0;
    }
    else if (multiply.getActionCommand().equals(command))
    {
      currentOperation = "*";
      if (left == null) {
        left = new IrreducedMixedFraction(Integer.parseInt(whole.getText()), Integer.parseInt(numerator.getText()), Integer.parseInt(denominator.getText()));
      }
      partialCurrentExpression = left.toString() + currentOperation;
      displayText.setText(partialCurrentExpression);
      clearText();
      currentTextArea = 0;
    }
    else if (divide.getActionCommand().equals(command))
    {
      currentOperation = "/";
      if (left == null) {
        left = new IrreducedMixedFraction(Integer.parseInt(whole.getText()), Integer.parseInt(numerator.getText()), Integer.parseInt(denominator.getText()));
      }
      partialCurrentExpression = left.toString() + currentOperation;
      displayText.setText(partialCurrentExpression);
      clearText();
      currentTextArea = 0;
    }
    else if (equals.getActionCommand().equals(command))
    {
      right = new IrreducedMixedFraction(Integer.parseInt(whole.getText()), Integer.parseInt(numerator.getText()), Integer.parseInt(denominator.getText()));
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
      displayText.setText(evaluatedCurrentExpression);
      clearText();
      currentTextArea = 0;
      left = result;
      right = null;
      currentOperation = null;
    }
    else if (e.getActionCommand().equals("clear"))
    {
        if (currentTextArea % 3 == 0) {
            whole.setText("");
        } else if (currentTextArea % 3 == 1){
            numerator.setText("");
        } else {
            denominator.setText("");
        }
    }
    else if (e.getActionCommand().equals("sign"))
    {
        if (!whole.getText().isEmpty() || !numerator.getText().isEmpty())
        {
            // Track if the fields were originally empty
            boolean wholeWasEmpty = whole.getText().isEmpty();
            boolean numeratorWasEmpty = numerator.getText().isEmpty();

            int wholeValue = wholeWasEmpty ? 0 : Integer.parseInt(whole.getText());
            int numeratorValue = numeratorWasEmpty ? 0 : Integer.parseInt(numerator.getText());
            int denominatorValue = denominator.getText().isEmpty() ? 1 : Integer.parseInt(denominator.getText());
            
            IrreducedMixedFraction currentFraction = new IrreducedMixedFraction(wholeValue, numeratorValue, denominatorValue);
            Operations.changeSign(currentFraction); // Toggle the sign
            
            // Only update the text fields if they originally had a value
            if (!wholeWasEmpty) {
                whole.setText(Integer.toString(currentFraction.getWhole()));
            }
            if (!numeratorWasEmpty) {
                numerator.setText(Integer.toString(currentFraction.getNumerator()));
            }
            if (denominatorValue != 1) {
                denominator.setText(Integer.toString(currentFraction.getDenominator()));
            }
        }
    }
    else if(e.getActionCommand().equals("zero"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "0");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "0");
      } else {
        denominator.setText(denominator.getText() + "0");
      }      
    } 
    else if(e.getActionCommand().equals("one"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "1");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "1");
      } else {
        denominator.setText(denominator.getText() + "1");
      }
    }
    else if(e.getActionCommand().equals("two"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "2");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "2");
      } else {
        denominator.setText(denominator.getText() + "2");
      }
    }
    else if(e.getActionCommand().equals("three"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "3");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "3");
      } else {
        denominator.setText(denominator.getText() + "3");
      }
    }
    else if(e.getActionCommand().equals("four"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "4");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "4");
      } else {
        denominator.setText(denominator.getText() + "4");
      }
    }
    else if(e.getActionCommand().equals("five"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "5");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "5");
      } else {
        denominator.setText(denominator.getText() + "5");
      }
    }
    else if(e.getActionCommand().equals("six"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "6");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "6");
      } else {
        denominator.setText(denominator.getText() + "6");
      }
    }
    else if(e.getActionCommand().equals("seven"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "7");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "7");
      } else {
        denominator.setText(denominator.getText() + "7");
      }
    }
    else if(e.getActionCommand().equals("eight"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "8");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "8");
      } else {
        denominator.setText(denominator.getText() + "8");
      }
    }
    else if(e.getActionCommand().equals("nine"))
    {
      if (currentTextArea % 3 == 0) {
        whole.setText(whole.getText() + "9");
      } else if (currentTextArea % 3 == 1){
        numerator.setText(numerator.getText() + "9");
      } else {
        denominator.setText(denominator.getText() + "9");
      }
    }
    else if(e.getActionCommand().equals("bar"))
    {
      currentTextArea++;
      if(currentTextArea > 2) currentTextArea = 0; // Loop back to the first text area

      switch(currentTextArea) {
          case 0:
              whole.requestFocus();
              break;
          case 1:
              numerator.requestFocus();
              break;
          case 2:
              denominator.requestFocus();
              break;
      }
    }
    else if (command.equals(reset.getActionCommand())){
      left = null;
      right = null;
      result = null;
      displayText.setText("");
      clearText();
      currentTextArea = 0;
      currentOperation = null;
    }
    else if (command.equals(back.getActionCommand())) {
      if (currentTextArea % 3 == 0) {
          if (whole.getText().isEmpty()) {
              // move focus to denominator and set currentTextArea accordingly
              currentTextArea = 2;
              denominator.requestFocus();
          } else {
              whole.setText(whole.getText().substring(0, whole.getText().length() - 1));
          }
      } else if (currentTextArea % 3 == 1) {
          if (numerator.getText().isEmpty()) {
              // move focus to the previous section whole and set currentTextArea accordingly
              currentTextArea = 0;
              whole.requestFocus();
          } else {
              numerator.setText(numerator.getText().substring(0, numerator.getText().length() - 1));
          }
      } else {
          if (denominator.getText().isEmpty()) {
              // move focus to the previous section numerator and set currentTextArea accordingly
              currentTextArea = 1;
              numerator.requestFocus();
          } else {
              denominator.setText(denominator.getText().substring(0, denominator.getText().length() - 1));
          }
      }
  }
  }
  
  

  public static void main(String[] args)
  {
    new Calculator();
  }
}
