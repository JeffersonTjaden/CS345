package Operations;
/**
 * A immutable Operator Object
 */
public class Operator
{
  Fraction F1;
  Fraction F2;
  Fraction ComputedFraction;
  String operator;

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
   */
  public Fraction calculate()
  {
    switch (operator)
    {
      case "addition":
        F1.expandingFraction();
        F2.expandingFraction();
        Addition();
        ComputedFraction.mixedNumbers();
        break;
      case "subtraction":
        F1.expandingFraction();
        F2.expandingFraction();
        Subtraction();
        ComputedFraction.mixedNumbers();
        break;
      case "multiplication":
        F1.expandingFraction();
        F2.expandingFraction();
        Multiplication();
        ComputedFraction.mixedNumbers();
        break;
      case "division":
        F1.expandingFraction();
        F2.expandingFraction();
        Division();
        ComputedFraction.mixedNumbers();
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
  private void Addition()
  {
    int numerator, denominator;
    numerator = (F1.getNumerator() * F2.getDenominator())
        + (F2.getNumerator() * F1.getDenominator());
    denominator = (F1.getDenominator() * F2.getDenominator());
    ComputedFraction = new Fraction(numerator, denominator);
  }

  /**
   * Subtraction Operator
   */
  private void Subtraction()
  {
    int numerator, denominator;
    numerator = (F1.getNumerator() * F2.getDenominator())
        - (F2.getNumerator() * F1.getDenominator());
    denominator = (F1.getDenominator() * F2.getDenominator());
    ComputedFraction = new Fraction(numerator, denominator);
  }

  /**
   * Multiplication Operator
   */
  private void Multiplication()
  {
    int numerator, denominator;
    numerator = (F1.getNumerator() * F2.getNumerator());
    denominator = (F1.getDenominator() * F2.getDenominator());
    ComputedFraction = new Fraction(numerator, denominator);
  }

  /**
   * Division Operator
   */
  private void Division()
  {
    int numerator, denominator;
    numerator = (F1.getNumerator() * F2.getDenominator());
    denominator = (F1.getDenominator() * F2.getNumerator());
    ComputedFraction = new Fraction(numerator, denominator);
  }

  /**
   * Create a String representation of this Operator
   * 
   * 
   * @return The String representation of the Computed Fraction
   */
  public String toString()
  {
    return ComputedFraction.toString();
  }
}

