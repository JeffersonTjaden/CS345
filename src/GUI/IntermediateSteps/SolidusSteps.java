package GUI.IntermediateSteps;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.IrreducedMixedFraction;

public class SolidusSteps extends IntermediateSteps {

    public SolidusSteps(){
        super();
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("<html>" + left.toSolidusString() + operation + right.toSolidusString() + "</html>");
        panel.add(label);
        return panel;
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction operand, String operation, int power) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("<html>" + operand.toSolidusString() + operation + power + "</html>");
        panel.add(label);
        return panel;
    }

    @Override
    protected JPanel createResult(IrreducedMixedFraction result) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("<html>" + result.toSolidusString() + "</html>");
        panel.add(label);
        return panel;
    }
    
}