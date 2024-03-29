package GUI.pieChart;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.MenuSetup;
import utilities.IrreducedMixedFraction;
/**
 * Draws pie charts in order to represent mixed numbers.
 * @author Dade Buschy
 * @version 11/13/2023
 */
public class PieChart extends JFrame
{
  private static final long serialVersionUID = 1L;
  private Font font = new Font(Font.SERIF, Font.PLAIN, 30);
  private LineBorder border = new LineBorder(Color.DARK_GRAY, 1);
  private MenuSetup menuSetup;
  /**
   * Creates a new pie chart window given three fractions that represent a whole expression.
   * @param op1 The first operand
   * @param op2 The second operand
   * @param ans The result of the operation
   * @param operator The operator
   **/
  public PieChart(final IrreducedMixedFraction op1, final IrreducedMixedFraction op2,
      final IrreducedMixedFraction ans, final String operator,
      final ResourceBundle messages, final MenuSetup menuSetup)
  {
    this.menuSetup = menuSetup;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setTitle(messages.getString("pieChart.title"));
    setSize(600, 300);
    setLayout(new GridLayout(2, 3));
    String eq = "=";
    //add the string representations of the operands and answer
    JPanel panel1 = makePanel();
    add(panel1);
    panel1.add(makeField(op1.toString()));
    panel1.add(makeField(operator));
    JPanel panel2 = makePanel();
    panel2.add(makeField(op2.toString()));
    panel2.add(makeField(eq));
    add(panel2);
    add(makeField(ans.toString()));
    JPanel panel3 = makePanel();
    panel3.add(new PieChartCanvas(op1));
    panel3.add(makeField(operator));
    add(panel3);
    JPanel panel4 = makePanel();
    panel4.add(new PieChartCanvas(op2));
    panel4.add(makeField(eq));
    add(panel4);
    add(new PieChartCanvas(ans));
    setVisible(true);
    addWindowListener(new WindowAdapter() 
    {
      @Override
      public void windowClosing(final WindowEvent e) 
      {
        PieChart.this.menuSetup.getCheckBoxMenuItem().setSelected(false);
      }
    });
  }
  private JPanel makePanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 2));
    panel.setBorder(border);
    return panel;
  }
  private JTextField makeField(final String str)
  {
    JTextField strField = new JTextField(str);
    strField.setHorizontalAlignment(SwingConstants.CENTER);
    strField.setBackground(Color.DARK_GRAY);
    strField.setFont(font);
    strField.setEnabled(false);
    strField.setBorder(border);
    return strField;
  }
}
