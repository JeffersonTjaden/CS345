package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class About extends JDialog {

    public About(JFrame parent) {
        super(parent, "About", true); // 'true' makes the dialog modal
        
        // Set size of the dialog
        setSize(400, 250);

        // Set up the content for the dialog
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel labelTitle = new JLabel("Fragile v1.0");
        JLabel labelDescription = new JLabel("Fragile is a modern, easy-to-use mixed-fraction calculator.");
        JLabel labelCompany = new JLabel("It is a product of Sagacious Media that was developed by:");
        JLabel labelDevelopers = new JLabel("Zachary Ferguson, Dade Buschy, Ben Curtis, Sean Halloran, Christopher Hoon and Jefferson Tjaden");
        
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
