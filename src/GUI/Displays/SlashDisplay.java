package GUI.Displays;

import javax.swing.*;

import java.awt.*;
import java.util.Locale;

import utilities.*;

/**
 * The SlashDisplay class is for displaying the operand being inputted, the partial current expression, and the evaluated current expression in slash style.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
public class SlashDisplay extends Display {

    JLabel displayExpression;
    JLabel displayOperand;
    
    /**
     * Constructs a new SlashDisplay with an empty current operand and an empty current expression.
     */
    public SlashDisplay(Locale locale) {
        super(locale);
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

    @Override
    public void setErrorMessage(String errorMessage) {
        displayExpression.setText(errorMessage);
    }

    @Override
    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        displayExpression.setText(left.toString() + operation);
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction right, IrreducedMixedFraction result) {
        displayExpression.setText(displayExpression.getText() + right.toString() + "=" + result.toString());
    }

    @Override
    public JPanel getEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right, IrreducedMixedFraction result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        label.setText(left.toString() + operation + right.toString() + "=" + result.toString());
        return panel;
    }

    @Override
    public JPanel getEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right, String result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        label.setText(left.toString() + operation + right.toString() + "=" + result);
        return panel;
    }

    //Helper Methods
    
    @Override
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

    @Override
    protected void clearExpression() {
        displayExpression.setText(" ");
    }      
}
