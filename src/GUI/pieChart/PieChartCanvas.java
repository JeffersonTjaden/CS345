package GUI.pieChart;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

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
  private final int size = 22;
  private final int numCircles;
  /**
   * Creates a new PieChartCanvas representative of an IrreducedMixedFraction.
   * @param fraction The number to be represented
   */
  public PieChartCanvas(final IrreducedMixedFraction fraction)
  {
    setBackground(Color.DARK_GRAY);
    this.whole = fraction.getWhole();
    this.numerator = fraction.getNumerator();
    this.denominator = fraction.getDenominator();
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
    g.setColor(Color.RED);
    int angle = (int)(((double)(numerator)/denominator) * 360);
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
    g.fillArc(xPos, yPos, size, size, 0, -1 * angle);
  }
}
