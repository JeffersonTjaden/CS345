package utilities;
public class IrreducedMixedFraction
{

  private int whole;
  private int numerator;
  private int denominator;

  public IrreducedMixedFraction(int numerator, int denominator)
  {
    if (denominator == 0) {
      throw new IllegalArgumentException();
    }
    this.whole = 0;
    this.numerator = numerator;
    this.denominator = denominator;
    this.reduce();
  }
  
  public IrreducedMixedFraction(int whole, int numerator, int denominator) {
    if (denominator == 0)
    {
      throw new IllegalArgumentException();
    }
    this.whole = whole;
    this.numerator = numerator;
    this.denominator = denominator;
    this.reduce();
  }

  public int getWhole()
  {
    return whole;
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int getDenominator()
  {
    return denominator;
  }

  public void setWhole(int whole)
  {
    this.whole = whole;
  }

  public void setNumerator(int numerator)
  {
    this.numerator = numerator;
  }

  public void setDenominator(int denominator)
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException();
    }
    else
    {
      this.denominator = denominator;  
    }
  }
    
  public void reduce()
  {
    while (numerator >= denominator)
    {
      numerator -= denominator;
      whole++;
    }
  }
  
  public void unreduce() {
    while (whole > 0) {
      numerator += denominator;
      whole--;
    }
  }

  public static void gcd(IrreducedMixedFraction left, IrreducedMixedFraction right)
  {
    if (left.getDenominator() != right.getDenominator())
    {
      int rightConstant = right.getDenominator();
      int leftConstant = left.getDenominator();
      
      left.setNumerator(left.getNumerator() * rightConstant);
      left.setDenominator(left.getDenominator() * rightConstant);

      right.setNumerator(right.getNumerator() * leftConstant);
      right.setDenominator(right.getDenominator() * leftConstant);
    }
  }
}
