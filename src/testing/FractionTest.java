/**
 * @author Jefferson Tjaden.
 * @version December 10, 2023
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Operations.Fraction;
import utilities.IrreducedMixedFraction;

/**
 * The Testing class for the unused Fraction class in the Operations packagge.
 */
class FractionTest
{

  @Test
  void goodConstructorNoWholeNumber()
  {
    int numerator = 1;
    int denominator = 2;
    Fraction fraction = new Fraction(numerator, denominator);
    assertEquals(1, numerator);
    assertEquals(2, denominator);
  }

  @Test
  void constructorDenominatorZeroNoWholeNumber()
  {
    int numerator = 1;
    int denominator = 0;
    try
    {
      Fraction fraction = new Fraction(numerator, denominator);
    }
    catch (IllegalArgumentException e)
    {
      // Denominator 0, expected.
    }
  }
  
  @Test
  void goodConstructorWithWholeNumber()
  {
    int numerator = 1;
    int denominator = 2;
    int whole = 3;
    Fraction fraction = new Fraction(whole, numerator, denominator);
    assertEquals(1, numerator);
    assertEquals(2, denominator);
  }
  
  @Test
  void constructorDenominatorZeroWithWholeNumber()
  {
    int whole = 2;
    int numerator = 1;
    int denominator = 0;
    try
    {
      Fraction fraction = new Fraction(numerator, denominator, whole);
    }
    catch (IllegalArgumentException e)
    {
      // Denominator 0, expected.
    }
  }
  
  @Test
  void secondConstructor()
  {
    Fraction f = new Fraction(1, 2, true);
    try
    {
      f = new Fraction(1, 0, false);
    }
    catch (IllegalArgumentException e)
    {
      // Expected
    }
  }
  
  @Test
  void fourthConstructor()
  {
    Fraction f = new Fraction(1, 2, 3, true);
    try
    {
      f = new Fraction(1, 0, 2, false);
    }
    catch (IllegalArgumentException e)
    {
      // Expected
    }
  }
  
  @Test
  void expandingFraction()
  {
    int n = 1;
    int d = 2;
    int w = 3;
    Fraction fraction = new Fraction(n, d, w);
    fraction.expandingFraction();
    assertEquals(0, fraction.getWholeNumber());
    assertEquals(2, fraction.getDenominator());
    assertEquals(7, fraction.getNumerator());
    // Whole Number < 0
    w = -1;
    Fraction badFraction = new Fraction(n, d, w);
    fraction.expandingFraction();
  }
  
  @Test
  void mixedNumbers()
  {
    int n = 7;
    int d = 2;
    int w = 0;
    Fraction fraction = new Fraction(n, d, w);
    fraction.mixedNumbers();
    assertEquals(3, fraction.getWholeNumber());
    assertEquals(2, fraction.getDenominator());
    assertEquals(1, fraction.getNumerator());
  }
 
  @Test
  void fractionToString()
  {
    int n = 1;
    int d = 2;
    int w = 3;
    Fraction f1 = new Fraction(n, d, w);
    n = 7;
    d = 2;
    w = 0;
    Fraction f2 = new Fraction(n, d, w);
    String result1 = f1.toString();
    assertEquals("3 1/2", result1);
    String result2 = f2.toString();
    assertEquals("7/2", result2);
    Fraction f3 = new Fraction(1, 2, true);
    f3.toString();
    Fraction f4 = new Fraction(2, 3, 4, true);
    f4.toString();
  }
  
  @Test
  void fractionGetSign()
  {
    Fraction f = new Fraction(1, 2, true);
    f.getSign();
    Fraction f2 = new Fraction(1, 2, false);
    f2.getSign();
  }
  
  @Test
  void simplifyFraction()
  {
    Fraction f = new Fraction(2, 4);
    f.simplifyingFraction();
  }
  
  @Test
  void gcd()
  {
    int a = 2;
    int b = 3;
    Fraction f = new Fraction(a, b);
    f.gcd(b, a);
  }
}