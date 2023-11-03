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
    
  public void reduce() {
    while (Math.abs(numerator) >= denominator) {
        if (numerator < 0) {
            numerator += denominator;
            whole--;
        } else {
            numerator -= denominator;
            whole++;
        }
    }
    if ((whole < 0 && numerator > 0) || (whole > 0 && numerator < 0)) {
        numerator = -numerator;
    }
}
  
  public void unreduce() {
    if (whole != 0) {
        if (whole > 0) {
            numerator += whole * denominator;
        } else {
            numerator -= Math.abs(whole) * denominator;
        }
        whole = 0;
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
  public void changeSign() {
    if (whole != 0) {
        whole = -whole;
    } else {
        numerator = -numerator;
    }
    if ((whole < 0 && numerator > 0) || (whole > 0 && numerator < 0)) {
        numerator = -numerator;
    }
}

  public String toString() {
    reduce();
    if (whole != 0) {
        return whole + " " + Math.abs(numerator) + "/" + denominator;
    } else {
        return numerator + "/" + denominator;
    }
}
}
