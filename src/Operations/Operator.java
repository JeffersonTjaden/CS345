/**
 * A immutable Operator Object
 */
public class Operator
{
  private Fraction F1;
  private Fraction F2;
  private Fraction ComputedFraction;
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
    this.F1 = F1;
    this.F2 = F2;

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
        Addition(F1, F2);
        break;
      case "subtraction":
        Subtraction(F1, F2);
        break;
      case "multiplication":
        Multiplication(F1, F2);
        break;
      case "division":
        Division(F1, F2);
        break;
      default:
        // Error unknown operator
        break;
    }
    return ComputedFraction;
  }

  /**
   * Addition Operator
   */
  private void Addition(Fraction F1, Fraction F2)
  {
    int numerator, denominator;
    F1.expandingFraction();
    F2.expandingFraction();

    // Handles if sign of F1 is negative
    if (F1.getSign() == true && F2.getSign() == false)
    {
      Subtraction(F2, F1);
    }
    // Handles if sign of F2 is negative
    else if (F1.getSign() == false && F2.getSign() == true)
    {
      F2.setSign(false);
      Subtraction(F1, F2);
    }
    // Handles if sign of F1 and F2 are negative
    else if (F1.getSign() == true && F2.getSign() == true)
    {
      numerator = (F1.getNumerator() * F2.getDenominator())
          + (F2.getNumerator() * F1.getDenominator());

      denominator = (F1.getDenominator() * F2.getDenominator());

      ComputedFraction = new Fraction(numerator, denominator);
      ComputedFraction.setSign(true);
    }
    // Handles if both sign's are positive
    else
    {
      numerator = (F1.getNumerator() * F2.getDenominator())
          + (F2.getNumerator() * F1.getDenominator());

      denominator = (F1.getDenominator() * F2.getDenominator());

      ComputedFraction = new Fraction(numerator, denominator);
      ComputedFraction.setSign(false);
    }
    ComputedFraction.mixedNumbers();
  }

  /**
   * Subtraction Operator
   */
  private void Subtraction(Fraction F1, Fraction F2)
  {
    int numerator, denominator;
    F1.expandingFraction();
    F2.expandingFraction();
    // Handles if sign of F1 is negative
    if (F1.getSign() == true && F2.getSign() == false)
    {
      F1.setSign(false);
      Addition(F1, F2);
      ComputedFraction.setSign(true);
    }
    // Handles if sign of F2 is negative
    else if (F1.getSign() == false && F2.getSign() == true)
    {
      F2.setSign(false);
      Addition(F1, F2);
    }
    // Handles if sign of F1 and F2 are negative
    else if (F1.getSign() == true && F2.getSign() == true)
    {
      F1.setSign(false);
      F2.setSign(false);
      Subtraction(F2, F1);
    }
    // Handles if both sign's are positive
    else
    {
      System.out.println("You are here");
      numerator = (F1.getNumerator() * F2.getDenominator())
          - (F2.getNumerator() * F1.getDenominator());

      denominator = (F1.getDenominator() * F2.getDenominator());

      ComputedFraction = new Fraction(numerator, denominator);
    }
    ComputedFraction.mixedNumbers();
  }

  /**
   * Multiplication Operator
   */
  private void Multiplication(Fraction F1, Fraction F2)
  {
    int numerator, denominator;

    F1.expandingFraction();
    F2.expandingFraction();

    numerator = (F1.getNumerator() * F2.getNumerator());
    denominator = (F1.getDenominator() * F2.getDenominator());
    ComputedFraction = new Fraction(numerator, denominator);

    if (F1.getSign() == true ^ F2.getSign())
    {
      ComputedFraction.setSign(true);
    }

    ComputedFraction.mixedNumbers();
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
    ComputedFraction = new Fraction(numerator, denominator);
    
    if (F1.getSign() == true ^ F2.getSign())
    {
      ComputedFraction.setSign(true);
    }
    
    ComputedFraction.mixedNumbers();
  }

  /**
   * Create a String representation of this Operator
   * 
   * @return The String representation of the Computed Fraction
   */
  public String toString()
  {
    return ComputedFraction.toString();
  }
}
