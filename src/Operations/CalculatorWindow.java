import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * A window containing a PIN entry pad.
 */
public class CalculatorWindow extends JFrame
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Container contentPane;
  private GridBagConstraints gbc;
  private GridBagLayout gbl;
  /**
   * Default Constructor.
   */
  public CalculatorWindow()
  {
    super();
    setupMenu();
    setupLayout();
    setResizable(false);
  }

  /**
   * Setup and layout this PINPadWindow
   */
  private void setupLayout()
  {
    setSize(500, 500);
    setTitle("CALCULATOR");
    

    contentPane = getContentPane();
    gbl = new GridBagLayout();
    gbc = new GridBagConstraints();
    contentPane.setLayout(gbl);
    
    //Logo
    displayLogo();

    //Fractional Display Area
    Display display = new Display();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1;
    gbc.gridwidth = 5;
    gbc.gridheight = 2;
    //gbc.insets = new Insets(20,20,20,20);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    // gbc.weightx = 100;
    // gbc.weighty = 100;
    contentPane.add(display, gbc);

    //Keypad Display Area
    gbc = new GridBagConstraints();
    NumberPad numberPad = new NumberPad(display);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 5;
    gbc.gridheight = 5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.SOUTH;
    // gbc.weightx = 100;
    // gbc.weighty = 0;
    contentPane.add(numberPad, gbc);

    // Outside Border
    //this.getRootPane().setBorder(new EmptyBorder(20,20,20 ,20));
    //(new EmptyBorder(10,10,10,10));
    //this.add(BorderFactory.createEmptyBorder(10,10,10,10));
    ((JComponent) contentPane).setBorder(new EmptyBorder(20,20,20,20));

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    JMenuItem helpItem = new JMenuItem("Help");
    // TODO: add an action listener to helpItem
    helpMenu.add(aboutItem);
    helpMenu.add(helpItem);

    // Add menus to menu bar
    menuBar.add(fileMenu);
    menuBar.add(viewMenu);
    menuBar.add(helpMenu);

    setJMenuBar(menuBar);
  }

  private void displayLogo()
  {
    contentPane = getContentPane();
    gbc = new GridBagConstraints();
    
    ImageIcon picture = new ImageIcon(getClass().getResource("/resources/Fragile_Logo.png"));

    Image img = picture.getImage();
    Image scaledImage = img.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
    picture = new ImageIcon(scaledImage);

    JLabel icon = new JLabel(picture);
    icon.setHorizontalAlignment(SwingConstants.LEFT);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 5;
    gbc.gridheight = 1;
    //gbc.weightx = 0.5;
    //gbc.weighty = 0.5;
    gbc.fill = GridBagConstraints.BOTH;
    contentPane.add(icon, gbc);
  }

}
