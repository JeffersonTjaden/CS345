/**
 * @author Jefferson Tjaden.
 * @version October 30, 2023
 */
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
  Fraction frac1 = new Fraction(1, 4);
  Fraction frac2 = new Fraction(2, 4);
  
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
  void calculateAddition()
  {
    Operator op = new Operator(frac1, frac2, a);
    Fraction res1 = op.calculate();
    assertEquals(12,res1.getNumerator());
    assertEquals(16,res1.getDenominator());
    assertEquals(0, res1.getWholeNumber());
  }
  
  @Test
  void calculateSubtaction()
  {
    Operator op2 = new Operator(frac2, frac1, s);
    Fraction res2 = op2.calculate();
    assertEquals(4,res2.getNumerator());
    assertEquals(16,res2.getDenominator());
    assertEquals(0, res2.getWholeNumber());
  }
  
  @Test
  void calculateMultiplication()
  {
    Operator op3 = new Operator(frac1, frac2, m);
    Fraction res3 = op3.calculate();
    assertEquals(2,res3.getNumerator());
    assertEquals(16,res3.getDenominator());
    assertEquals(0, res3.getWholeNumber());
  }
  
  @Test
  void calculateDivision()
  {
    Operator op4 = new Operator(frac1, frac2, d);
    Fraction res4 = op4.calculate();
    assertEquals(4,res4.getNumerator());
    assertEquals(8,res4.getDenominator());
    assertEquals(0, res4.getWholeNumber());
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