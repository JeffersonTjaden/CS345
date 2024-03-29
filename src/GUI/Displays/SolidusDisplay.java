package GUI.Displays;

import javax.swing.*;

import utilities.*;

import java.awt.*;
import java.util.Locale;

/**
 * The SolidusDisplay class is for displaying the operand being inputted, the partial current expression, and the evaluated current expression in solidus style.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
public class SolidusDisplay extends Display {

    private JLabel displayExpression;
    private JLabel displayOperand;

    /**
     * Constructs a new SolidusDisplay with an empty current operand and an empty current expression.
     */
    public SolidusDisplay(Locale locale) {
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
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        displayExpression.setText(errorMessage);
    }

    @Override
    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        displayExpression.setText("<html>" + left.toSolidusString() + operation + "</html>");
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction right, IrreducedMixedFraction result) {
        displayExpression.setText(displayExpression.getText().substring(0, displayExpression.getText().length() - 7) + right.toSolidusString() + "=" + result.toSolidusString() + "</html>");
    }

    @Override
    public JPanel getEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right, IrreducedMixedFraction result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        label.setText("<html>" + left.toSolidusString() + operation + right.toSolidusString() + "=" + result.toSolidusString() + "</html>");
        return panel;
    }

    @Override
    public JPanel getEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right, String result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        label.setText("<html>" + left.toSolidusString() + operation + right.toSolidusString() + "=" + result + "</html>");
        return panel;
    }

    @Override
    protected void updateOperand() {
        String text = "";
        String wholePart = whole + " ";
        String numeratorPart = "<sup>" + numerator + "</sup>" + "/";
        String denominatorPart = "<sub>" + denominator + "</sub>";
    
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