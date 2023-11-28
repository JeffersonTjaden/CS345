/**
 * @author Jefferson Tjaden.
 * @version October 30, 2023
 */
package testing;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import utilities.IrreducedMixedFraction;
import utilities.Operations;

/**
 * 
 */
public class OperationsTest
{
  /**
   * 
   */
  @Test
  public void defaultConstructor()
  {
    Operations o = new Operations();
  }
  
  /**
   * 
   */
  @Test
  public void testAdd() 
  {
    // Simple Test
    IrreducedMixedFraction left = new IrreducedMixedFraction(734, 83, true);
    IrreducedMixedFraction right = new IrreducedMixedFraction(567, 43, true);
    IrreducedMixedFraction result = Operations.add(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(78623, result.getNumerator());
    assertEquals(83*43, result.getDenominator());
    
    // One Fraction Zero
    IrreducedMixedFraction left2 = new IrreducedMixedFraction(0, 2, true);
    IrreducedMixedFraction right2 = new IrreducedMixedFraction(1, 2, true);
    result = Operations.add(left2, right2);
    assertEquals(0, result.getWhole());
    assertEquals(1, result.getNumerator());
    assertEquals(2, result.getDenominator());
    // Both Fractions Zero
    IrreducedMixedFraction left3 = new IrreducedMixedFraction(0, 2, true);
    IrreducedMixedFraction right3 = new IrreducedMixedFraction(0, 3, true);
    result = Operations.add(left3, right3);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(6, result.getDenominator());
    
    // One Fraction Negative
    IrreducedMixedFraction left4 = new IrreducedMixedFraction(1, 3, true);
    IrreducedMixedFraction right4 = new IrreducedMixedFraction(2, 3, false);
    result = Operations.add(left4, right4);
    IrreducedMixedFraction finalResult = new IrreducedMixedFraction(result.getNumerator(),
        result.getDenominator(), true);
    assertEquals(0, finalResult.getWhole());
    finalResult.setNumerator(-1);
    assertEquals(-1, finalResult.getNumerator());
    assertEquals(3, finalResult.getDenominator());
    
    // Both Negative
    IrreducedMixedFraction left5 = new IrreducedMixedFraction(1, 3, true);
    IrreducedMixedFraction right5 = new IrreducedMixedFraction(2, 3, true);
    result = Operations.add(left5, right5);
    assertEquals(0, result.getWhole());
    assertEquals(3, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Result is Zero
    IrreducedMixedFraction left6 = new IrreducedMixedFraction(1, 3, true);
    IrreducedMixedFraction right6 = new IrreducedMixedFraction(1, 3, false);
    result = Operations.add(left6, right6);;
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Additional Sign Testing
    // T, T
    IrreducedMixedFraction l = new IrreducedMixedFraction(1, 2, true);
    IrreducedMixedFraction r = new IrreducedMixedFraction(2, 3, true);
    Operations.add(l, r);
    // F, F
    l.setSign(false);
    r.setSign(false);
    Operations.add(l, r);
    // F, T
    l.setSign(false);
    r.setSign(true);
    Operations.add(l, r);
    // T, F
    l.setSign(true);
    r.setSign(false);
    Operations.add(l, r);
  }
  
  /**
   * 
   */
  @Test
  public void testSubtract() 
  {
    IrreducedMixedFraction left = new IrreducedMixedFraction(345, 61, 893, false);
    IrreducedMixedFraction right = new IrreducedMixedFraction(23, 72, 442, false);
    IrreducedMixedFraction result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(127057998, result.getNumerator());
    assertEquals(893*442, result.getDenominator());
    
    // First Fraction Zero
    left = new IrreducedMixedFraction(0, 5, true);
    right = new IrreducedMixedFraction(2, 5, true);
    result = Operations.subtract(left, right);
    
    assertEquals(0, result.getWhole());
    IrreducedMixedFraction finalResult = new IrreducedMixedFraction(result.getNumerator(),
        result.getDenominator(), true);
    finalResult.setNumerator(-2);
    assertEquals(-2, finalResult.getNumerator());
    assertEquals(5, finalResult.getDenominator());
    
    // Second Fraction Zero
    left = new IrreducedMixedFraction(2, 5, true);
    right = new IrreducedMixedFraction(0, 5, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(2, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Both Fractions Zero
    left = new IrreducedMixedFraction(0, 5, true);
    right = new IrreducedMixedFraction(0, 3, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(15, result.getDenominator());
    
    // First Fraction Negative
    left = new IrreducedMixedFraction(1, 5, true);
    right = new IrreducedMixedFraction(2, 5, true);
    result = Operations.subtract(left, right);
    finalResult = new IrreducedMixedFraction(result.getNumerator(),
        result.getDenominator(), true);
    assertEquals(0, result.getWhole());
    finalResult.setNumerator(-3);
    assertEquals(-3, finalResult.getNumerator());
    assertEquals(5, finalResult.getDenominator());
    
    // Second Fraction Negative
    left = new IrreducedMixedFraction(1, 5, true);
    right = new IrreducedMixedFraction(2, 5, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(1, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Both Negative
    left = new IrreducedMixedFraction(1, 5, true);
    right = new IrreducedMixedFraction(2, 5, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(1, result.getNumerator());
    assertEquals(5, result.getDenominator());

    // Result is Zero
    left = new IrreducedMixedFraction(3, 5, true);
    right = new IrreducedMixedFraction(3, 5, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Result is Zero but with different fractions
    left = new IrreducedMixedFraction(3, 5, true);
    right = new IrreducedMixedFraction(15, 25, true);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(125, result.getDenominator());
    
    // Whole Number Test
    left = new IrreducedMixedFraction(1, 3, 5, false);
    right = new IrreducedMixedFraction(1, 15, 25, false);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(125, result.getDenominator());
    
    // Additional Sign Testing
    IrreducedMixedFraction l = new IrreducedMixedFraction(1, 2, true);
    IrreducedMixedFraction r = new IrreducedMixedFraction(2, 3, true);
    Operations.subtract(l, r);
    l.setSign(false);
    r.setSign(false);
    Operations.subtract(l, r);
    l.setSign(false);
    r.setSign(true);
    Operations.subtract(l, r);
    l.setSign(true);
    r.setSign(false);
    Operations.subtract(l, r);
  }
  
  /**
   * 
   */
  @Test
  public void testMultiply() 
  {
    // Simple Test
    IrreducedMixedFraction left = new IrreducedMixedFraction(12, 13, 44, false);
    IrreducedMixedFraction right = new IrreducedMixedFraction(23, 7, 18, false);
    IrreducedMixedFraction result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(227761, result.getNumerator());
    assertEquals(792, result.getDenominator());
    
    // One Fraction Zero
    left = new IrreducedMixedFraction(2, 5, true);
    right = new IrreducedMixedFraction(0, 5, true);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(25, result.getDenominator());
    
    // Both Fractions Zero
    left = new IrreducedMixedFraction(0, 0, 5, false);
    right = new IrreducedMixedFraction(0, 0, 3, false);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(15, result.getDenominator());
    
    // One Fraction Negative
    left = new IrreducedMixedFraction(2, 5, true);
    right = new IrreducedMixedFraction(3, 5, true);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    IrreducedMixedFraction finalResult = new IrreducedMixedFraction(result.getNumerator(),
        result.getDenominator(), true);
    finalResult.setNumerator(-6);
    assertEquals(-6, finalResult.getNumerator());
    assertEquals(25, finalResult.getDenominator());
    
    // Both Negative
    left = new IrreducedMixedFraction(2, 5, true);
    right = new IrreducedMixedFraction(3, 5, true);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(6, result.getNumerator());
    assertEquals(25, result.getDenominator());
    
 // Additional Sign Testing
    IrreducedMixedFraction l = new IrreducedMixedFraction(1, 2, true);
    IrreducedMixedFraction r = new IrreducedMixedFraction(2, 3, true);
    Operations.multiply(l, r);
    l.setSign(false);
    r.setSign(false);
    Operations.multiply(l, r);
    l.setSign(false);
    r.setSign(true);
    Operations.multiply(l, r);
    l.setSign(true);
    r.setSign(false);
    Operations.multiply(l, r);
  }
  
  /**
   * 
   */
  @Test
  public void testDivide() 
  {
    // Simple Test
    IrreducedMixedFraction left = new IrreducedMixedFraction(6, 7, 11, false);
    IrreducedMixedFraction right = new IrreducedMixedFraction(8, 3, 17, false);
    IrreducedMixedFraction result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(1241, result.getNumerator());
    assertEquals(1529, result.getDenominator());
    
    // First Fraction Zero
    left = new IrreducedMixedFraction(0, 3, true);
    right = new IrreducedMixedFraction(1, 9, true);
    result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Second Fraction Zero
    left = new IrreducedMixedFraction(2, 3, true);
    right = new IrreducedMixedFraction(0, 9, true);
    try
    {
      result = Operations.divide(left, right);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
    
    // First Fraction Negative
    left = new IrreducedMixedFraction(2, 3, true);
    right = new IrreducedMixedFraction(1, 9, true);
    result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    IrreducedMixedFraction finalResult = new IrreducedMixedFraction(result.getNumerator(),
        result.getDenominator(), true);
    finalResult.setNumerator(-18);
    assertEquals(-18, finalResult.getNumerator());
    assertEquals(3, finalResult.getDenominator());
    
    // Second Fraction Negative
    left = new IrreducedMixedFraction(7, 11, false);
    right = new IrreducedMixedFraction(5, 13, true);
    right.setNumerator(-5);
    assertEquals(-5, right.getNumerator());
    assertEquals(13, right.getDenominator());
    // result = Operations.divide(left, right);
    // assertEquals(0, result.getWhole());
    // assertEquals(-91, result.getNumerator());
    // assertEquals(55, result.getDenominator());
    
    // Both Negative
    
 // Additional Sign Testing
    IrreducedMixedFraction l = new IrreducedMixedFraction(1, 2, true);
    IrreducedMixedFraction r = new IrreducedMixedFraction(2, 3, true);
    Operations.divide(l, r);
    l.setSign(false);
    r.setSign(false);
    Operations.divide(l, r);
    l.setSign(false);
    r.setSign(true);
    Operations.divide(l, r);
    l.setSign(true);
    r.setSign(false);
    Operations.divide(l, r);
  }
  
  @Test
  void exponent()
  {
    IrreducedMixedFraction f = new IrreducedMixedFraction(2, 5, false);
    IrreducedMixedFraction res = Operations.exponent(f, 2);
    assertEquals(4, res.getNumerator());
    assertEquals(25, res.getDenominator());
    res = Operations.exponent(f, -1);
    assertEquals(5, res.getNumerator());
    assertEquals(2, res.getDenominator());
    res = Operations.exponent(f, 3);
    assertEquals(8, res.getNumerator());
    assertEquals(125, res.getDenominator());
    f.setSign(true);
    res = Operations.exponent(f, 3);
    res.setNumerator(-8);
    assertEquals(-8, res.getNumerator());
    assertEquals(125, res.getDenominator());
  }
  
  @Test
  void mediant()
  {
    IrreducedMixedFraction l = new IrreducedMixedFraction(1, 2, true);
    IrreducedMixedFraction r = new IrreducedMixedFraction(1, 8, true);
    // T, T
    IrreducedMixedFraction res = Operations.mediant(l, r);
    assertEquals(2, res.getNumerator());
    assertEquals(10, res.getDenominator());
    // T, F
    r.setSign(false);
    res = Operations.mediant(l, r);
    assertEquals(0, res.getNumerator());
    assertEquals(10, res.getDenominator());
    // F, T
    l.setSign(false);
    r.setSign(true);
    res = Operations.mediant(l, r);
    assertEquals(0, res.getNumerator());
    assertEquals(10, res.getDenominator());
    // F, F
    l.setSign(false);
    r.setSign(false);
    res = Operations.mediant(l, r);
    assertEquals(2, res.getNumerator());
    assertEquals(10, res.getDenominator());
  }
}
