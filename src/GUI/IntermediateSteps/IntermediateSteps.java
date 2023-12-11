package GUI.IntermediateSteps;

import utilities.*;
import javax.swing.*;

import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The IntermediateSteps class is for writing out all the steps performed in a calculation.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/29/2023
 */
public abstract class IntermediateSteps extends JPanel {
    private ResourceBundle messages;

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        JFrame frame = new JFrame();
        IntermediateSteps steps = new BarSteps(locale);
        frame.add(steps);
        frame.setVisible(true);
        IrreducedMixedFraction left = new IrreducedMixedFraction(1, 2, 6, true);
        IrreducedMixedFraction right = new IrreducedMixedFraction(1, 4, 12, false);
        steps.divideSteps(left, right);
    }

    public IntermediateSteps(Locale locale) {
        this.messages = ResourceBundle.getBundle("resources.MessagesBundle", locale);
        setLayout(new GridLayout(0, 1));
    }

    protected abstract JPanel createExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right);

    protected abstract JPanel createExpression(IrreducedMixedFraction operand, String operation, int power);

    protected abstract JPanel createResult(IrreducedMixedFraction result);

    private JPanel createResult(boolean result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText(Boolean.toString(result));
        panel.add(label);
        return panel;
    }
    
    /**
     * Writes out the steps for adding two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the addition operation
     */
    public void addSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "+";
        JLabel[] labels = new JLabel[5];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));
        
        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);        
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.simplify"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.lcd"));
        add(labels[3]);
        IrreducedMixedFraction.lcd(left, right);
        add(createExpression(left, operation, right));

        labels[4].setText(messages.getString("steps.addResult"));
        add(labels[4]);
        IrreducedMixedFraction result = Operations.add(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out the steps for subtracting two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the subtraction operation
     */
    public void subtractSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "-";
        JLabel[] labels = new JLabel[5];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));
        
        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);        
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.simplify"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.lcd"));
        add(labels[3]);
        IrreducedMixedFraction.lcd(left, right);
        add(createExpression(left, operation, right));

        labels[4].setText(messages.getString("steps.subtractResult"));
        add(labels[4]);
        IrreducedMixedFraction result = Operations.subtract(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out the steps used to multiply two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the multiplication operation
     */
    public void multiplySteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "*";
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));
        
        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);        
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.simplify"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.multiplyResult"));
        add(labels[3]);
        IrreducedMixedFraction result = Operations.multiply(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out the steps used to divide two IrreducedMixedFractions
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the division operation
     */
    public void divideSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = Character.toString((char) 247);
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));
        
        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);        
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.simplify"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.divideResult"));
        add(labels[3]);
        IrreducedMixedFraction result = Operations.divide(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out all the steps used to raise an IrreducedMixedFraction to an integer power.
     * 
     * @param operand The IrreducedMixedFraction
     * @param power The integer power
     * @return A string explaining all the steps used in the integer power operation
     */
    public void intPowerSteps(IrreducedMixedFraction operand, int power) {
        removeAll();

        String operation = "^";
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(operand, operation, power));

        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);
        operand.unreduce();
        add(createExpression(operand, operation, power));

        labels[2].setText(messages.getString("steps.simplify"));
        add(labels[2]);
        operand.simplify();
        add(createExpression(operand, operation, power));

        labels[3].setText(messages.getString("steps.raisePower") + power);
        add(labels[3]);
        IrreducedMixedFraction result = Operations.intPower(operand, power);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out all the steps used to calculate the mediant of two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the mediant operation
     */
    public void mediantSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "⇹";
        JLabel[] labels = new JLabel[3];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));

        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.mediantResult"));
        add(labels[2]);
        IrreducedMixedFraction result = Operations.mediant(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is less than another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the less than operation
     */
    public void lessThanSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "<";
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));

        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.lcd"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        IrreducedMixedFraction.lcd(left, right);
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.compareNumerators"));
        add(labels[3]);
        boolean result = Operations.lessThan(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is equal to another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the equal to operation
     */
    public void equalToSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = "==";
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));

        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.lcd"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        IrreducedMixedFraction.lcd(left, right);
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.compareNumerators"));
        add(labels[3]);
        boolean result = Operations.equalTo(left, right);
        add(createResult(result));

        updateUI();
    }

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is greater than another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the greater than operation
     */
    public void greaterThanSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        removeAll();

        String operation = ">";
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }

        labels[0].setText(messages.getString("steps.calculation"));
        add(labels[0]);
        add(createExpression(left, operation, right));

        labels[1].setText(messages.getString("steps.unreduce"));
        add(labels[1]);
        left.unreduce();
        right.unreduce();
        add(createExpression(left, operation, right));

        labels[2].setText(messages.getString("steps.lcd"));
        add(labels[2]);
        left.simplify();
        right.simplify();
        IrreducedMixedFraction.lcd(left, right);
        add(createExpression(left, operation, right));

        labels[3].setText(messages.getString("steps.compareNumerators"));
        add(labels[3]);
        boolean result = Operations.greaterThan(left, right);
        add(createResult(result));

        updateUI();
    }

}
