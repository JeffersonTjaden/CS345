package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Operations.Fraction;
import Operations.Operator;

class OperatorTest
{
  String a = "addition";
  String s = "subtraction";
  String m = "multiplication";
  String d = "division";
  
  @Test
  void constructorGood()
  {
    Fraction f1 = new Fraction(1, 2, 3);
    Fraction f2 = new Fraction(4, 5, 6);
    Operator op = new Operator(f1, f2, a);
  }
  
  @Test
  void constructorF1Null()
  {
    Fraction f1 = null;
    Fraction f2 = new Fraction(4, 5, 6);
    try
    {
      Operator op = new Operator(f1, f2, a);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
  }

  @Test
  void constructorF2Null()
  {
    Fraction f1 = new Fraction(1, 2, 3);
    Fraction f2 = null;
    try
    {
      Operator op = new Operator(f1, f2, a);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
  }
  
  @Test
  void calculate()
  {
    Fraction f1 = new Fraction(1, 4);
    Fraction f2 = new Fraction(2, 4);
    Operator op = new Operator(f1, f2, a);
    op.calculate();
    Operator op2 = new Operator(f2, f1, s);
    op2.calculate();
    Operator op3 = new Operator(f1, f2, m);
    op3.calculate();
    Operator op4 = new Operator(f1, f2, d);
    op4.calculate();
  }
  
  @Test
  void operatorToString()
  {
    Fraction f1 = new Fraction(1, 4);
    Fraction f2 = new Fraction(2, 4);
    Operator op = new Operator(f1, f2, a);
    op.calculate();
    String result = op.toString();
    // Result is not in simplest form
    assertEquals("12/16", result);
  }
}
