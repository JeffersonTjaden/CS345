package Recording;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.Displays.Display;

public class PlaybackController extends JDialog
{
  private JFrame frame;
  private Display display;
  private RecorderPlayback playback;
  private JButton playButton;
  private JButton pauseButton;
  private JButton stopButton;
  private JSlider slider;
  private Timer timer;
  public PlaybackController(final JFrame frame, final Display display)
  {
    super(frame, "Playback Controls");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.display = display;
    setup();
  }
  private void setup()
  {
    JFileChooser chooser = new JFileChooser();
    int opt = chooser.showOpenDialog(this);
    while (opt != JFileChooser.APPROVE_OPTION)
    {
      opt = chooser.showOpenDialog(this);
    }
    File file = chooser.getSelectedFile();
    setLayout(new FlowLayout());
    
    playback = new RecorderPlayback(file, display);
    playButton = new JButton(new ImageIcon(getClass().getResource("/resources/play.png")));
    pauseButton = new JButton(new ImageIcon(getClass().getResource("/resources/pause.png")));
    stopButton = new JButton(new ImageIcon(getClass().getResource("/resources/stop.png")));
    slider = new JSlider(0, 5000, 1000);
    playback.setDelay(slider.getValue());
    timer = new Timer();
    
    Dimension buttonSize = new Dimension(40, 40);
    playButton.setPreferredSize(buttonSize);
    pauseButton.setPreferredSize(buttonSize);
    stopButton.setPreferredSize(buttonSize);
    
    setTitle("Playback from: " + file.getName());
    pack();
    setSize(500, 150);
    setLocationRelativeTo(frame);
    setVisible(true);
    
    playButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e) 
      { 
        play();
      }
    });
    
    pauseButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e) 
      {
        pause();
      }
    });

    stopButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e) 
      {
        stop();
      }
    });
    
    slider.addChangeListener(new ChangeListener()
    {
      public void stateChanged(final ChangeEvent e)
      {
        playback.setDelay(slider.getValue());
      }
    });
    pauseButton.setEnabled(false);
    stopButton.setEnabled(false);

    add(playButton);
    add(pauseButton);
    add(stopButton);
    add(slider);
  }
  private void pause()
  {
    playback.setPaused(true);
    playButton.setEnabled(true);
    pauseButton.setEnabled(false);
    stopButton.setEnabled(false);
    timer.purge();
  }
  private void play()
  {
    playback.setPaused(false);
    playButton.setEnabled(false);
    pauseButton.setEnabled(true);
    stopButton.setEnabled(true);
    if (playback.canRun())
      playback.start();
  }
  private void stop()
  {
    pause();
    dispose();
  }
}
