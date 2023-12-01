package GUI;

import utilities.*;

/**
 * The IntermediateSteps class is for writing out all the steps performed in a calculation.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/29/2023
 */
public class IntermediateSteps {

    public static void main(String[] args) {
        IrreducedMixedFraction left = new IrreducedMixedFraction(1, 2, 6, true);
        IrreducedMixedFraction right = new IrreducedMixedFraction(1, 4, 12, false);
        String str = greaterThanSteps(left, right);
        System.out.println(str);
    }
    
    /**
     * Writes out the steps for adding two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the addition operation
     */
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

    /**
     * Writes out the steps for subtracting two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the subtraction operation
     */
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

    /**
     * Writes out the steps used to multiply two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the multiplication operation
     */
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

    /**
     * Writes out the steps used to divide two IrreducedMixedFractions
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the division operation
     */
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

    /**
     * Writes out all the steps used to raise an IrreducedMixedFraction to an integer power.
     * 
     * @param operand The IrreducedMixedFraction
     * @param power The integer power
     * @return A string explaining all the steps used in the integer power operation
     */
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

    /**
     * Writes out all the steps used to calculate the mediant of two IrreducedMixedFractions.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the mediant operation
     */
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

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is less than another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the less than operation
     */
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

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is equal to another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the equal to operation
     */
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

    /**
     * Writes out all the steps used to determine if one IrreducedMixedFraction is greater than another.
     * 
     * @param left The left operand
     * @param right The right operand
     * @return A string explaining all the steps used in the greater than operation
     */
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
