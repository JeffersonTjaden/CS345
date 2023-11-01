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
    IrreducedMixedFraction left4 = new IrreducedMixedFraction(-1, 3);
    IrreducedMixedFraction right4 = new IrreducedMixedFraction(2, 3);
    result = Operations.add(left4, right4);
    assertEquals(0, result.getWhole());
    // assertEquals(-1, result.getNumerator());
    assertEquals(3, result.getDenominator());
    
    // Both Negative
    
    
    // Denominator Zero
    
    
    // Result is Zero
    
    
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
    
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
    // Result is Zero
    
    
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
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
    // Result is Zero
    
    
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
    
    // One Fraction Zero
    
    
    // Both Fractions Zero
    
    
    // One Fraction Negative
    
    
    // Both Negative
    
    
    // Denominator Zero
    
    
  }
}
