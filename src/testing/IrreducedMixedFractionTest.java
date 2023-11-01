/**
 * @author Jefferson Tjaden.
 * @version October 30, 2023
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.IrreducedMixedFraction;

class IrreducedMixedFractionTest
{

  @Test
  void goodConstructorNoWholeNumber()
  {
    int numerator = 1;
    int denominator = 2;
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator);
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
      IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator);
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
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator);
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
      IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator);
    }
    catch (IllegalArgumentException e)
    {
      // Denominator 0, expected.
    }
  }
  
  @Test
  void getAndSetWholeNumeratorDenominator()
  {
    int numerator = 1;
    int denominator = 2;
    int whole = 3;
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator);
    // Whole Number
    fraction.setWhole(4);
    assertEquals(4, fraction.getWhole());
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
  void reduce()
  {
    int numerator = 4;
    int denominator = 2;
    int whole = 0;
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator);
    fraction.reduce();
    assertEquals(2, fraction.getWhole());
    assertEquals(0, fraction.getNumerator());
    assertEquals(2, fraction.getDenominator());
  }
  @Test
  void unreduce()
  {
    int numerator = 0;
    int denominator = 2;
    int whole = 2;
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator);
    fraction.unreduce();
    assertEquals(0, fraction.getWhole());
    assertEquals(4, fraction.getNumerator());
    assertEquals(2, fraction.getDenominator());
  }
  
  @Test
  void gcd()
  {
    int w1 = 2;
    int n1 = 1;
    int d1 = 2;
    int w2 = 1;
    int n2 = 3;
    int d2 = 4;
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(w1, n1, d1);
    IrreducedMixedFraction f2 = new IrreducedMixedFraction(w2, n2, d2);
    IrreducedMixedFraction.gcd(f1, f2);
    int w3 = 5;
    int n3 = 10;
    int d3 = 2;
    IrreducedMixedFraction f3 = new IrreducedMixedFraction(w3, n3, d3);
    IrreducedMixedFraction.gcd(f3, f1);
  }
  
  @Test
  void changeSign()
  {
    IrreducedMixedFraction f = new IrreducedMixedFraction(1, 2, 3);
    f.changeSign();
    assertEquals(-1, f.getWhole());
    f = new IrreducedMixedFraction(2, 3);
    f.changeSign();
    assertEquals(-2, f.getNumerator());
  }
}
