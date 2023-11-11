import java.awt.Dimension;

import javax.swing.JButton;

public class MyButton extends JButton
{
  private NumberPad container;
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public MyButton(String text) {
    super(text);
  }
  
  public MyButton(String text, NumberPad container) {
    super(text);
    this.container = container;
  }
  
  public Dimension getMinimumSize() {
    return new Dimension(60, 60);
  }

  public Dimension getPreferredSize() {
    return new Dimension(60, 60);
  }
  
  public Dimension getMaximumSize() {
    return new Dimension(60, 60);
  }
}

