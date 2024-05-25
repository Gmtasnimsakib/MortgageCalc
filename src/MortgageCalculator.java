import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

public class MortgageCalculator {
    public static void main(String[] args) {
//        making it Constants because I don't want any magic numbers in this code
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
//        Making it in Bangladesh currency.
        final Locale locale = new Locale("bn", "BD");
        final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        Scanner sc = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = sc.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualInterest = sc.nextFloat();
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        System.out.print("Period (Years): ");
        byte years = sc.nextByte();
        int numberOfPayment = years * MONTHS_IN_YEAR;
        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayment)) / (Math.pow((1 + monthlyInterest), numberOfPayment) - 1);
        System.out.println("Mortgage: " + currencyFormatter.format(mortgage));
        sc.close();
    }
}