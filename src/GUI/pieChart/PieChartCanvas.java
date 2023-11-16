package GUI.pieChart;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import utilities.IrreducedMixedFraction;

/**
 * Class to be used in order to represent numbers in PieChart.java.
 * @author Dade Buschy
 * @version 11/13/2023
 */
public class PieChartCanvas extends Canvas
{
  private static final long serialVersionUID = 1L;
  private int whole;
  private int numerator;
  private int denominator;
  private int xPos;
  private int yPos;
  private boolean sign;
  private final int size = 30;
  private final Integer numCircles;
  /**
   * Creates a new PieChartCanvas representative of an IrreducedMixedFraction.
   * @param fraction The number to be represented
   */
  public PieChartCanvas(final IrreducedMixedFraction fraction)
  {
    setBackground(Color.DARK_GRAY);
    fraction.reduce();
    this.whole = fraction.getWhole();
    this.numerator = fraction.getNumerator();
    this.denominator = fraction.getDenominator();
    this.sign = fraction.getSign();
    numCircles = (int) Math.ceil(whole + (float)(numerator)/denominator);
  }
  /**
   * Paints the canvas with whole number circles and a numerator/denominator partial circle.
   * @param g The canvas's innate graphics context
   */
  public void paint(final Graphics g)
  {
    xPos = 0;
    int rows = numCircles * size/getWidth();
    yPos = getHeight()/2 - ((rows - 1) / 2) * (size);
    if (sign) g.setColor(Color.RED);
    else g.setColor(Color.GREEN);
    int angle = (int)(((double)(numerator)/denominator) * 360);
    if (numCircles <= 100)
    {
      for (int i = 0; i < whole; i++)
      {
        g.fillOval(xPos, yPos, size, size);
        xPos += size;
        if (xPos + size >= this.getWidth())
        {
          xPos = 0;
          yPos += size;
        }
      }
    } else
    {
      Font font = new Font("Serif", Font.BOLD, 15);
      g.fillOval(xPos, yPos, size, size);
      g.setColor(Color.BLACK);
      g.setFont(font);
      g.drawString(numCircles.toString(), xPos+5, yPos+20);
      xPos += size;
      if (sign) g.setColor(Color.RED);
      else g.setColor(Color.GREEN);
    }
    g.fillArc(xPos, yPos, size, size, 0, -1 * angle);
  }
}
