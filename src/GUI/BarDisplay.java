package GUI;

import javax.swing.*;
import java.awt.*;
import utilities.*;

public class BarDisplay extends Display {

    private JPanel displayExpression;
    private JPanel displayOperand;

    private JLabel leftWhole;
    private JLabel leftFraction;

    private JLabel rightWhole;
    private JLabel rightFraction;

    private JLabel resultWhole;
    private JLabel resultFraction;

    private JLabel operandWhole;
    private JLabel operandFraction;

    public BarDisplay() {
        displayExpression = new JPanel();
        displayOperand = new JPanel();

        leftWhole = new JLabel();
        leftFraction = new JLabel();
        rightWhole = new JLabel();
        rightFraction = new JLabel();
        resultWhole = new JLabel();
        resultFraction = new JLabel();
        operandWhole = new JLabel();
        operandFraction = new JLabel();

        setLayout(new BorderLayout());
        displayExpression.setLayout(new FlowLayout());
        displayOperand.setLayout(new FlowLayout());

        add(displayExpression, BorderLayout.NORTH);
        add(displayOperand, BorderLayout.EAST);

        displayExpression.add(leftWhole, BorderLayout.WEST);
        displayExpression.add(leftFraction, BorderLayout.CENTER);
        displayExpression.add(rightWhole, BorderLayout.WEST);
        displayExpression.add(rightFraction, BorderLayout.CENTER);
        displayExpression.add(resultWhole, BorderLayout.WEST);
        displayExpression.add(resultFraction, BorderLayout.CENTER);

        displayOperand.add(operandWhole, BorderLayout.WEST);
        displayOperand.add(operandFraction, BorderLayout.CENTER);

        setBackground(Color.white);
        displayExpression.setBackground(getBackground());
        displayOperand.setBackground(getBackground());

        whole = "_";
        numerator = "_";
        denominator = "_";
        signText = "";
        signBool = true;
        updateOperand();
    }

    @Override
    public void setExpression(String errorMessage) {
        
    }

    @Override
    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        leftWhole.setText(left.toWholeBarString() + " ");
        leftFraction.setText(left.toFractionBarString());
        rightWhole.setText(" " + operation);
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction right,
            IrreducedMixedFraction result) {
        
        rightWhole.setText(rightWhole.getText() + " " + right.toWholeBarString() + " ");
        rightFraction.setText(right.toFractionBarString());

        resultWhole.setText(" = " + result.toWholeBarString() + " ");
        resultFraction.setText(result.toFractionBarString());
    }

    @Override
    protected void updateOperand() {
        String focusedStyle = "<span style='background-color:#D3D3D3; color:black;'>%s</span>";
        switch (currentPosition % 3) {
            case 0:
                operandWhole.setText("<html>" + signText + String.format(focusedStyle, whole) + " </html>");
                operandFraction.setText("<html><div style='text-align: center'>" + numerator + "<hr/>" + denominator + "</div></html>");
                break;
            case 1:
                operandWhole.setText("<html>" + signText + whole + " </html>");
                operandFraction.setText("<html><div style='text-align: center'>" + String.format(focusedStyle, numerator) + "<hr/>" + denominator + "</div></html>");
                break;
            case 2:
                operandWhole.setText("<html>" + signText + whole + " </html>");
                operandFraction.setText("<html><div style='text-align: center'>" + numerator + "<hr/>" + String.format(focusedStyle, denominator) + "</div></html>");
                break;
        }
    }

    @Override
    protected void clearExpression() {
        leftWhole.setText(" ");
        leftFraction.setText(" ");
        rightWhole.setText(" ");
        rightFraction.setText(" ");
        resultWhole.setText(" ");
        resultFraction.setText(" ");
    }
    
}