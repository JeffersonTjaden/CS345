/**
 * A mutable Fraction Object
 */
public class Fraction
{
  private int numerator;
  private int denominator;
  private int wholeNumber;

  /**
   * Constructs a Fraction with passed parameters and a wholeNumber 0
   * 
   * @param numerator
   * @param denominator
   * @throws IllegalArgumentException
   */
  public Fraction(int numerator, int denominator) throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = 0;
  }
  
  /**
   * Constructs a Fraction with passed parameters
   * @param numerator
   * @param denominator
   * @param wholeNumber
   * @throws IllegalArgumentException
   */
  public Fraction(int numerator, int denominator, int wholeNumber) throws IllegalArgumentException
  {
    if (denominator == 0)
    {
      throw new IllegalArgumentException("Divide by 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
    this.wholeNumber = wholeNumber;
  }

  /**
   * Sets the numerator with this Fraction object.
   * 
   * @param numerator
   */
  public void setNumerator(int numerator)
  {
    this.numerator = numerator;
  }

  /**
   * Sets the denominator with this Fraction object.
   * @param denominator
   */
  public void setDenominator(int denominator)
  {
    this.denominator = denominator;
  }

  /**
   * Sets the whole number with this Fraction object.
   * 
   * @param wholeNumber
   */
  public void setWholeNumber(int wholeNumber)
  {
    this.wholeNumber = wholeNumber;
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
   * Create a String representation of this Fraction
   * 
   * @return The String representation
   */
  public String toString()
  {
    if(wholeNumber > 0) {
      return String.format("%s %s/%s", wholeNumber, numerator, denominator);
    }
    else {
      return String.format("%s/%s", numerator, denominator);
    }
  }
}
