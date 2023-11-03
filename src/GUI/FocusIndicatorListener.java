package GUI;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusIndicatorListener implements FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
        TextArea source = (TextArea) e.getSource();
        source.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void focusLost(FocusEvent e) {
        TextArea source = (TextArea) e.getSource();
        source.setBackground(Color.WHITE); // revert back to original color on loss of focus
    }
}
