package GUI;

import javax.swing.*;
import java.awt.*;
import utilities.*;

public class BarDisplay extends Display {

    private JPanel expressionDisplay;

    private JPanel leftDisplay;
    private JLabel leftWhole;
    private JLabel leftFraction;

    private JPanel rightDisplay;
    private JLabel rightWhole;
    private JLabel rightFraction;

    private JPanel resultDisplay;
    private JLabel resultWhole;
    private JLabel resultFraction;

    private JPanel operandDisplay;
    private JLabel operandWhole;
    private JLabel operandFraction;

    public BarDisplay() {
        expressionDisplay = new JPanel();
        leftDisplay = new JPanel();
        rightDisplay = new JPanel();
        resultDisplay = new JPanel();
        resultDisplay.setAlignmentX(LEFT_ALIGNMENT);
        operandDisplay = new JPanel();

        leftWhole = new JLabel();
        leftFraction = new JLabel();
        rightWhole = new JLabel();
        rightFraction = new JLabel();
        resultWhole = new JLabel();
        resultFraction = new JLabel();
        operandWhole = new JLabel();
        operandFraction = new JLabel();

        setLayout(new BorderLayout());
        expressionDisplay.setLayout(new FlowLayout());
        leftDisplay.setLayout(new BorderLayout());
        rightDisplay.setLayout(new BorderLayout());
        resultDisplay.setLayout(new BorderLayout());
        operandDisplay.setLayout(new BorderLayout());

        add(expressionDisplay, BorderLayout.NORTH);
        add(operandDisplay, BorderLayout.EAST);

        expressionDisplay.add(leftDisplay);
        expressionDisplay.add(rightDisplay);
        expressionDisplay.add(resultDisplay);

        leftDisplay.add(leftWhole, BorderLayout.WEST);
        leftDisplay.add(leftFraction, BorderLayout.CENTER);

        rightDisplay.add(rightWhole, BorderLayout.WEST);
        rightDisplay.add(rightFraction, BorderLayout.CENTER);

        resultDisplay.add(resultWhole, BorderLayout.WEST);
        resultDisplay.add(resultFraction, BorderLayout.CENTER);

        operandDisplay.add(operandWhole, BorderLayout.WEST);
        operandDisplay.add(operandFraction, BorderLayout.CENTER);

        setBackground(Color.white);
        expressionDisplay.setBackground(getBackground());
        leftDisplay.setBackground(getBackground());
        rightDisplay.setBackground(getBackground());
        resultDisplay.setBackground(getBackground());
        operandDisplay.setBackground(getBackground());

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
        leftWhole.setText(left.getWhole() + " ");
        leftFraction.setText("<html>" + left.getNumerator() + "<hr/>" + left.getDenominator() + "</html>");
        rightWhole.setText(" " + operation);
        clearOperand();
    }

    @Override
    public void setEvaluatedExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right,
            IrreducedMixedFraction result) {
        String sign = "";
        if (!left.getSign()){
            sign = "-";
        }
        leftWhole.setText(sign + left.getWhole() + " ");
        leftFraction.setText("<html>" + left.getDenominator() + "<hr/>" + left.getDenominator() + "</html>");

        sign = "";
        if (!right.getSign()){
            sign = "-";
        }
        rightWhole.setText(" " + operation + " " + sign + right.getWhole() + " ");
        rightFraction.setText("<html>" + right.getNumerator() + "<hr/>" + right.getDenominator() + "</html>");

        sign = "";
        if (!result.getSign()) {
            sign = "-";
        }
        resultWhole.setText(" = " + sign + result.getWhole() + " ");
        resultFraction.setText("<html>" + result.getNumerator() + "<hr/>" + result.getDenominator() + "</html>");
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
        operandWhole.setText(whole + " ");
        operandFraction.setText("<html>" + numerator + "<hr/>" + denominator + "</html>");
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