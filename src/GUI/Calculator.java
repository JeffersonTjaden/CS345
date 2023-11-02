package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utilities.*;

public class Calculator extends JFrame implements ActionListener
{
  private Container content = getContentPane();
  private GridBagConstraints c = new GridBagConstraints();
  private TextArea display = new TextArea(5, 2);

  private IrreducedMixedFraction left;
  private IrreducedMixedFraction right;
  private IrreducedMixedFraction result;
  private String currentOperation;
  private String partialCurrentExpression;
  private String evaluatedCurrentExpression;

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
    // TODO: add an action listener to pieChartItem if needed
    viewMenu.add(pieChartItem);

    // Create Help menu with About and Help items
    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    aboutItem.addActionListener(e -> {
      About aboutDialog = new About(Calculator.this);
      aboutDialog.setVisible(true);
    });
    JMenuItem helpItem = new JMenuItem("Help");
    // TODO: add an action listener to helpItem if needed
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

    ImageIcon picture = new ImageIcon("Fragile_Logo.png");
    JLabel icon = new JLabel(picture);

    Canvas display = new Canvas();
    display.setBackground(Color.LIGHT_GRAY);

    setVisible(true);
    setSize(400, 600);
  }

  private void display()
  {
    display.setEditable(false);
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

  @Override
  public void actionPerformed(ActionEvent e)
  {
    /*
    String command = e.getActionCommand();
    if (add.getActionCommand().equals(command))
    {
      currentOperation = "+";
      partialCurrentExpression = left.toString() + currentOperation;
    }
    else if (minus.getActionCommand().equals(command))
    {
      currentOperation = "-";
      partialCurrentExpression = left.toString() + currentOperation;
    }
    else if (multiply.getActionCommand().equals(command))
    {
      currentOperation = "*";
      partialCurrentExpression = left.toString() + currentOperation;
    }
    else if (divide.getActionCommand().equals(command))
    {
      currentOperation = "/";
      partialCurrentExpression = left.toString() + currentOperation;
    }
    else if (equals.getActionCommand().equals(command))
    {
      switch (currentOperation)
      {
        case "+":
          result = Operations.add(left, right);
          evaluatedCurrentExpression = partialCurrentExpression + "=" + result.toString();
        case "-":
          result = Operations.subtract(left, right);
          evaluatedCurrentExpression = partialCurrentExpression + "=" + result.toString();
        case "*":
          result = Operations.multiply(left, right);
          evaluatedCurrentExpression = partialCurrentExpression + "=" + result.toString();
        case "/":
          result = Operations.divide(left, right);
          evaluatedCurrentExpression = partialCurrentExpression + "=" + result.toString();
      }
    }
    */
    
    if(e.getActionCommand().equals("zero"))
    {
      display.setText(display.getText() + "0");
    } 
    else if(e.getActionCommand().equals("one"))
    {
      display.setText(display.getText() + "1");
    }
    else if(e.getActionCommand().equals("two"))
    {
      display.setText(display.getText() + "2");
    }
    else if(e.getActionCommand().equals("three"))
    {
      display.setText(display.getText() + "3");
    }
    else if(e.getActionCommand().equals("four"))
    {
      display.setText(display.getText() + "4");
    }
    else if(e.getActionCommand().equals("five"))
    {
      display.setText(display.getText() + "5");
    }
    else if(e.getActionCommand().equals("six"))
    {
      display.setText(display.getText() + "6");
    }
    else if(e.getActionCommand().equals("seven"))
    {
      display.setText(display.getText() + "7");
    }
    else if(e.getActionCommand().equals("eight"))
    {
      display.setText(display.getText() + "8");
    }
    else if(e.getActionCommand().equals("nine"))
    {
      display.setText(display.getText() + "9");
    }

    if(e.getActionCommand().equals("bar"))
    {
      left.setNumerator(5);
      display.setText(display.getText() + "/");
    }
  }

  public static void main(String[] args)
  {
    new Calculator();
  }
}
