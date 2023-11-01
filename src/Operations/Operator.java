/**
 * A immutable Operator Object
 */
public class Operator
{
  private Fraction f1;
  private Fraction f2;
  private Fraction result;
  private String operator;
  private final String[] Operators = {"addition", "subtraction", "multiplication", "division"};

  /**
   * Constructs a Operator with passed parameters
   * 
   * @param f1
   * @param f2
   * @param operation
   * @throws IllegalArgumentException
   */
  public Operator(final Fraction f1,final Fraction f2,final String operation) throws IllegalArgumentException
  {
    boolean inEnum = false;
    
    if (f1 == null || f2 == null)
    {
      throw new IllegalArgumentException();
    }
    
    for(String operator : Operators) {
      if(operation.equalsIgnoreCase(operator)) {
        inEnum = true;
      }
    }
    
    if(!inEnum) {
      throw new IllegalArgumentException();
    }
    
    this.f1 = f1;
    this.f2 = f2;

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
    result.mixedNumbers();
    result.simplifyingFraction();
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
    }
    else
    {
      result = new Fraction(numerator, denominator, false);
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
    }
    else
    {
      result = new Fraction(numerator, denominator, false);
    }
  }

  /**
   * Multiplication Operator
   */
  private void Multiplication(final Fraction f1,final Fraction f2)
  {
    int numerator, denominator;

    f1.expandingFraction();
    f2.expandingFraction();

    numerator = (f1.getNumerator() * f2.getNumerator());
    denominator = (f1.getDenominator() * f2.getDenominator());

    if (f1.getSign() ^ f2.getSign())
    {
      result = new Fraction(numerator, denominator, true);
    }
    else {
      result = new Fraction(numerator, denominator, false);
    }
  }

  /**
   * Division Operator
   */
  private void Division(final Fraction f1,final Fraction f2)
  {
    int numerator, denominator;

    f1.expandingFraction();
    f2.expandingFraction();

    numerator = (f1.getNumerator() * f2.getDenominator());
    denominator = (f1.getDenominator() * f2.getNumerator());
    

    if (f1.getSign() ^ f2.getSign())
    {
      result = new Fraction(numerator, denominator, true);
    }
    else {
      result = new Fraction(numerator, denominator, false);
    }
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
