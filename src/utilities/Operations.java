package utilities;

/**
 * The Operations class is for performing calculations with IrreducedMixedFractions.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
public class Operations
{
  /**
   * Adds two IrreducedMixedFractions.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return A new IrreducedMixedFraction that is the sum of left and right
   */
  public static IrreducedMixedFraction add(IrreducedMixedFraction left,
      IrreducedMixedFraction right)
  {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    left.simplify();
    right.unreduce();
    right.simplify();

    IrreducedMixedFraction.lcd(left, right);

    if (left.getSign() && right.getSign()) {
      numerator = left.getNumerator() + right.getNumerator();
    } else if (left.getSign() && !right.getSign()) {
      numerator = left.getNumerator() - right.getNumerator();
    } else if (!left.getSign() && right.getSign()) {
      numerator = -left.getNumerator() + right.getNumerator();
    } else {
      numerator = -left.getNumerator() - right.getNumerator();
    }

    denominator = left.getDenominator();

    sign = true;
    if (numerator < 0){
      sign = false;
      numerator = Math.abs(numerator);
    } 

    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }
  
  /**
   * Subtracts two IrreducedMixedFractions.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return A new IrreducedMixedFraction that is the difference of left and right
   */
  public static IrreducedMixedFraction subtract(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    left.simplify();
    right.unreduce();
    right.simplify();

    IrreducedMixedFraction.lcd(left, right);

    if (left.getSign() && right.getSign()) {
      numerator = left.getNumerator() - right.getNumerator();
    } else if (left.getSign() && !right.getSign()) {
      numerator = left.getNumerator() + right.getNumerator();
    } else if (!left.getSign() && right.getSign()) {
      numerator = -left.getNumerator() - right.getNumerator();
    } else {
      numerator = -left.getNumerator() + right.getNumerator();
    }

    denominator = left.getDenominator();

    sign = true;
    if (numerator < 0){
      sign = false;
      numerator = Math.abs(numerator);
    }

    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }
  
  /**
   * Multiplies two IrreducedMixedFractions.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return A new IrreducedMixedFraction that is the product of left and right
   */
  public static IrreducedMixedFraction multiply(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    left.simplify();
    right.unreduce();
    right.simplify();

      if (left.getSign() && right.getSign()){
      sign = true;
    } else if (left.getSign() || right.getSign()){
      sign = false;
    } else {
      sign = true;
    }

    numerator = left.getNumerator() * right.getNumerator();
    denominator = left.getDenominator() * right.getDenominator();
    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }
  
  /**
   * Divides two IrreducedMixedFractions.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return A new IrreducedMixedFraction that is the quotient of left and right
   */
  public static IrreducedMixedFraction divide(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    left.simplify();
    right.unreduce();
    right.simplify();   
    
    if (left.getSign() && right.getSign()){
      sign = true;
    } else if (left.getSign() || right.getSign()){
      sign = false;
    } else {
      sign = true;
    }
    numerator = left.getNumerator() * right.getDenominator();
    denominator = left.getDenominator() * right.getNumerator();
    
    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }

  /**
   * Raises an IrreducedMixedFraction to an integer power.
   * 
   * @param operand The IrreducedMixedFraction
   * @param power The integer power
   * @return A new IrreducedMixedFraction that is the result of raising operand by power
   */
  public static IrreducedMixedFraction exponent(IrreducedMixedFraction operand, int power) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    operand.unreduce();
    operand.simplify();

    if (power >= 0) {
      numerator = (int) Math.pow(operand.getNumerator(), power);
      denominator = (int) Math.pow(operand.getDenominator(), power);
    } else {
      numerator = (int) Math.pow(operand.getDenominator(), Math.abs(power));
      denominator = (int) Math.pow(operand.getNumerator(), Math.abs(power));
    }

    sign = true;
    if (!operand.getSign() && power % 2 == 1) {
      sign = false;
    }

    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }
  
  /**
   * Finds the mediant of two IrreducedMixedFractions.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return A new IrreducedMixedFraction that is the mediant of left and right
   */
  public static IrreducedMixedFraction mediant(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    if (left.getSign() && right.getSign()) {
      numerator = left.getNumerator() + right.getNumerator();
    } else if (left.getSign() && !right.getSign()) {
      numerator = left.getNumerator() - right.getNumerator();
    } else if (!left.getSign() && right.getSign()) {
      numerator = -left.getNumerator() + right.getNumerator();
    } else {
      numerator = -left.getNumerator() - right.getNumerator();
    }

    denominator = left.getDenominator() + right.getDenominator();

    sign = true;
    if (numerator < 0) {
      sign = false;
      numerator = Math.abs(numerator);
    }

    result = new IrreducedMixedFraction(numerator, denominator, sign);
    return result;
  }
  
  /**
   * Determines whether or not one IrreducedMixedFraction is less than another.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return true if left is less than right, false otherwise
   */
  public static boolean lessThan(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    if (left.compareTo(right) < 0) {
      return true;
    }
    return false;
  }

  /**
   * Determines whether or not one IrreducedMixedFraction is equal to another.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return true if left equals right, false otherwise
   */
  public static boolean equalTo(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    if (left.compareTo(right) == 0) {
      return true;
    }
    return false;
  }

  /**
   * Determines whether or not one IrreducedMixedFraction is greater than another.
   * 
   * @param left The left operand
   * @param right The right operand
   * @return true if left is greater than right, false otherwise
   */
  public static boolean greaterThan(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    if (left.compareTo(right) > 0) {
      return true;
    }
    return false;
  }
}
