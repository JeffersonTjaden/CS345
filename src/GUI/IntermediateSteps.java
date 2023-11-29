package GUI;

import utilities.*;

public class IntermediateSteps {

    public static void main(String[] args) {
        IrreducedMixedFraction left = new IrreducedMixedFraction(1, 2, 6, true);
        IrreducedMixedFraction right = new IrreducedMixedFraction(1, 4, 12, false);
        String str = greaterThanSteps(left, right);
        System.out.println(str);
    }
    
    public static String addSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " + " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " + " + right.toString() + "\n";
        str += "Step 2: Simplify each fraction\n";
        left.simplify();
        right.simplify();
        str += "\t" + left.toString() + " + " + right.toString() + "\n";
        str += "Step 3: Find the least common denominator\n";
        IrreducedMixedFraction.lcd(left, right);
        str += "\t" + left.toString() + " + " + right.toString() + "\n";
        str += "Step 4: Add the numerators to find the result\n";
        IrreducedMixedFraction result = Operations.add(left, right);
        str += "\t" + result.toString();
        return str;
    }

    public static String subtractSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " - " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " - " + right.toString() + "\n";
        str += "Step 2: Simplify each fraction\n";
        left.simplify();
        right.simplify();
        str += "\t" + left.toString() + " - " + right.toString() + "\n";
        str += "Step 3: Find the least common denominator\n";
        IrreducedMixedFraction.lcd(left, right);
        str += "\t" + left.toString() + " - " + right.toString() + "\n";
        str += "Step 4: Subtract the numerators to find the result\n";
        IrreducedMixedFraction result = Operations.subtract(left, right);
        str += "\t" + result.toString();
        return str;
    }

    public static String multiplySteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " * " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " * " + right.toString() + "\n";
        str += "Step 2: Simplify each fraction\n";
        left.simplify();
        right.simplify();
        str += "\t" + left.toString() + " * " + right.toString() + "\n";
        str += "Step 3: Multiply the numerators and the denominators\n";
        IrreducedMixedFraction result = Operations.multiply(left, right);
        str += "\t" + result.toString();
        return str;
    }

    public static String divideSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " / " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " / " + right.toString() + "\n";
        str += "Step 2: Simplify each fraction\n";
        left.simplify();
        right.simplify();
        str += "\t" + left.toString() + " / " + right.toString() + "\n";
        str += "Step 3: Cross multiply the numerators and denominators\n";
        IrreducedMixedFraction result = Operations.divide(left, right);
        str += "\t" + result.toString();
        return str;
    }

    public static String intPowerSteps(IrreducedMixedFraction operand, int power) {
        String str = "";
        str += "These are the steps to calculate (" + operand.toString() + " / " + power + ")\n";
        str += "Step 1: Unreduce the fraction\n";
        operand.unreduce();
        str += "\t" + operand.toString() + " ^ " + power + "\n";
        str += "Step 2: Simplify the fraction\n";
        operand.simplify();
        str += "\t" + operand.toString() + " ^ " + power + "\n";
        str += "Step 3: Raise the numerator and denominator to " + power + "\n";
        IrreducedMixedFraction result = Operations.intPower(operand, power);
        str += "\t" + result.toString();
        return str;
    }

    public static String mediantSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " ⇹ " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " ⇹ " + right.toString() + "\n";
        str += "Step 2: Add the numerators and the denominators\n";
        IrreducedMixedFraction result = Operations.mediant(left, right);
        str += "\t" + result.toString();
        return str;
    }

    public static String lessThanSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " < " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " < " + right.toString() + "\n";
        str += "Step 2: Find the least common denominator\n";
        IrreducedMixedFraction.lcd(left, right);
        str += "\t" + left.toString() + " < " + right.toString() + "\n";
        str += "Step 3: Compare the numerators\n";
        boolean result = Operations.lessThan(left, right);
        str += "\t" + result;
        return str;
    }

    public static String equalToSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " = " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " = " + right.toString() + "\n";
        str += "Step 2: Find the least common denominator\n";
        IrreducedMixedFraction.lcd(left, right);
        str += "\t" + left.toString() + " = " + right.toString() + "\n";
        str += "Step 3: Compare the numerators\n";
        boolean result = Operations.equalTo(left, right);
        str += "\t" + result;
        return str;
    }

    public static String greaterThanSteps(IrreducedMixedFraction left, IrreducedMixedFraction right) {
        String str = "";
        str += "These are the steps to calculate (" + left.toString() + " > " + right.toString() + ")\n";
        str += "Step 1: Unreduce each fraction\n";
        left.unreduce();
        right.unreduce();
        str += "\t" + left.toString() + " > " + right.toString() + "\n";
        str += "Step 2: Find the least common denominator\n";
        IrreducedMixedFraction.lcd(left, right);
        str += "\t" + left.toString() + " > " + right.toString() + "\n";
        str += "Step 3: Compare the numerators\n";
        boolean result = Operations.greaterThan(left, right);
        str += "\t" + result;
        return str;
    }

}
