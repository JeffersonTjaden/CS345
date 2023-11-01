/**
 * A immutable Operator Object
 */
public class Operator
{
  private Fraction f1;
  private Fraction f2;
  private Fraction result;
  private String operator;

  /**
   * Constructs a Operator with passed parameters
   * 
   * @param F1
   * @param F2
   * @param operation
   * @throws IllegalArgumentException
   */
  public Operator(Fraction F1, Fraction F2, String operation) throws IllegalArgumentException
  {
    if (F1 == null || F2 == null)
    {
      throw new IllegalArgumentException();
    }
    this.f1 = F1;
    this.f2 = F2;

    this.operator = operation.toLowerCase();
  }

  /**
   * Calls all the different calculations methods
   *
   * @return the ComputedFraction
   */
  public Fraction calculate()
  {
    switch (operator)
    {
      case "addition":
        Addition(f1, f2);
        break;
      case "subtraction":
        Subtraction(f1, f2);
        break;
      case "multiplication":
        Multiplication(f1, f2);
        break;
      case "division":
        Division(f1, f2);
        break;
      default:
        // Error unknown operator
        break;
    }
    return result;
  }

  /**
   * Addition Operator
   */
  private void Addition(final Fraction f1, final Fraction f2)
  {
    int numerator, denominator;
    f1.expandingFraction();
    f2.expandingFraction();

    // Handles negative numbers and performs computation
    if (f1.getSign() && !f2.getSign())
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          + (f2.getNumerator() * f1.getDenominator());
      denominator = (f1.getDenominator() * f2.getDenominator());
    }
    else if (!f1.getSign() && f2.getSign())
    {
      numerator = (f1.getNumerator() * f2.getDenominator())
          + ((-1) * f2.getNumerator() * f1.getDenominator());
      denominator = (f1.getDenominator() * f2.getDenominator());
    }
    else if (f1.getSign() && f2.getSign())
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          + ((-1) * f2.getNumerator() * f1.getDenominator());
      denominator = (f1.getDenominator() * f2.getDenominator());
    }
    else
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          + (f2.getNumerator() * f1.getDenominator());

      denominator = (f1.getDenominator() * f2.getDenominator());
    }

    // Handles if a negative numerator
    if (numerator < 0)
    {
      numerator = Math.abs(numerator);
      result = new Fraction(numerator, denominator, true);
      result.mixedNumbers();
      result.simplifyingFraction();
    }
    else
    {
      result = new Fraction(numerator, denominator, false);
      result.mixedNumbers();
      result.simplifyingFraction();
    }
  }

  /**
   * Subtraction Operator
   */
  private void Subtraction(final Fraction f1, final Fraction f2)
  {
    int numerator, denominator;
    f1.expandingFraction();
    f2.expandingFraction();

    // Handles negative numbers and performs computation
    if (f1.getSign() && !f2.getSign())
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          - (f2.getNumerator() * f1.getDenominator());

      denominator = (f1.getDenominator() * f2.getDenominator());
    }
    else if (!f1.getSign() && f2.getSign())
    {
      numerator = (f1.getNumerator() * f2.getDenominator())
          - ((-1) * f2.getNumerator() * f1.getDenominator());

      denominator = (f1.getDenominator() * f2.getDenominator());
    }
    else if (f1.getSign() && f2.getSign())
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          - ((-1) * f2.getNumerator() * f1.getDenominator());

      denominator = (f1.getDenominator() * f2.getDenominator());
      System.out.println("Numerator:" + numerator + " Denominator:" + denominator);
    }
    else
    {
      numerator = ((-1) * f1.getNumerator() * f2.getDenominator())
          - (f2.getNumerator() * f1.getDenominator());

      denominator = (f1.getDenominator() * f2.getDenominator());
    }

    // Handles if a negative numerator
    if (numerator < 0)
    {
      numerator = Math.abs(numerator);
      result = new Fraction(numerator, denominator, true);
      result.mixedNumbers();
      result.simplifyingFraction();
    }
    else
    {
      result = new Fraction(numerator, denominator, false);
      result.mixedNumbers();
      result.simplifyingFraction();
    }
  }

  /**
   * Multiplication Operator
   */
  private void Multiplication(Fraction f1, Fraction f2)
  {
    int numerator, denominator;

    f1.expandingFraction();
    f2.expandingFraction();

    numerator = (f1.getNumerator() * f2.getNumerator());
    denominator = (f1.getDenominator() * f2.getDenominator());
    result = new Fraction(numerator, denominator);

    if (f1.getSign() ^ f2.getSign())
    {
      result.setSign(true);
    }

    result.mixedNumbers();
    result.simplifyingFraction();
  }

  /**
   * Division Operator
   */
  private void Division(Fraction F1, Fraction F2)
  {
    int numerator, denominator;

    F1.expandingFraction();
    F2.expandingFraction();

    numerator = (F1.getNumerator() * F2.getDenominator());
    denominator = (F1.getDenominator() * F2.getNumerator());
    result = new Fraction(numerator, denominator);

    if (F1.getSign() ^ F2.getSign())
    {
      result.setSign(true);
    }

    result.mixedNumbers();
    result.simplifyingFraction();
  }

  /**
   * Create a String representation of this Operator
   * 
   * @return The String representation of the Computed Fraction
   */
  public String toString()
  {
    return result.toString();
  }
}
