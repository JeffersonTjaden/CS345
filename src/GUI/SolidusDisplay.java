package GUI;

import javax.swing.*;

import utilities.*;

import java.awt.*;

public class SolidusDisplay extends Display {

    private JLabel displayExpression;
    private JLabel displayOperand;

    public SolidusDisplay() {
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
    public void setExpression(String errorMessage) {
        displayExpression.setText(errorMessage);
    }

    @Override
    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        displayExpression.setText("<html>" + left.toSolidusString() + operation + "</html>");
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right,
            IrreducedMixedFraction result) {
        displayExpression.setText("<html>" + left.toSolidusString() + operation + right.toSolidusString() + "=" + result.toSolidusString() + "</html>");
    }

    @Override
    public void setOperand(IrreducedMixedFraction operand) {
        whole = String.valueOf(operand.getWhole());
        numerator = String.valueOf(operand.getNumerator());
        denominator = String.valueOf(operand.getDenominator());
        signBool = operand.getSign();
        if (signBool) {
            signText = "";
        } else {
            signText = "-";
        }
        updateOperand();
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
    protected void clearOperand() {
        whole = "_";
        numerator = "_";
        denominator = "_";
        signText = "";
        signBool = true;
        currentPosition = 0;
        updateOperand();
    }

    @Override
    protected void clearExpression() {
        displayExpression.setText(" ");
    }

}