import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int principal;
        float annualInterest;
        byte years;

        while (true) {
            System.out.print("Principal (1K - 1M): ");
            principal = sc.nextInt();
            if (principal >= 1_000 && 1_000_000 >= principal)
                break;
            System.out.println("Enter a number between 10,000 to 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = sc.nextFloat();
            if (annualInterest >= 1 && 30 >= annualInterest)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = sc.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }
        double mortgage = mortgageCalculator(principal, annualInterest, years);

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
        sc.close();
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