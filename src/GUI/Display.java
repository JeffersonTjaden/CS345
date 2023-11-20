package GUI;

import javax.swing.*;

import utilities.IrreducedMixedFraction;

public abstract class Display extends JPanel {

    protected String whole;
    protected String numerator;
    protected String denominator;
    protected String signText;
    protected boolean signBool;
    
    protected int currentPosition;

    //Getter and Setter Methods

    public IrreducedMixedFraction getFraction() {
        IrreducedMixedFraction fraction = new IrreducedMixedFraction(parseWhole(), parseNumerator(), parseDenominator(), signBool);
        return fraction;
    }

    public abstract void setExpression(String errorMessage);

    public abstract void setPartialExpression(IrreducedMixedFraction left, String operation);

    public abstract void setEvaluatedExpression(IrreducedMixedFraction right, IrreducedMixedFraction result);

    public abstract void setOperand(IrreducedMixedFraction operand);

    //Helper Methods
    
    protected abstract void updateOperand();

    protected abstract void clearOperand();

    protected abstract void clearExpression();

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

    public void clearButton() {
        clearOperand();
      }

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

    public void resetButton() {
        clearExpression();
        clearOperand();
        currentPosition = 0;
      }

      public void positionButton() {
        currentPosition++;
        updateOperand();
      }

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