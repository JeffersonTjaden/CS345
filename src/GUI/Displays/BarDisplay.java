package GUI.Displays;

import javax.swing.*;


import java.awt.*;
import utilities.*;

/**
 * The BarDisplay class is for displaying the operand being inputted, the partial current expression, and the evaluated current expression in bar style.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
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

    /**
     * Constructs a new BarDisplay with an empty current operand and an empty current expression.
     */
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
        displayExpression.setAlignmentX(FlowLayout.LEFT);
        displayOperand.setLayout(new FlowLayout());

        add(displayExpression, BorderLayout.NORTH);
        add(displayOperand, BorderLayout.EAST);

        displayExpression.add(leftWhole);
        displayExpression.add(leftFraction);
        displayExpression.add(rightWhole);
        displayExpression.add(rightFraction);
        displayExpression.add(resultWhole);
        displayExpression.add(resultFraction);

        displayOperand.add(operandWhole);
        displayOperand.add(operandFraction);

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
    public void setErrorMessage(String errorMessage) {
        
    }

    @Override
    public void setPartialExpression(IrreducedMixedFraction left, String operation) {
        clearExpression();
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
        leftFraction.setText("");
        rightWhole.setText("");
        rightFraction.setText("");
        resultWhole.setText("");
        resultFraction.setText("");
    }
    
}