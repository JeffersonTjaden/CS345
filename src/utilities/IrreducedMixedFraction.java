package utilities;
public class IrreducedMixedFraction
{

  private int whole;
  private int numerator;
  private int denominator;
  private boolean sign;

  public IrreducedMixedFraction(int whole, boolean sign) {
    this.whole = whole;
    numerator = 0;
    denominator = 1;
    this.sign = sign;
  }

  public IrreducedMixedFraction(int numerator, int denominator)
  {
    if (denominator == 0) {
      throw new IllegalArgumentException();
    }
    this.whole = 0;
    this.numerator = numerator;
    this.denominator = denominator;
    this.sign = true;
  }

  public IrreducedMixedFraction(int numerator, int denominator, boolean sign)
  {
    if (denominator == 0) {
      throw new IllegalArgumentException();
    }
    this.whole = 0;
    this.numerator = numerator;
    this.denominator = denominator;
    this.sign = sign;
  }
  
  public IrreducedMixedFraction(int whole, int numerator, int denominator, boolean sign) {
    if (denominator == 0)
    {
      throw new IllegalArgumentException();
    }
    this.whole = whole;
    this.numerator = numerator;
    this.denominator = denominator;
    this.sign = sign;    
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

  public boolean getSign()
  {
    return sign;
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

  public void setSign(boolean sign)
  {
    this.sign = sign;
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

public void invert() {
  unreduce();
  if (numerator != 0) {
    int temp = numerator;
    numerator = denominator;
    denominator = temp;
  }
}

public void simplify() {
  int divisor = simplifyHelper(numerator, denominator);
  numerator /= divisor;
  denominator /= divisor;
}

private int simplifyHelper(int numerator, int denominator) {
  if (denominator == 0) {
    return numerator;
  }
  return simplifyHelper(denominator, numerator % denominator);
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

  public String toString() {
    String str = "";
    if (!sign) {
      str += "-";
    }
    if (whole != 0) {
      str += whole;
    }
    if (numerator != 0) {
      str += " " + numerator + "/" + denominator;
    }
    if (whole == 0 && numerator == 0) {
      str = "0";
    }
    return str;
}
}
