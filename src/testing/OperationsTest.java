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
    IrreducedMixedFraction left = new IrreducedMixedFraction(734, 83);
    IrreducedMixedFraction right = new IrreducedMixedFraction(567, 43);
    IrreducedMixedFraction result = Operations.add(left, right);
    assertEquals(22, result.getWhole());
    assertEquals(105, result.getNumerator());
    assertEquals(83*43, result.getDenominator());
    
    // One Fraction Zero
    IrreducedMixedFraction left2 = new IrreducedMixedFraction(0, 2);
    IrreducedMixedFraction right2 = new IrreducedMixedFraction(1, 2);
    result = Operations.add(left2, right2);
    assertEquals(0, result.getWhole());
    assertEquals(1, result.getNumerator());
    assertEquals(2, result.getDenominator());
    // Both Fractions Zero
    IrreducedMixedFraction left3 = new IrreducedMixedFraction(0, 2);
    IrreducedMixedFraction right3 = new IrreducedMixedFraction(0, 3);
    result = Operations.add(left3, right3);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(6, result.getDenominator());
    
    // One Fraction Negative
    IrreducedMixedFraction left4 = new IrreducedMixedFraction(1, 3);
    IrreducedMixedFraction right4 = new IrreducedMixedFraction(2, 3);
    left4.changeSign();
    result = Operations.add(left4, right4);
    result.changeSign();
    assertEquals(0, result.getWhole());
    assertEquals(-1, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Both Negative
    IrreducedMixedFraction left5 = new IrreducedMixedFraction(1, 3);
    IrreducedMixedFraction right5 = new IrreducedMixedFraction(2, 3);
    left5.changeSign();
    right5.changeSign();
    result = Operations.add(left5, right5);
    result.changeSign();
    assertEquals(0, result.getWhole());
    assertEquals(3, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Result is Zero
    IrreducedMixedFraction left6 = new IrreducedMixedFraction(1, 3);
    IrreducedMixedFraction right6 = new IrreducedMixedFraction(1, 3);
    left6.changeSign();
    result = Operations.add(left6, right6);;
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(3, result.getDenominator());
  }
  
  /**
   * 
   */
  @Test
  public void testSubtract() 
  {
    IrreducedMixedFraction left = new IrreducedMixedFraction(345, 61, 893);
    IrreducedMixedFraction right = new IrreducedMixedFraction(23, 72, 442);
    IrreducedMixedFraction result = Operations.subtract(left, right);
    assertEquals(321, result.getWhole());
    assertEquals(357372, result.getNumerator());
    assertEquals(893*442, result.getDenominator());
    
    // First Fraction Zero
    left = new IrreducedMixedFraction(0, 5);
    right = new IrreducedMixedFraction(2, 5);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(-2, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Second Fraction Zero
    left = new IrreducedMixedFraction(2, 5);
    right = new IrreducedMixedFraction(0, 5);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(2, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Both Fractions Zero
    left = new IrreducedMixedFraction(0, 5);
    right = new IrreducedMixedFraction(0, 3);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(15, result.getDenominator());
    
    // First Fraction Negative
    left = new IrreducedMixedFraction(1, 5);
    left.changeSign();
    right = new IrreducedMixedFraction(2, 5);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(-3, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Second Fraction Negative
    left = new IrreducedMixedFraction(1, 5);
    right = new IrreducedMixedFraction(2, 5);
    right.changeSign();
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(3, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Both Negative
    left = new IrreducedMixedFraction(1, 5);
    right = new IrreducedMixedFraction(2, 5);
    left.changeSign();
    right.changeSign();
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(1, result.getNumerator());
    assertEquals(5, result.getDenominator());

    // Result is Zero
    left = new IrreducedMixedFraction(3, 5);
    right = new IrreducedMixedFraction(3, 5);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(5, result.getDenominator());
    
    // Result is Zero but with different fractions
    left = new IrreducedMixedFraction(3, 5);
    right = new IrreducedMixedFraction(15, 25);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(125, result.getDenominator());
    
    // Whole Number Test
    left = new IrreducedMixedFraction(1, 3, 5);
    right = new IrreducedMixedFraction(1, 15, 25);
    result = Operations.subtract(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(125, result.getDenominator());
  }
  
  /**
   * 
   */
  @Test
  public void testMultiply() 
  {
    // Simple Test
    IrreducedMixedFraction left = new IrreducedMixedFraction(12, 13, 44);
    IrreducedMixedFraction right = new IrreducedMixedFraction(23, 7, 18);
    IrreducedMixedFraction result = Operations.multiply(left, right);
    assertEquals(287, result.getWhole());
    assertEquals(457, result.getNumerator());
    assertEquals(792, result.getDenominator());
    
    // One Fraction Zero
    left = new IrreducedMixedFraction(2, 5);
    right = new IrreducedMixedFraction(0, 5);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(25, result.getDenominator());
    
    // Both Fractions Zero
    left = new IrreducedMixedFraction(0, 0, 5);
    right = new IrreducedMixedFraction(0, 0, 3);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(15, result.getDenominator());
    
    // One Fraction Negative
    left = new IrreducedMixedFraction(2, 5);
    left.changeSign();
    right = new IrreducedMixedFraction(3, 5);
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(-6, result.getNumerator());
    assertEquals(25, result.getDenominator());
    
    // Both Negative
    left = new IrreducedMixedFraction(2, 5);
    right = new IrreducedMixedFraction(3, 5);
    left.changeSign();
    right.changeSign();
    result = Operations.multiply(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(6, result.getNumerator());
    assertEquals(25, result.getDenominator());
  }
  
  /**
   * 
   */
  @Test
  public void testDivide() 
  {
    // Simple Test
    IrreducedMixedFraction left = new IrreducedMixedFraction(6, 7, 11);
    IrreducedMixedFraction right = new IrreducedMixedFraction(8, 3, 17);
    IrreducedMixedFraction result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(1241, result.getNumerator());
    assertEquals(1529, result.getDenominator());
    
    // First Fraction Zero
    left = new IrreducedMixedFraction(0, 3);
    right = new IrreducedMixedFraction(1, 9);
    result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Second Fraction Zero
    left = new IrreducedMixedFraction(2, 3);
    right = new IrreducedMixedFraction(0, 9);
    try
    {
      result = Operations.divide(left, right);
    }
    catch (IllegalArgumentException e)
    {
      // Expected.
    }
    
    // First Fraction Negative
    left = new IrreducedMixedFraction(2, 3);
    right = new IrreducedMixedFraction(1, 9);
    left.changeSign();
    result = Operations.divide(left, right);
    assertEquals(0, result.getWhole());
    assertEquals(-18, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Second Fraction Negative
    left = new IrreducedMixedFraction(2, 3);
    right = new IrreducedMixedFraction(1, 9);
    assertEquals(1, right.getNumerator());
    assertEquals(9, right.getDenominator());
    result = Operations.divide(left, right);
    result.changeSign();
    assertEquals(-6, result.getWhole());
    assertEquals(0, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Both Negative 
  }
  
  @Test
  void changeSign()
  {
    IrreducedMixedFraction f = new IrreducedMixedFraction(1, 2);
    f.changeSign();
    assertEquals(-1, f.getNumerator());
    Operations.changeSign(f);
  }
}
