package GUI.IntermediateSteps;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.IrreducedMixedFraction;

public class SlashSteps extends IntermediateSteps {
    
    public SlashSteps() {
        super();
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText(left.toString() + operation + right.toString());
        panel.add(label);
        return panel;
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction operand, String operation, int power) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText(operand.toString() + operation + power);
        panel.add(label);
        return panel;
    }

    @Override
    protected JPanel createResult(IrreducedMixedFraction result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText(result.toString());
        panel.add(label);
        return panel;
    }

}
