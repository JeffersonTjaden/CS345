package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.TextComponent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Calculator extends JFrame
{
  private Container content = getContentPane();
  private GridBagConstraints c = new GridBagConstraints();

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

  private void display(){
    TextArea display = new TextArea();
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

    JButton reset = new JButton("R");
    c.gridx = 0;
    c.gridy = 3;
    content.add(reset, c);

    JButton clear = new JButton("C");
    c.gridx = 1;
    c.gridy = 3;
    content.add(clear, c);

    JButton back = new JButton(Character.toString((char) 171));
    c.gridx = 2;
    c.gridy = 3;
    content.add(back, c);
    
    JButton add = new JButton("+");
    c.gridx = (3);
    c.gridy = (3);
    content.add(add, c);
    

    JButton sign = new JButton(Character.toString((char) 177));
    c.gridx = (4);
    c.gridy = (3);
    content.add(sign, c);
    
    JButton seven = new JButton("7");
    c.gridx = 0;
    c.gridy = 4;
    content.add(seven, c);
    
    JButton eight = new JButton("8");
    c.gridx = 1;
    c.gridy = 4;
    content.add(eight, c);
    
    JButton nine = new JButton("9");
    c.gridx = 2;
    c.gridy = 4;
    content.add(nine, c);
    
    JButton minus = new JButton("-");
    c.gridx = 3;
    c.gridy = 4;
    content.add(minus, c);
    
    JButton four = new JButton("4");
    c.gridx = 0;
    c.gridy = 5;
    content.add(four, c);
    
    JButton five = new JButton("5");
    c.gridx = 1;
    c.gridy = 5;
    content.add(five, c);
    
    JButton six = new JButton("6");
    c.gridx = 2;
    c.gridy = 5;
    content.add(six, c);
    
    JButton multiply = new JButton("X");
    c.gridx = 3;
    c.gridy = 5;
    content.add(multiply, c);
    
    JButton one = new JButton("1");
    c.gridx = 0;
    c.gridy = 6;
    content.add(one, c);
    
    JButton two = new JButton("2");
    c.gridx = 1;
    c.gridy = 6;
    content.add(two, c);
    
    JButton three = new JButton("3");
    c.gridx = 2;
    c.gridy = 6;
    content.add(three, c);
    
    JButton divide = new JButton(Character.toString((char) 247));
    c.gridx = 3;
    c.gridy = 6;
    content.add(divide, c);
    
    JButton bar = new JButton("/");
    c.gridx = 2;
    c.gridy = 7;
    content.add(bar, c);
    
    JButton equals = new JButton("=");
    c.gridx = 3;
    c.gridy = 7;
    content.add(equals, c);
    
    JButton zero = new JButton("0");
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 7;
    content.add(zero, c);
  }

  public static void main(String[] args)
  {
    new Calculator();
  }
}
