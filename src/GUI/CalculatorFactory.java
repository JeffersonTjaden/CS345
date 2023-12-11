package GUI;

import java.util.Locale;

public class CalculatorFactory {
    public static Integer count = 0;

    public static Calculator createCalculator(){
        Locale locale = Locale.getDefault();
        Calculator c = new Calculator(locale);
        count++;
        return c;
    }

    public static Calculator createCalculator(String arg1, String arg2){
        Locale locale = new Locale(arg1, arg2);
        Calculator c = new Calculator(locale);
        count++;
        return c;
    }
}
