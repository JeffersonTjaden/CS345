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
        String sign = "";
        if (!left.getSign()) {
            sign = "-";
        }
        leftWhole.setText(sign + left.getWhole() + " ");
        leftFraction.setText("<html><div style='text-align: center'>" + left.getNumerator() + "<hr/>" + left.getDenominator() + "</div></html>");
        rightWhole.setText(" " + operation);
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction right,
            IrreducedMixedFraction result) {
        String sign = "";
        if (!right.getSign()){
            sign = "-";
        }
        rightWhole.setText(" " + sign + right.getWhole() + " ");
        rightFraction.setText("<html><div style='text-align: center'>" + right.getNumerator() + "<hr/>" + right.getDenominator() + "</div></html>");

        sign = "";
        if (!result.getSign()) {
            sign = "-";
        }
        resultWhole.setText(" = " + sign + result.getWhole() + " ");
        resultFraction.setText("<html><div style='text-align: center'>" + result.getNumerator() + "<hr/>" + result.getDenominator() + "</div></html>");
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
        operandWhole.setText(signText + whole + " ");
        operandFraction.setText("<html><div style='text-align: center'>" + numerator + "<hr/>" + denominator + "</div></html>");
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
        leftWhole.setText(" ");
        leftFraction.setText(" ");
        rightWhole.setText(" ");
        rightFraction.setText(" ");
        resultWhole.setText(" ");
        resultFraction.setText(" ");
    }
    
}