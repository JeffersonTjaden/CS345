import GUI.CalculatorFactory;

public class Driver {
    public static void main(String[] args){
        if(args.length == 2){
            CalculatorFactory.createCalculator(args[0], args[1]);
        } else{
            CalculatorFactory.createCalculator();
        }
    }
}
