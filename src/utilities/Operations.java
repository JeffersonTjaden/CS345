
public class Operations
{
  public static IrreducedMixedFraction add(IrreducedMixedFraction left,
      IrreducedMixedFraction right)
  {
    int numerator;
    int denominator;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    IrreducedMixedFraction.gcd(left, right);
    numerator = left.getNumerator() + right.getNumerator();
    denominator = left.getDenominator();
    result = new IrreducedMixedFraction(numerator, denominator);
    return result;
  }
  
  public static IrreducedMixedFraction subtract(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    IrreducedMixedFraction.gcd(left, right);
    numerator = left.getNumerator() - right.getNumerator();
    denominator = left.getDenominator();
    result = new IrreducedMixedFraction(numerator, denominator);
    return result;
  }
  
  public static IrreducedMixedFraction multiply(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();

    numerator = left.getNumerator() * right.getNumerator();
    denominator = left.getDenominator() * right.getDenominator();
    result = new IrreducedMixedFraction(numerator, denominator);
    return result;
  }
  
  public static IrreducedMixedFraction divide(IrreducedMixedFraction left, IrreducedMixedFraction right) {
    int numerator;
    int denominator;
    IrreducedMixedFraction result;

    left.unreduce();
    right.unreduce();   
    
    numerator = left.getNumerator() * right.getDenominator();
    denominator = left.getDenominator() * right.getNumerator();
    result = new IrreducedMixedFraction(numerator, denominator);
    return result;
  }
}
