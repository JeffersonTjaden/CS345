package GUI.Display;

import javax.swing.*;

import utilities.IrreducedMixedFraction;


/**
 * The Display class is for displaying the operand being inputted, the partial current expression, and the evaluated current expression.
 * The abstract methods are all for styling purposes.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Sean Halloran
 * @version 11/28/2023
 */
public abstract class Display extends JPanel {

    protected String whole;
    protected String numerator;
    protected String denominator;
    protected String signText;
    protected boolean signBool;
    
    protected int currentPosition;

    //Getter and Setter Methods

    /**
     * Displays an error message.
     * 
     * @param errorMessage The error message to display
     */
    public abstract void setErrorMessage(String errorMessage);

    /**
     * Displays the partial current expression.
     * 
     * In slash style, the expression should look something like '1 1/2 +'     
     *  
     * @param left The left operand of the current expression
     * @param operation The operation of the current expression
     */
    public abstract void setPartialExpression(IrreducedMixedFraction left, String operation);

    /**
     * Displays the evaluated current expression.
     * 
     * In slash style, the expression should look something like '1 1/2 + 3 1/5 = 4 7/10'
     * 
     * @param right The right operand of the current expression
     * @param result The result of the current expression
     */
    public abstract void setEvaluatedExpression(IrreducedMixedFraction right, IrreducedMixedFraction result);

    /**
     * A getter method for the IrreducedMixedFraction inputted as the current operand.
     * 
     * @return The IrreducedMixedFraction inputted as the current operand
     */
    public IrreducedMixedFraction getFraction() {
        IrreducedMixedFraction fraction = new IrreducedMixedFraction(parseWhole(), parseNumerator(), parseDenominator(), signBool);
        return fraction;
    }

    /**
     * Takes an IrreducedMixedFraction as a parameter and sets the current operand equal to it
     * 
     * @param operand The IrreducedMixedFraction to set the current operand equal to
     */
    public void setOperand(IrreducedMixedFraction operand) {
      whole = String.valueOf(operand.getWhole());
      numerator = String.valueOf(operand.getNumerator());
      denominator = String.valueOf(operand.getDenominator());
      signBool = operand.getSign();
      if (signBool) {
          signText = "";
      } else {
          signText = "-";
      }
      updateOperand();
  }

    //Helper Methods
    
    /**
     * Sets the focus indicator to the correct position (whole, numerator, or denominator) 
     * and updates the current operand with any input provided by the user.
     */
    protected abstract void updateOperand();

    /**
     * Clears the current expression.
     */
    protected abstract void clearExpression();

    /**
     * Clears the current operand.
     */
    protected void clearOperand() {
      whole = "_";
      numerator = "_";
      denominator = "_";
      signText = "";
      signBool = true;
      currentPosition = 0;
      updateOperand();
  }    

    /**
     * Converts the current whole number of the current operand to an integer.
     * 
     * @return The current whole number as an integer
     */
    private int parseWhole() {
        int whole;
        if (!this.whole.equals("_")) 
        {
          whole = Integer.parseInt(this.whole);
        } else 
        {
          whole = 0;
        }
        return whole;
      }
      
      /**
       * Converts the current numerator of the current operand to an integer.
       * 
       * @return The current numerator as an integer
       */
      private int parseNumerator() {
        int numerator;
        if (!this.numerator.equals("_"))
        {
          numerator = Integer.parseInt(this.numerator);
        } else 
        {
          numerator = 0;
        }
        return numerator;
      }
    
      /**
       * Converts the current denominator of the current operand to an integer.
       * 
       * @return The current denominator as an integer
       */
      private int parseDenominator() {
        int denominator;
        if (!this.denominator.equals("_"))
        {
          denominator = Integer.parseInt(this.denominator); 
        } else 
        {
          denominator = 1;
        }
        return denominator;
      }

    //Action Listeners
    
    /**
     * Appends the specified digit to the correct position when a user clicks a number button (whole, numerator, or denominator).
     * 
     * @param number The digit to append
     */
    public void numberButtons(int number){
        if (currentPosition % 3 == 0) {
          if (whole.equals("_")){
            whole = "" + number;
          } else {
          whole += number;
        }
        } else if (currentPosition % 3 == 1) {
          if (numerator.equals("_")){
            numerator = "" + number;
          } else{
          numerator += number;}
        } else {
          if (denominator.equals("_")){
            denominator = "" + number;
          } else {
          denominator += number;}
        }
        updateOperand();
      }
    
    /**
     * Clears the current operand when a user clicks the clear button.
     */
    public void clearButton() {
        clearOperand();
      }

      /**
       * Changes the sign of the current operand when a user clicks the sign button.
       */
      public void signButton() {
        if (signText.length() == 0){
            signText = "-";
            signBool = false;
          } else {
            signText = "";
            signBool = true;
          }
          updateOperand();
      } 
    
    /**
     * Clears the current expression and the current operand when a user clicks the reset button.
     */
    public void resetButton() {
        clearExpression();
        clearOperand();
      }

      /**
       * Changes the current position when a user clicks the position button (whole to numerator to denominator and then back to whole).
       */
      public void positionButton() {
        currentPosition++;
        updateOperand();
      }
    
    /**
     * Deletes the last digit of the current position when a user clicks the backspace button (whole, numerator, denominator).
     * Does nothing if there are no digits to delete.
     */
    public void backspaceButton() {
        if (currentPosition % 3 == 0) { // Focus is on 'whole'
          if (!whole.equals("_") && whole.length() > 1) {
              whole = whole.substring(0, whole.length() - 1);
          }
          else if (!whole.equals("_") && whole.length() == 1) {
            whole = "_";
          }
          else if (whole.equals("_")) {
            currentPosition = 2;
          }
      } else if (currentPosition % 3 == 1) { // Focus is on 'numerator'
          if (!numerator.equals("_") && numerator.length() > 1) {
              numerator = numerator.substring(0, numerator.length() - 1);
          }
          else if (!numerator.equals("_") && numerator.length() == 1) {
            numerator = "_";
          }
          else if (numerator.equals("_")) {
            currentPosition = 0;
          }
      } else { // Focus is on 'denominator'
          if (!denominator.equals("_") && denominator.length() > 1) {
              denominator = denominator.substring(0, denominator.length() - 1);
          } 
          else if (!denominator.equals("_") && denominator.length() == 1) {
            denominator = "_";
          }
          else if (denominator.equals("_")) {
            currentPosition = 1;
          }
      }
      updateOperand();
      }
}