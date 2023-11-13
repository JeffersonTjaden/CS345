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

  int numerator = 1;
  int denominator = 2;
  int whole = 3;
  boolean sign = false;
  
  @Test
  void goodConstructor1()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, sign);
    assertEquals(1, numerator);
    assertEquals(sign, false);
  }
  
  @Test
  void goodConstructor2()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator);
    assertEquals(1, numerator);
    assertEquals(2, denominator);
  }
  
  @Test
  void badConstructor2()
  {
    denominator = 0;
    try
    {
      IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
  }
  
  @Test
  void goodConstructor3()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator, sign);
    assertEquals(1, numerator);
    assertEquals(2, denominator);
    assertEquals(false, sign);
  }
  
  @Test
  void badConstructor3()
  {
    int denominator = 0;
    try
    {
      IrreducedMixedFraction fraction = new IrreducedMixedFraction(numerator, denominator, sign);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
  }
  
  @Test
  void goodConstructor4()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator, sign);
    assertEquals(1, numerator);
    assertEquals(2, denominator);
    assertEquals(false, sign);
    assertEquals(3, whole);
  }
  
  @Test
  void badConstructor4()
  {
    int denominator = 0;
    try
    {
      IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator, sign);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
  }
  
  @Test
  void gettersAndSetters()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(whole, numerator, denominator, sign);
    fraction.setWhole(4);
    fraction.setNumerator(5);
    fraction.setDenominator(6);
    fraction.setSign(true);
    assertEquals(4, fraction.getWhole());
    assertEquals(5, fraction.getNumerator());
    assertEquals(6, fraction.getDenominator());
    assertEquals(true, fraction.getSign());
    try
    {
      fraction.setDenominator(0);
    }
    catch (IllegalArgumentException e)
    {
      // Expected
    }
  }
  
  @Test
  void reduce()
  {
    IrreducedMixedFraction fraction = new IrreducedMixedFraction(0, 4, 2, false);
    IrreducedMixedFraction f2 = new IrreducedMixedFraction(1, 5, 2, false);
    IrreducedMixedFraction f3 = new IrreducedMixedFraction(1, 1, 2, false);
    fraction.reduce();
    // whole > 0, numerator < 0
    f2.setNumerator(-5);
    f2.reduce();
    IrreducedMixedFraction f4 = new IrreducedMixedFraction(1, 5, 2, false);
    f4.setNumerator(-5);
    f4.setWhole(-10);
    // whole < 0, numerator > 0
    f3.setWhole(-1);
    f3.reduce();
  }
  
  @Test
  void unreduce()
  {
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(0, 4, 2, false);
    IrreducedMixedFraction f2 = new IrreducedMixedFraction(1, 2, 4, false);
    IrreducedMixedFraction f3 = new IrreducedMixedFraction(0, 2, 2, true);
    IrreducedMixedFraction f4 = new IrreducedMixedFraction(0, 0, 2, true);
    IrreducedMixedFraction f5 = new IrreducedMixedFraction(0, 4, 2, false);
    f1.unreduce();
    f2.unreduce();
    f3.setWhole(-1);
    f3.unreduce();
  }
  
  @Test
  void invert()
  {
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(0, 4, 2, false);
    f1.invert();
    assertEquals(2, f1.getNumerator());
    assertEquals(4, f1.getDenominator());
    f1.setNumerator(0);
    f1.invert();
  }
  
  @Test
  void simplify()
  {
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(0, 4, 2, false);
    f1.simplify();
  }
  
  @Test void gcd()
  {
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(0, 1, 4, false);
    IrreducedMixedFraction f2 = new IrreducedMixedFraction(0, 1, 3, false);
    IrreducedMixedFraction.gcd(f1, f2);
    IrreducedMixedFraction f3 = new IrreducedMixedFraction(0, 4, 2, false);
    IrreducedMixedFraction f4 = new IrreducedMixedFraction(0, 4, 2, false);
    IrreducedMixedFraction.gcd(f3, f4);
  }
  
  @Test
  void fractionToString()
  {
    IrreducedMixedFraction f1 = new IrreducedMixedFraction(0, 4, 2, false);
    f1.toString();
    IrreducedMixedFraction f2 = new IrreducedMixedFraction(0, 4, 2, true);
    f2.toString();
    IrreducedMixedFraction f3 = new IrreducedMixedFraction(3, 4, 2, false);
    f3.toString();
    f3.setWhole(0);
    f3.toString();
    IrreducedMixedFraction f4 = new IrreducedMixedFraction(0, 2, 2, false);
    f4.toString();
    f4.setNumerator(1);
    f4.toString();
    IrreducedMixedFraction f5 = new IrreducedMixedFraction(0, 0, 2, false);
    f5.toString();
    f5.setNumerator(1);
    f5.toString();
  }
}
