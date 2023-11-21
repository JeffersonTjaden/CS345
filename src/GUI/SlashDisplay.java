package GUI;

import javax.swing.*;
import java.awt.*;
import utilities.*;

public class SlashDisplay extends Display {

    JLabel displayExpression;
    JLabel displayOperand;
    
    public SlashDisplay() {
        setLayout(new BorderLayout());

        displayExpression = new JLabel();
        displayOperand = new JLabel();

        setBackground(Color.white);
        displayExpression.setBackground(Color.white);
        displayOperand.setBackground(Color.white);

        add(displayExpression, BorderLayout.NORTH);
        add(displayOperand, BorderLayout.EAST);

        displayExpression.setText(" ");

        whole = "_";
        numerator = "_";
        denominator = "_";
        signText = "";
        signBool = true;
        updateOperand();

        setVisible(true);
    }

    //Getter and Setter Methods

    public void setExpression(String errorMessage) {
        displayExpression.setText(errorMessage);
    }

    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        displayExpression.setText(left.toString() + operation);
        clearOperand();
    }

    public void setEvaluatedExpression(IrreducedMixedFraction right, IrreducedMixedFraction result) {
        displayExpression.setText(displayExpression.getText() + right.toString() + "=" + result.toString());
    }

    //Helper Methods

      protected void updateOperand() {
        String text = "";
        String wholePart = whole + " ";
        String numeratorPart = numerator + "/";
        String denominatorPart = denominator;
    
        String focusedStyle = "<span style='background-color:#D3D3D3; color:black;'>%s</span>"; // Changed color for visibility
    
        switch (currentPosition % 3) {
            case 0:
                text = String.format(focusedStyle, wholePart) + numeratorPart + denominatorPart;
                break;
            case 1:
                text = wholePart + String.format(focusedStyle, numeratorPart) + denominatorPart;
                break;
            case 2:
                text = wholePart + numeratorPart + String.format(focusedStyle, denominatorPart);
                break;
        }
    
        text = "<html>" + signText + text + "</html>";
        displayOperand.setText(text);
    }

    protected void clearExpression() {
        displayExpression.setText(" ");
    }      
}
