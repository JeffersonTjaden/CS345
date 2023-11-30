package Recording;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculationRecorder {
    private List<String> recordedCalculations;
    private boolean isRecording;
    private JDialog recordingControlsDialog;
    private JButton recordButton, pauseButton, stopButton;
    private JTextField fileNameField;
    private File file;

    public CalculationRecorder(JFrame frame) {
        recordedCalculations = new ArrayList<>();
        createRecordingControlsDialog(frame);
    }

    public void createRecordingControlsDialog(JFrame frame) {
        recordingControlsDialog = new JDialog(frame, "Recording Controls");
        recordingControlsDialog.setLayout(new FlowLayout());
        
        recordButton = new JButton(new ImageIcon(getClass().getResource("/resources/record.png")));
        pauseButton = new JButton(new ImageIcon(getClass().getResource("/resources/pause.png")));
        stopButton = new JButton(new ImageIcon(getClass().getResource("/resources/stop.png")));
        fileNameField = new JTextField(20);
        
        Dimension buttonSize = new Dimension(40, 40);
        recordButton.setPreferredSize(buttonSize);
        pauseButton.setPreferredSize(buttonSize);
        stopButton.setPreferredSize(buttonSize);

        recordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
              startRecording();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pauseRecording();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopRecording();
                recordingControlsDialog.dispose();
            }
        });

        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        recordingControlsDialog.add(recordButton);
        recordingControlsDialog.add(pauseButton);
        recordingControlsDialog.add(stopButton);

        recordingControlsDialog.pack();
        recordingControlsDialog.setSize(300, recordingControlsDialog.getHeight());
        recordingControlsDialog.setLocationRelativeTo(frame);
    }

    public void showRecordingControlsDialog(File file) {
        if (!file.getName().toLowerCase().endsWith(".txt")) {
          file = new File(file.getParentFile(), file.getName() + ".txt");
        }
        this.file = file;
        fileNameField.setText(file.getName());
        recordingControlsDialog.setTitle("Record to: " + file.getName());
        recordingControlsDialog.setVisible(true);
    }

    public void startRecording() {
        isRecording = true;
        recordButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    public void pauseRecording() {
        // Logic for pausing the recording
        isRecording = false; // For example purposes, toggling recording status
        recordButton.setEnabled(true);
        pauseButton.setEnabled(false);
    }

    public void stopRecording() {
        isRecording = false;
        saveToFile();
        recordedCalculations.clear();
        recordButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    public void recordCalculation(String calculation) {
        if (isRecording) {
          recordedCalculations.add(calculation);
        }
    }

    private void saveToFile() {
        // Actual file saving logic using 'file' field
        try (FileWriter writer = new FileWriter(file)) {
            for (String calculation : recordedCalculations) {
                writer.write(calculation + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception properly
        }
    }
  
    public boolean isRecording() {
      return isRecording;
    }
  }