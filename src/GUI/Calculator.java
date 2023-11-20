package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import utilities.*;

public class Calculator extends JFrame implements ActionListener, ComponentListener, WindowStateListener
{
  private JPanel content = (JPanel) getContentPane();
  private GridBagConstraints c = new GridBagConstraints();
  private Display display;
  
  private ResourceBundle messages;
  
  private boolean isReducedForm;
  private boolean isProperForm;

  private boolean slashDisplay;
  private boolean solidusDisplay;
  private boolean barDisplay;
  
  private ArrayList<Object> pieChartOps = new ArrayList<Object>();
  private boolean canCreatePieChart;
  
  private IrreducedMixedFraction left;
  private IrreducedMixedFraction right;
  private IrreducedMixedFraction result;
  private String currentOperation;
  private String partialCurrentExpression;
  private String evaluatedCurrentExpression;

  //Number Buttons
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

  //Operations Buttons
  private JButton add;
  private JButton minus;
  private JButton multiply;
  private JButton divide;
  private JButton equals;

  //Action Buttons
  private JButton reset;
  private JButton clear;
  private JButton back;
  private JButton changeSign;
  private JButton bar;
  private JButton mediant;
  private JButton intPower;
  private JButton simplification;
  private JButton invert;

  //History display objects
  private JTextPane calcHistory;
  private JWindow history;
  private boolean expand = true;
  private JScrollPane scrollable;

  public Calculator()
  {
    this(Locale.getDefault());
  }
  
  //Overloaded constructor accepting a Locale.
  public Calculator(Locale locale) {
      setupInputMap();
      setupLayout(locale);
      displayHistory();
  }

