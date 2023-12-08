package Recording;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TimerTask;

import GUI.Displays.Display;
import utilities.IrreducedMixedFraction;

public class RecorderPlayback extends Thread
{
  private Display display;
  private boolean paused = false;
  private Scanner scanner;
  private boolean canRun = true;
  private int delay;
  public RecorderPlayback(final File file, final Display display)
  {
    this.display = display;
    try 
    {
      scanner = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      display.setErrorMessage(file.getName() + " was not found");
    }
  }
  public void setPaused(boolean paused)
  {
    this.paused = paused;
  }
  public boolean isPaused()
  {
    return paused;
  }
  public void setDelay(int delay)
  {
    this.delay = delay;
  }
  public Scanner getScanner()
  {
    return scanner;
  }
  public boolean canRun()
  {
    return canRun;
  }
  @Override
  public void run()
  {
    // TODO Auto-generated method stub
    while (scanner.hasNextLine())
    {
      canRun = false;
      while (paused)
        Thread.onSpinWait();
      display.resetButton();
      String line = scanner.nextLine();
      Object[] args = IrreducedMixedFraction.parseEquation(line);
      display.setPartialExpression((IrreducedMixedFraction)args[0],(String) args[3]);
      display.setEvaluatedExpression((IrreducedMixedFraction) args[1],
          (IrreducedMixedFraction) args[2]);
      try
      {
        Thread.sleep(delay);
      }
      catch (InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
