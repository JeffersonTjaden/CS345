package utilities;

import javax.swing.JDialog;

/**
 * The IrreducedMixedFraction class is for instantiating and manipulating irreduced mixed fractions.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
public class IrreducedMixedFraction
{

  private int whole;
  private int numerator;
  private int denominator;
  private boolean sign;

  /**
   * Constructs an IrreducedMixedFraction with a whole number of zero, specified numerator, specified denominator, and specified sign.
   * 
   * @param numerator The specified numerator
   * @param denominator The specified denominator
   * @param sign The specified sign
   */
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
  
  /**
   * Constructs an IrreducedMixedFraction with a specified whole number, specified numerator, specified denominator, and specified sign.
   * 
   * @param whole The specified whole number
   * @param numerator The specified numerator
   * @param denominator The specified denominator
   * @param sign The specified sign
   */
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
  
  /**
   * Increments the whole number by 1 and subtracts the numerator by the denominator until the numerator is less than the denominator.
   */
  public void reduce() {
    while (numerator >= denominator) {
      numerator -= denominator;
      whole++;        
    }
}
  
  /**
   * Adds the product of the whole number and denominator to the numerator and sets the whole number equal to zero.
   */
  public void unreduce() {
    numerator += whole * denominator;
    whole = 0;
}

/**
 * Unreduces the IrreducedMixedFraction and then switches the numerator with the denominator.
 */
public void invert() {
  unreduce();
  if (numerator != 0) {
    int temp = numerator;
    numerator = denominator;
    denominator = temp;
  }
}

/**
 * Divides the numerator and the denominator by their greatest common divisor.
 */
public void simplify() {
  int divisor = gcd(numerator, denominator);
  numerator /= divisor;
  denominator /= divisor;
}

/**
 * Find the greatest common divisor between two integers.
 * 
 * Helper method for the simplify and lcd methods.
 * 
 * @param a The first integer
 * @param b The second integer
 * @return The greatest common divisor of a and b
 */
private static int gcd(int a, int b) {
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}

  /**
   * Finds the least common denominator of two IrreducedMixedFractions and manipulates each of them to have that denominator.
   * 
   * @param left The first IrreducedMixedFraction
   * @param right The second IrreducedMixedFraction
   */
  public static void lcd(IrreducedMixedFraction left, IrreducedMixedFraction right)
  {
    if (left.getDenominator() != right.getDenominator())
    {
      int lcm = left.getDenominator() * right.getDenominator() / gcd(left.getDenominator(), right.getDenominator());
      
      left.setNumerator(left.getNumerator() * lcm / left.getDenominator());
      left.setDenominator(lcm);

      right.setNumerator(right.getNumerator() * lcm / right.getDenominator());
      right.setDenominator(lcm);
    }
  }

  /**
   * Default toString method. This is used for slash style.
   * 
   * @return The IrreducedMixedFraction in slash style
   */
  public String toString() {
    if (whole == 0 && numerator == 0) {
      return "0";
    }
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
    return str;
}

/**
 * toString method for the solidus style.
 * 
 * @return The IrreducedMixedFraction in solidus style
 */
public String toSolidusString() {
  if (whole == 0 && numerator == 0) {
    return "0";
  }
  String str = "";
  if (!sign) {
    str += "-";
  }
  if (whole != 0) {
    str += whole;
  }
  if (numerator != 0) {
    str += " <sup>" + numerator + "</sup>/<sub>" + denominator + "</sub>";
  }  
  return str;
}

/**
 * toString method for the whole number of the IrreducedMixedFraction for bar style.
 * 
 * @return The whole number of the IrreducedMixedFraciton in bar style
 */
public String toWholeBarString() {
  String str = "";
  if (whole == 0 && numerator == 0) {
    return "0";
  }
  if (!sign) {
    str += "-";
  }
  if (whole != 0) {
    str += whole;
  }
  return str;

}

