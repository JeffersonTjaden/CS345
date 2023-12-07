package Recording;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;
import java.util.Scanner;

import GUI.Displays.Display;
import utilities.IrreducedMixedFraction;

public class RecorderPlayback
{
  private String fileName;
  private Display display;
  private boolean paused = false;
  private int delay = 1000;
  private ResourceBundle messages;
  public RecorderPlayback(final String fileName, final Display display, final ResourceBundle messages)
  {
    this.fileName = fileName;
    this.display = display;
    this.messages = messages;
  }
  
  public void playback()
  {
    try
    {
      Scanner scanner = new Scanner(new File(fileName));
      while (scanner.hasNextLine() && !paused)
      {
        display.resetButton();
        String line = scanner.nextLine();
        Object[] args = IrreducedMixedFraction.parseEquation(line);
        display.setPartialExpression((IrreducedMixedFraction)args[0],(String) args[4]);
        display.setEvaluatedExpression((IrreducedMixedFraction) args[1],
            (IrreducedMixedFraction) args[2]);
        Thread.sleep(delay);
      }
    }
    catch (FileNotFoundException e)
    {
      display.setErrorMessage(fileName + " was not found");
    }
    catch (InterruptedException e)
    {
      display.setErrorMessage("Thread was interrupted");
    }
  }
  public void setPaused(boolean paused)
  {
    this.paused = paused;
  }
}
