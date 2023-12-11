/**
 * @author Jefferson Tjaden.
 * @version December 10, 2023
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Operations.Fraction;
import Operations.Operator;

/**
 * The testing class for the unused Operator Class.
 */
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
  void illegalOperation()
  {
    Fraction f1 = new Fraction(1, 2, 3);
    Fraction f2 = new Fraction(4, 5, 6);
    try
    {
      Operator o = new Operator(f1, f2, "hello");
    }
    catch (IllegalArgumentException e)
    {
      // Expected
    }
  }
  
  @Test
  void calculateAddition()
  {
    // Simple Test
    Operator op = new Operator(frac1, frac2, a);
    Fraction res1 = op.calculate();
    assertEquals(3,res1.getNumerator());
    assertEquals(4,res1.getDenominator());
    assertEquals(0, res1.getWholeNumber());
    
    Fraction f = new Fraction(111, 2, true);
    Fraction f2 = new Fraction(2, 3, false);
    op = new Operator(f, f2, a);
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
    // Result is Zero
    
    
  }
  
  @Test
  void calculateSubtaction()
  {
    // Simple Test
    Operator op2 = new Operator(frac2, frac1, s);
    Fraction res2 = op2.calculate();
    assertEquals(1,res2.getNumerator());
    assertEquals(4,res2.getDenominator());
    assertEquals(0, res2.getWholeNumber());
    
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
    // Result is Zero
    
    
  }
  
  @Test
  void calculateMultiplication()
  {
    // Simple Test
    Operator op3 = new Operator(frac1, frac2, m);
    Fraction res3 = op3.calculate();
    assertEquals(1,res3.getNumerator());
    assertEquals(8,res3.getDenominator());
    assertEquals(0, res3.getWholeNumber());
    
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
  }
  
  @Test
  void calculateDivision()
  {
    Operator op4 = new Operator(frac1, frac2, d);
    Fraction res4 = op4.calculate();
    assertEquals(1,res4.getNumerator());
    assertEquals(2,res4.getDenominator());
    assertEquals(0, res4.getWholeNumber());
    
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
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
    assertEquals("3/4", result);
  }
}
