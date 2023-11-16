package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import java.awt.BorderLayout;

public class About extends JDialog {

    public About(JFrame parent, ResourceBundle messages) {
        super(parent, messages.getString("about.title"), true);
        
        // Set size of the dialog
        setSize(400, 250);

        // Set up the content for the dialog
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel labelTitle = new JLabel(messages.getString("about.version"));
        JLabel labelDescription = new JLabel(messages.getString("about.description"));
        JLabel labelCompany = new JLabel(messages.getString("about.company"));
        JLabel labelDevelopers = new JLabel(messages.getString("about.developers"));
        
        // Center-align the text in the labels
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelDescription.setHorizontalAlignment(JLabel.CENTER);
        labelCompany.setHorizontalAlignment(JLabel.CENTER);
        labelDevelopers.setHorizontalAlignment(JLabel.CENTER);

        panel.add(labelTitle);
        panel.add(labelDescription);
        panel.add(labelCompany);
        panel.add(labelDevelopers);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Fragile_Icon_32x32.png"));
        JLabel labelIcon = new JLabel(imageIcon);
        labelIcon.setHorizontalAlignment(JLabel.CENTER);
        
        getContentPane().add(labelIcon, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(parent); // Centers the dialog relative to the parent frame
    }
}
