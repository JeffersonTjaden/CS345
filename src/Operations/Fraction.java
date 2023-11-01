/**
 * A immutable Fraction Object
 */
public class Fraction
{
  private int numerator;
  private int denominator;
  private int wholeNumber;
  private boolean sign;

  /**
   * Constructs a Fraction with passed parameters and a wholeNumber 0
   * 
   * @param numerator
   * @param denominator
   * @throws IllegalArgumentException
   */
  public Fraction(final int numerator, final int denominator) throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = 0;
    this.sign = false;
  }

  /**
   * 
   * @param numerator
   * @param denominator
   * @param sign
   * @throws IllegalArgumentException
   */
  public Fraction(final int numerator, final int denominator, final boolean sign)
      throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = 0;
    this.sign = sign;
  }

  /**
   * Constructs a Fraction with passed parameters
   * 
   * @param numerator
   * @param denominator
   * @param wholeNumber
   * @throws IllegalArgumentException
   */
  public Fraction(final int numerator, final int denominator, final int wholeNumber)
      throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = wholeNumber;
    this.sign = false;
  }

  public Fraction(final int numerator, final int denominator, final int wholeNumber,
      final boolean sign) throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = wholeNumber;
    this.sign = sign;
  }

  /**
   * Get the numerator with this Fraction object.
   * 
   * @return the numerator
   */
  public int getNumerator()
  {
    return numerator;
  }

  /**
   * Get the denominator with this Fraction object.
   * 
   * @return the denominator
   */
  public int getDenominator()
  {
    return denominator;
  }

  /**
   * Get the whole number with this Fraction object.
   * 
   * @return the wholeNumber
   */
  public int getWholeNumber()
  {
    return wholeNumber;
  }

  /**
   * Get the sign with this Fraction object.
   * 
   * @return the sign
   */
  public boolean getSign()
  {
    return sign;
  }

  /**
   * Expands the fraction from a mixed number to a improper fraction
   */
  public void expandingFraction()
  {
    if (wholeNumber >= 0)
    {
      numerator = numerator + wholeNumber * denominator;
      wholeNumber = 0;
    }
  }

  /**
   * Simplifies fraction down to smallest possible
   */
  public void simplifyingFraction()
  {
    int greatestCommonDivisor = gcd(this.numerator, this.denominator);

    numerator = numerator / greatestCommonDivisor;
    denominator = denominator / greatestCommonDivisor;
  }

  /**
   * Converts improper fractions to proper fractions(mixed number)
   */
  public void mixedNumbers()
  {
    if (numerator >= denominator)
    {
      wholeNumber = numerator / denominator;
      numerator = numerator % denominator;
    }
  }

  /**
   * Computes the greatest common divisor without recursion
   * 
   * @param inE
   * @param inZ
   * @return
   */
  public int gcd(final int inE,final int inZ)
  {
    int num0 = 0, num1 = 0;
    int arr[] = new int[2];
    int q = 0;

    // Handles input so num0 is always the greater number
    if (inE < inZ)
    {
      num0 = inE;
      num1 = inZ;
    }
    else
    {
      num0 = inZ;
      num1 = inE;
    }

    // gcd computation
    arr[0] = num0;
    arr[1] = num1;
    while (arr[1] != 0)
    {
      q = arr[0] % arr[1];
      arr[0] = arr[1];
      arr[1] = q;
    }

    return arr[0];
  }

  /**
   * Create a String representation of this Fraction
   * 
   * @return The String representation
   */
  public String toString()
  {
    if (wholeNumber > 0)
    {
      if (sign == true)
      {
        return String.format("-%s %s/%s", wholeNumber, numerator, denominator);
      }
      else
      {
        return String.format("%s %s/%s", wholeNumber, numerator, denominator);
      }
    }
    else
    {
      if (sign == true)
      {
        return String.format("-%s/%s", numerator, denominator);
      }
      else
      {
        return String.format("%s/%s", numerator, denominator);
      }

    }
  }
}
