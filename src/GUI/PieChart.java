package GUI;
import java.awt.Canvas;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import utilities.IrreducedMixedFraction;
public class PieChart extends JFrame
{
  private static final long serialVersionUID = 1L;
  public PieChart(IrreducedMixedFraction op1, IrreducedMixedFraction op2, IrreducedMixedFraction ans)
  {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setTitle("Current Expression");
    setSize(600, 300);
    setLayout(new GridLayout(2, 3));
    //add the string representations of the operands and answer
    JTextArea op1String = new JTextArea(op1.toString());
    add(op1String);
    JTextArea op2String = new JTextArea(op2.toString());
    add(op2String);
    JTextArea ansString = new JTextArea(ans.toString());
    add(ansString);
    add(new PieChartCanvas(op1));
    add(new PieChartCanvas(op2));
    add(new PieChartCanvas(ans));
    setVisible(true);
  }
}
