package GUI.HistoryWindowStuff;

import javax.swing.*;
import java.awt.*;

public class HistoryWindow extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        HistoryWindow history = new HistoryWindow();
        JPanel[] panels = new JPanel[10];
        JLabel[] labels = new JLabel[10];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            labels[i] = new JLabel("This is label " + i);
            panels[i].add(labels[i]);
            history.addCalculation(panels[i]);
        }
        frame.add(history);
        frame.setVisible(true);
    }

    private JPanel history;

    public HistoryWindow() {
        setLayout(new BorderLayout());

        history = new JPanel();
        history.setLayout(new GridLayout(0, 1));

        add(history, BorderLayout.EAST);

        setVisible(true);
    }

    public void addCalculation(JPanel calculation) {        
        history.add(calculation);
        updateUI();
    }
}
