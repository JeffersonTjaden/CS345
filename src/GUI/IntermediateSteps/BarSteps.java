package GUI.IntermediateSteps;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.Locale;

import utilities.IrreducedMixedFraction;

public class BarSteps extends IntermediateSteps {

    public BarSteps(Locale locale) {
        super(locale);
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction left, String operation, IrreducedMixedFraction right) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        
        labels[0].setText(left.toWholeBarString());
        labels[1].setText(left.toFractionBarString());
        labels[2].setText(operation + right.toWholeBarString());
        labels[3].setText(right.toFractionBarString());

        for (int i = 0; i < 4; i++) {
            panel.add(labels[i]);
        }
        return panel;
    }

    @Override
    protected JPanel createExpression(IrreducedMixedFraction operand, String operation, int power) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel[] labels = new JLabel[3];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        
        labels[0].setText(operand.toWholeBarString());
        labels[1].setText(operand.toFractionBarString());
        labels[2].setText(operation + power);

        for (int i = 0; i < 3; i++) {
            panel.add(labels[i]);
        }
        return panel;
    }

    @Override
    protected JPanel createResult(IrreducedMixedFraction result) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel[] labels = new JLabel[2];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        
        labels[0].setText(result.toWholeBarString());
        labels[1].setText(result.toFractionBarString());

        for (int i = 0; i < 2; i++) {
            panel.add(labels[i]);
        }
        return panel;
    }
    
}