/**
 * toString method for the fraction part of the IrreducedMixedFraction for bar style.
 * 
 * @return The fraction part of the IrreducedMixedFraction in bar style
 */
public String toFractionBarString() {
  if (numerator != 0) {
   return "<html><div style='text-align: center'>" + numerator + "<hr/>" + denominator + "</div></html>";
  } else {
    return "";
  }
}

/**
 * Allows an IrreducedMixedFraction to be compared to another IrreducedMixedFraction.
 * 
 * @param other The other IrreducedMixedFraction
 * @return -1 if this is less than other, 0 if this is equal to other, or 1 if this is greater than other
 */
public int compareTo(IrreducedMixedFraction other) {
  this.unreduce();
  other.unreduce();
  lcd(this, other);
  int left = numerator;
  if (!sign) {
    left = -left;
  }
  int right = other.numerator;
  if (!other.getSign()) {
    right = -right;
  }
  if (left < right) {
    return -1;
  } else if (left == right) {
    return 0;
  } else {
    return 1;
  }
}
  /**
   * Parses an equation and returns the IrreducedMixedFractions and operator that make up the 
   * equation.
   * @author Dade Buschy
   * @param str the equation to be parsed
   * @return array of the 3 IrreducedMixedFractions and 1 operator that make up the equation,
   * in that order
   */
  public static Object[] parseEquation(final String str)
  {
    int posOp = 0;
    int posEq = 0;
    IrreducedMixedFraction arg1;
    IrreducedMixedFraction arg2;
    IrreducedMixedFraction arg3;
    Object[] ret = new Object[4];
    String[] ops = {"+", "-", "*", "÷", "^", "↔"};
    for (String op: ops)
    {
      if (str.contains(op))
      {
        posOp = str.indexOf(op);
        ret[3] = op;
      }
    }
    posEq = str.indexOf("=");
    arg1 = IrreducedMixedFraction.parseFraction(str.substring(0, posOp));
    arg2 = IrreducedMixedFraction.parseFraction(str.substring(posOp + 1, posEq));
    arg3 = IrreducedMixedFraction.parseFraction(str.substring(posEq + 1));
    ret[0] = arg1;
    ret[1] = arg2;
    ret[2] = arg3;
    return ret;
  }
  /**
   * Parses a String and returns an IrreducedMixedFraction representation.
   * WARNING: this function will only work for Strings produced in the same format as the toString()
   * and does not perform error checking.
   * @author Dade Buschy
   * @param str the string to be parsed
   * @return the IrreducedMixedFraction representation
   */
  public static IrreducedMixedFraction parseFraction(final String str)
  {
    Integer index = 0;
    int pos = 0;
    Integer whole = 0;
    int num = 0;
    int den = 1;
    IrreducedMixedFraction ret = new IrreducedMixedFraction(whole, num, den, true);
    
    if (str.substring(pos, pos + 1).equals("-"))
    {
      ret.setSign(false);
      pos++;
    }
    if (!(str.substring(pos, pos + 1).equals(" ")))
    {
      if (str.contains(" "))
      {
        index = str.indexOf(" ");
        whole = Integer.parseInt(str.substring(pos, index));
        ret.setWhole(whole);
        pos += index - pos;
      }
    }
    else
    {
      String[] ops = {"+", "-", "*", "÷", "^", "↔", "="};
      for (String op: ops)
      {
        if (str.contains(op))
        {
          index = str.indexOf(op);
          whole = Integer.parseInt(str.substring(pos, index));
          ret.setWhole(whole);
          pos += index - pos;
        }
      }
    }
    pos++;
    if (str.contains("/"))
    {
      index = str.indexOf("/");
      num = Integer.parseInt(str.substring(pos, index));
      ret.setNumerator(num);
      pos += index - pos + 1;
      den = Integer.parseInt(str.substring(pos));
      ret.setDenominator(den);
    }
    return ret;
  }
}
