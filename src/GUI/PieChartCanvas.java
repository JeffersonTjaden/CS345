package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import utilities.IrreducedMixedFraction;

public class PieChartCanvas extends Canvas
{
  private IrreducedMixedFraction fraction;
  private int xPos;
  private final int yPos = 20;
  private final int size = 40;
  public PieChartCanvas(final IrreducedMixedFraction fraction)
  {
    this.fraction = fraction;
    xPos = 0;
  }
  public void paint(final Graphics g)
  {
    g.setColor(Color.RED);
    int angle = (int)(((double)(fraction.getNumerator())/fraction.getDenominator()) * 360);
    for (int i = 0; i < fraction.getWhole(); i++)
    {
      g.fillOval(xPos, yPos, size, size);
      xPos += size;
    }
    g.fillArc(xPos, yPos, size, size, 0, -1 * angle);
  }
}
