package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

    setTitle("Calculator by ferguszo");

    Container content = getContentPane();
    content.setLayout(new BorderLayout(50, 50));

    content.add(softButtons(), BorderLayout.SOUTH);
    content.add(new JLabel(), BorderLayout.WEST); // Blank Labels to give gaps
    content.add(new JLabel(), BorderLayout.EAST);
    ImageIcon picture = new ImageIcon("Fragile_Logo.png");
    JLabel icon = new JLabel(picture);
    content.add(icon, BorderLayout.NORTH);

    Canvas display = new Canvas();
    display.setBackground(Color.LIGHT_GRAY);
    content.add(display);

    setVisible(true);
    setSize(400, 600);
  }

  private Component softButtons()
  {
    JPanel buttons = new JPanel();
    buttons.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;

    JButton reset = new JButton("R");
    c.gridx = 0;
    c.gridy = 0;
    buttons.add(reset, c);

    JButton clear = new JButton("C");
    c.gridx = 1;
    c.gridy = 0;
    buttons.add(clear, c);

    JButton back = new JButton(Character.toString((char) 171));
    c.gridx = 2;
    c.gridy = 0;
    buttons.add(back, c);
    
    JButton add = new JButton("+");
    c.gridx = (3);
    c.gridy = (0);
    buttons.add(add, c);
    

    JButton sign = new JButton(Character.toString((char) 177));
    c.gridx = (4);
    c.gridy = (0);
    buttons.add(sign, c);
    
    JButton seven = new JButton("7");
    c.gridx = 0;
    c.gridy = 1;
    buttons.add(seven, c);
    
    JButton eight = new JButton("8");
    c.gridx = 1;
    c.gridy = 1;
    buttons.add(eight, c);
    
    JButton nine = new JButton("9");
    c.gridx = 2;
    c.gridy = 1;
    buttons.add(nine, c);
    
    JButton minus = new JButton("-");
    c.gridx = 3;
    c.gridy = 1;
    buttons.add(minus, c);
    
    JButton four = new JButton("4");
    c.gridx = 0;
    c.gridy = 2;
    buttons.add(four, c);
    
    JButton five = new JButton("5");
    c.gridx = 1;
    c.gridy = 2;
    buttons.add(five, c);
    
    JButton six = new JButton("6");
    c.gridx = 2;
    c.gridy = 2;
    buttons.add(six, c);
    
    JButton multiply = new JButton("X");
    c.gridx = 3;
    c.gridy = 2;
    buttons.add(multiply, c);
    
    JButton one = new JButton("1");
    c.gridx = 0;
    c.gridy = 3;
    buttons.add(one, c);
    
    JButton two = new JButton("2");
    c.gridx = 1;
    c.gridy = 3;
    buttons.add(two, c);
    
    JButton three = new JButton("3");
    c.gridx = 2;
    c.gridy = 3;
    buttons.add(three, c);
    
    JButton divide = new JButton(Character.toString((char) 247));
    c.gridx = 3;
    c.gridy = 3;
    buttons.add(divide, c);
    
    JButton bar = new JButton("/");
    c.gridx = 2;
    c.gridy = 4;
    buttons.add(bar, c);
    
    JButton equals = new JButton("=");
    c.gridx = 3;
    c.gridy = 4;
    buttons.add(equals, c);
    
    JButton zero = new JButton("0");
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 4;
    buttons.add(zero, c);
    
    return buttons;
  }

  public static void main(String[] args)
  {
    new Calculator();
  }
}
