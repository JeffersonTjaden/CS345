package Recording;

import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PlaybackController extends JDialog
{
  private JFrame frame;
  private ResourceBundle messages;
  public PlaybackController(final JFrame frame, final ResourceBundle messages)
  {
    
    super(frame);
    this.messages = messages;
  }
  private void setup()
  {
    
  }
}
