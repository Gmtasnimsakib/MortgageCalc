import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        int principal;
        float annualInterest;
        byte years;

        principal = (int) readNumber("Principal (1K - 1M): ", 1_000, 1_000_000);
        annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = mortgageCalculator(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String promt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(promt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value greater than " + min + " and less than or equal to " + max + ".");
        }
        return value;
    }

    public static double mortgageCalculator(int principal,
                                            float annualInterest,
                                            byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayment = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayment))
                / (Math.pow((1 + monthlyInterest), numberOfPayment) - 1);
        return mortgage;
    }
}