import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

public class MortgageCalculator {
    public static void main(String[] args) {
//        making it Constants because I don't want any magic numbers in this code
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
//       Setting Ranges
        final int PRINCIPAL_MIN_RANGE = 10_000;
        final int PRINCIPAL_MAX_RANGE = 1_000_000;

        final float MIN_INTEREST_PERCENT = 1;
        final float MAX_INTEREST_PERCENT = 30;

        final byte MIN_TIME_OF_PAYMENT = 1;
        final byte MAX_TIME_OF_PAYMENT = 30;

//        Making it in Bangladesh currency.
        final Locale locale = new Locale("bn", "BD");
        final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        Scanner sc = new Scanner(System.in);
//        int principal;

        int principal;
        float annualInterest;
        float monthlyInterest;
        int numberOfPayment;
        byte years;

        while (true) {
            System.out.print("Principal (৳10K - ৳1M): ");
            principal = sc.nextInt();
            if (principal >= PRINCIPAL_MIN_RANGE && PRINCIPAL_MAX_RANGE >= principal)
                break;
            System.out.println("Enter a number between 10,000 to 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = sc.nextFloat();
            if (annualInterest >= MIN_INTEREST_PERCENT && MAX_INTEREST_PERCENT >= annualInterest) {
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = sc.nextByte();
            if (years >= MIN_TIME_OF_PAYMENT && years <= MAX_TIME_OF_PAYMENT) {
                numberOfPayment = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayment)) / (Math.pow((1 + monthlyInterest), numberOfPayment) - 1);
        System.out.println("Mortgage: " + currencyFormatter.format(mortgage));
        sc.close();
    }
}