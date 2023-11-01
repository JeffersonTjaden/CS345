/**
 * @author Jefferson Tjaden.
 * @version October 30, 2023
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Operations.Fraction;
import utilities.IrreducedMixedFraction;

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
  void negativeConstructor()
  {
    
  }
  
  @Test
  void getAndSetWholeNumeratorDenominator()
  {
    int numerator = 1;
    int denominator = 2;
    int whole = 3;
    Fraction fraction = new Fraction(numerator, denominator, whole);
    // Whole Number
    fraction.setWholeNumber(4);
    assertEquals(4, fraction.getWholeNumber());
    // Numerator
    fraction.setNumerator(5);
    assertEquals(5, fraction.getNumerator());
    // Denominator
    fraction.setDenominator(6);
    assertEquals(6, fraction.getDenominator());
    // Set Denominator to 0.
    try
    {
      fraction.setDenominator(0);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
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
  }
}