package utilities;
public class Operations
{
  public static IrreducedMixedFraction add(IrreducedMixedFraction left,
      IrreducedMixedFraction right, boolean isProperForm, boolean isReducedForm)
  {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    IrreducedMixedFraction.gcd(left, right);

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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }
  
  public static IrreducedMixedFraction subtract(IrreducedMixedFraction left, IrreducedMixedFraction right, boolean isProperForm, boolean isReducedForm) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    IrreducedMixedFraction.gcd(left, right);

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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }
  
  public static IrreducedMixedFraction multiply(IrreducedMixedFraction left, IrreducedMixedFraction right, boolean isProperForm, boolean isReducedForm) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }
  
  public static IrreducedMixedFraction divide(IrreducedMixedFraction left, IrreducedMixedFraction right, boolean isProperForm, boolean isReducedForm) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();   
    
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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }

  public static IrreducedMixedFraction exponent(IrreducedMixedFraction operand, int power, boolean isProperForm, boolean isReducedForm) {
    int numerator;
    int denominator;
    boolean sign;
    IrreducedMixedFraction result;

    operand.unreduce();

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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }
  
  public static IrreducedMixedFraction mediant(IrreducedMixedFraction left, IrreducedMixedFraction right, boolean isProperForm, boolean isReducedForm) {
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
    if (isProperForm) {
      result.reduce();
    }
    if (isReducedForm) {
      result.simplifyMode();
    }
    return result;
  }
}