  private void setupInputMap() {
    InputMap inputMap = content.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "0");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "1");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "2");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "3");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "4");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "5");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "6");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "7");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "8");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "9");
    
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "\u232B");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
    
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "=");
    
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "\u00D7");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "\u00F7");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "-");
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "+");
    
    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), ".");
  }

  private void setupLayout(Locale locale)
  {
    this.messages = ResourceBundle.getBundle("resources.MessagesBundle", locale);
    pack();

    // Menu bar
    MenuSetup menuSetup = new MenuSetup(this, this, locale);
    JMenuBar menuBar = menuSetup.createMenuBar();
    setJMenuBar(menuBar);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setTitle(messages.getString("calculator.title"));

    content = (JPanel) getContentPane();
    content.setLayout(new GridBagLayout());
    
    
    display();
    softButtons();
    displayLogo();
    

    setVisible(true);
    setSize(400, 600);
    setAlwaysOnTop(true);
    addComponentListener(this);
    addWindowStateListener(this);
  }
  

  
  private void displayLogo() 
  {
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
    display = new BarDisplay();
    slashDisplay = true;
    solidusDisplay = false;
    barDisplay = false;
    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 2;
    c.gridwidth = 6;
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
    ActionMap actionMap = content.getActionMap();
    actionMap.put("\u232B", new ClickAction(back));
    c.gridx = 2;
    c.gridy = 3;
    content.add(back, c);

    add = new JButton("+");
    add.setActionCommand("add");
    add.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("+", new ClickAction(add));
    c.gridx = (3);
    c.gridy = (3);
    content.add(add, c);

    mediant = new JButton("↔");
    mediant.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    mediant.setActionCommand("mediant");
    mediant.addActionListener(this);
    c.gridx = 4;
    c.gridy = 3;
    content.add(mediant, c);

    changeSign = new JButton(Character.toString((char) 177));
    changeSign.setActionCommand("sign");
    changeSign.addActionListener(this);
    c.gridx = (5);
    c.gridy = (3);
    content.add(changeSign, c);

    seven = new JButton("7");
    seven.setActionCommand("seven");
    seven.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("7", new ClickAction(seven));
    c.gridx = 0;
    c.gridy = 4;
    content.add(seven, c);

    eight = new JButton("8");
    eight.setActionCommand("eight");
    eight.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("8", new ClickAction(eight));
    c.gridx = 1;
    c.gridy = 4;
    content.add(eight, c);

    nine = new JButton("9");
    nine.setActionCommand("nine");
    nine.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("9", new ClickAction(nine));
    c.gridx = 2;
    c.gridy = 4;
    content.add(nine, c);

    minus = new JButton("-");
    minus.setActionCommand("minus");
    minus.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("-", new ClickAction(minus));
    c.gridx = 3;
    c.gridy = 4;
    content.add(minus, c);

    intPower = new JButton("xⁿ");
    intPower.setActionCommand("intPower");
    intPower.addActionListener(this);
    c.gridx = 4;
    c.gridy = 4;
    content.add(intPower, c);

    invert = new JButton("Inv");
    invert.setActionCommand("invert");
    invert.addActionListener(this);
    c.gridx = 5;
    c.gridy = 4;
    content.add(invert, c);

    four = new JButton("4");
    four.setActionCommand("four");
    four.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("4", new ClickAction(four));
    c.gridx = 0;
    c.gridy = 5;
    content.add(four, c);

    five = new JButton("5");
    five.setActionCommand("five");
    five.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("5", new ClickAction(five));
    c.gridx = 1;
    c.gridy = 5;
    content.add(five, c);

    six = new JButton("6");
    six.setActionCommand("six");
    six.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("6", new ClickAction(six));
    c.gridx = 2;
    c.gridy = 5;
    content.add(six, c);

    multiply = new JButton("X");
    multiply.setActionCommand("multiply");
    multiply.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("\u00D7", new ClickAction(multiply));
    c.gridx = 3;
    c.gridy = 5;
    content.add(multiply, c);

    simplification = new JButton("↓");
    simplification.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    simplification.setActionCommand("simplification");
    simplification.addActionListener(this);
    c.gridx = 5;
    c.gridy = 5;
    content.add(simplification, c);

    one = new JButton("1");
    one.setActionCommand("one");
    one.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("1", new ClickAction(one));
    c.gridx = 0;
    c.gridy = 6;
    content.add(one, c);

    two = new JButton("2");
    two.setActionCommand("two");
    two.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("2", new ClickAction(two));
    c.gridx = 1;
    c.gridy = 6;
    content.add(two, c);

    three = new JButton("3");
    three.setActionCommand("three");
    three.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("3", new ClickAction(three));
    c.gridx = 2;
    c.gridy = 6;
    content.add(three, c);

    divide = new JButton(Character.toString((char) 247));
    divide.setActionCommand("divide");
    divide.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("\u00F7", new ClickAction(divide));
    c.gridx = 3;
    c.gridy = 6;
    content.add(divide, c);

    bar = new JButton("/");
    bar.setActionCommand("bar");
    bar.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put(".", new ClickAction(bar));
    c.gridx = 2;
    c.gridy = 7;
    content.add(bar, c);

    equals = new JButton("=");
    equals.setActionCommand("equals");
    equals.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("=", new ClickAction(equals));
    c.gridx = 3;
    c.gridy = 7;
    content.add(equals, c);

    zero = new JButton("0");
    zero.setActionCommand("zero");
    zero.addActionListener(this);
    actionMap = content.getActionMap();
    actionMap.put("0", new ClickAction(zero));
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 7;
    content.add(zero, c);
  }

  private void operatorButtonClicked(final String operation) 
  {
    if (left == null) 
    {          
      left = display.getFraction();
    }
    if (isProperForm) {
      left.reduce();
    }
    if (isReducedForm) {
      left.simplify();
    }
    partialCurrentExpression = left.toString() + operation;
    display.setPartialExpression(left, operation);
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {      
    String command = e.getActionCommand();
    if (add.getActionCommand().equals(command))
    {
      currentOperation = "+";
      operatorButtonClicked("+");
    }
    else if (minus.getActionCommand().equals(command))
    {
      currentOperation = "-";
      operatorButtonClicked("-");
    }
    else if (multiply.getActionCommand().equals(command))
    {
      currentOperation = "*";
      operatorButtonClicked("*");
    }
    else if (divide.getActionCommand().equals(command))
    {
      currentOperation = "/";
      operatorButtonClicked(Character.toString((char) 247));
    }
    else if (mediant.getActionCommand().equals(command)) {
      currentOperation = "mediant";
      operatorButtonClicked("⇹");
    }
    else if (intPower.getActionCommand().equals(command)) {
      currentOperation = "power";
      operatorButtonClicked("^");
    }
    else if (invert.getActionCommand().equals(command)) {
      IrreducedMixedFraction temp = display.getFraction();
      temp.invert();
      display.setOperand(temp);
    }
    else if (simplification.getActionCommand().equals(command)){
      IrreducedMixedFraction temp = display.getFraction();
      temp.simplify();
      temp.reduce();
      display.setOperand(temp);
    }
    else if (equals.getActionCommand().equals(command))
    {
      if (left != null) {
        right = display.getFraction();
      }
      IrreducedMixedFraction leftTemp = new IrreducedMixedFraction(left.getWhole(), left.getNumerator(), left.getDenominator(), left.getSign());
      IrreducedMixedFraction rightTemp = new IrreducedMixedFraction(right.getWhole(), right.getNumerator(), right.getDenominator(), right.getSign());
      switch (currentOperation)
      {        
        case "+":
          result = Operations.add(leftTemp, rightTemp);
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("+");
          canCreatePieChart = true;
          break;         
        case "-":
          result = Operations.subtract(leftTemp, rightTemp);
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("-");
          canCreatePieChart = true;
          break;
        case "*":
          result = Operations.multiply(leftTemp, rightTemp);
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("*");
          canCreatePieChart = true;
          break;          
        case "/":
        if (right.getWhole() != 0 || right.getNumerator() != 0) {
          result = Operations.divide(leftTemp, rightTemp);
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("÷");
          canCreatePieChart = true;
        } else {
          display.setExpression("Get a load of this silly goose dude, somebody feed him some bread he goin crazy");
        }
          break;         
        case "power":
          if (right.getSign()) 
          {
            result = Operations.exponent(left, right.getWhole());
          } else 
          {
            result = Operations.exponent(left, -right.getWhole());
          }
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("^");
          break;   
        case "mediant":
          result = Operations.mediant(left, right);
          pieChartOps.clear();
          pieChartOps.add(left);
          pieChartOps.add(right);
          pieChartOps.add(result);
          pieChartOps.add("⇹");
          break;
        default:
          break;
      }
      if (isProperForm) {
        right.reduce();
        result.reduce();
      }
      if (isReducedForm) {
        right.simplify();
        result.simplify();
      }
      evaluatedCurrentExpression = partialCurrentExpression + right.toString() + "="
          + result.toString();
      display.setEvaluatedExpression(right, result);
      calcHistory.setText(calcHistory.getText() + evaluatedCurrentExpression + "\n"); // Add to display window
      System.out.println(calcHistory.getText());
      left = null;
      right = null;
      currentOperation = null;
      display.setOperand(result);
      result = null;
    }
    else if (e.getActionCommand().equals("clear"))
    {
      display.clearButton();
    }
    else if (e.getActionCommand().equals("sign"))
    {
        display.signButton();
                
    }
    else if(e.getActionCommand().equals("zero"))
    {
      display.numberButtons(0);    
    } 
    else if(e.getActionCommand().equals("one"))
    {
      display.numberButtons(1);
    }
    else if(e.getActionCommand().equals("two"))
    {
      display.numberButtons(2);
    }
    else if(e.getActionCommand().equals("three"))
    {
      display.numberButtons(3);
    }
    else if(e.getActionCommand().equals("four"))
    {
      display.numberButtons(4);
    }
    else if(e.getActionCommand().equals("five"))
    {
      display.numberButtons(5);
    }
    else if(e.getActionCommand().equals("six"))
    {
      display.numberButtons(6);
    }
    else if(e.getActionCommand().equals("seven"))
    {
      display.numberButtons(7);
    }
    else if(e.getActionCommand().equals("eight"))
    {
      display.numberButtons(8);
    }
    else if(e.getActionCommand().equals("nine"))
    {
      display.numberButtons(9);
    }
    else if(e.getActionCommand().equals("bar"))
    {
      if (currentOperation == null || !currentOperation.equals("power")) {
        display.positionButton();
      }
    }
    else if (command.equals(reset.getActionCommand())){
      display.resetButton();
      left = null;
      right = null;
      result = null;
      currentOperation = null;
      canCreatePieChart = false;
    }
    else if (command.equals(back.getActionCommand())) {
      display.backspaceButton();
  }
  }
  
  public boolean getCanCreatePieChart() {
    return canCreatePieChart;
  }
  
  public ArrayList<Object> getPieChartOps() {
    return pieChartOps;
  }
  
  public void setProperForm(boolean isProper) {
    this.isProperForm = isProper;
  }
  
  public void setReducedForm(boolean isReduced) {
    this.isReducedForm = isReduced;
  }
  
  public void displayHistory(){
    history = new JWindow();
    history.setSize(400, getHeight()/2);
    history.setLocation((int)getLocation().getX() + 50, (int)getLocation().getY() + 150);
    history.setLayout(new BorderLayout());

    JButton toggle = new JButton(">");
    toggle.setPreferredSize(new Dimension(50, 50));

    toggle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        if(expand){
          for(int i = 0; i < 30; i++){
            history.setSize(history.getWidth() + 10, history.getHeight());
            try {
              TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e1) {e1.printStackTrace();}
          }
          expand = false;
          toggle.setLabel("<");
        } else{
          while(history.getWidth() > getWidth()){
            history.setSize(history.getWidth() - 10, history.getHeight());
            try {
              TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e1) {e1.printStackTrace();}
          }
          expand = true;
          toggle.setLabel(">");
        }
      }
    });

    calcHistory = new JTextPane();

    // These four lines are used to align the text to the right
    StyledDocument style = calcHistory.getStyledDocument();
    SimpleAttributeSet align = new SimpleAttributeSet();
    StyleConstants.setAlignment(align, StyleConstants.ALIGN_RIGHT);
    style.setParagraphAttributes(0, style.getLength(), align, false);

    scrollable = new JScrollPane(calcHistory);
    scrollable.setBorder(null);

    history.add(scrollable, BorderLayout.CENTER);
    history.add(toggle, BorderLayout.EAST);
    history.setVisible(true);
  }
  
  public void printHistory() {
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setJobName("Calculator History");

    printerJob.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Print the content of calcHistory
            calcHistory.printAll(graphics);

            return PAGE_EXISTS;
        }
    });

    boolean doPrint = printerJob.printDialog();
    if (doPrint) {
        try {
            printerJob.print();
        } catch (PrinterException e) {
        }
    }
  }

  @Override
  public void componentResized(ComponentEvent e) {
    history.setSize(getWidth(), getHeight()/2);
    history.setLocation((int)getLocation().getX() + 50, (int)getLocation().getY() + getHeight()/4);
  }

  @Override
  public void componentMoved(ComponentEvent e) {
    history.setLocation((int)getLocation().getX() + 50, (int)getLocation().getY() + getHeight()/4);
  }

  @Override
  public void componentShown(ComponentEvent e) {};

  @Override
  public void componentHidden(ComponentEvent e) {};

  @Override
  public void windowStateChanged(WindowEvent e) {
    if(history.isVisible()){
      history.setVisible(false);
    } else{
      history.setVisible(true);
    }
  }

  public static void main(String[] args)
  {
    Locale locale = Locale.getDefault();
    
    if (args.length == 2) {
      locale = new Locale(args[0], args[1]);
    }
    new Calculator(locale);
  }
}
