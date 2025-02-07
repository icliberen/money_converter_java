import java.util.Scanner;

public class MoneyConverter 
{

    // Conversion rates, you can change them
    private static final double USD_TO_EUR = 0.96;
    private static final double USD_TO_GBP = 0.80;
    private static final double USD_TO_TRY = 36.73;
    private static final double EUR_TO_USD = 1.04;
    private static final double EUR_TO_GBP = 0.84;
    private static final double EUR_TO_TRY = 37.27;
    private static final double GBP_TO_USD = 1.24;
    private static final double GBP_TO_EUR = 1.19;
    private static final double GBP_TO_TRY = 44.45;
    private static final double TRY_TO_USD = 0.028;
    private static final double TRY_TO_EUR = 0.027;
    private static final double TRY_TO_GBP = 0.022;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Money Converter");
        System.out.println("Supported currencies: USD, EUR, GBP, TRY");

        // Input: Source currency
        System.out.print("Enter the source currency (USD, EUR, GBP, TRY): ");
        String sourceCurrency = sc.nextLine().toUpperCase();

        // Input: Target currency
        System.out.print("Enter the target currency (USD, EUR, GBP, TRY): ");
        String targetCurrency = sc.nextLine().toUpperCase();

        // Validate currencies
        if (!isSupportedCurrency(sourceCurrency) || !isSupportedCurrency(targetCurrency)) 
        {
            System.out.println("Error: Unsupported currency entered. Please use USD, EUR, GBP, or TRY.");
            sc.close();
            return; // Exit the program
        }

        // Input: Amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = sc.nextDouble();

        // Perform the conversion
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        // Output the result
        if (convertedAmount >= 0) 
        {
            System.out.printf("%.2f %s = %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
        } 
        else 
        {
            System.out.println("Invalid currency conversion.");
        }
        sc.close();
    }
    /**
     * Checks if a currency is supported.
     *
     * @param currency The currency code to check.
     * @return true if the currency is supported, false otherwise.
     */
    public static boolean isSupportedCurrency(String currency) 
    {
        return currency.equals("USD") || currency.equals("EUR") || currency.equals("GBP") || currency.equals("TRY");
    }
    /**
     * Converts an amount from one currency to another.
     *
     * @param amount         The amount to convert.
     * @param sourceCurrency The source currency code (e.g., USD, EUR, GBP, TRY).
     * @param targetCurrency The target currency code (e.g., USD, EUR, GBP, TRY).
     * @return The converted amount, or -1 if the conversion is invalid.
     */
    public static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) 
    {
        if (sourceCurrency.equals(targetCurrency)) 
        {
            return amount; // No conversion needed
        }
        // For conversions from USD
        if (sourceCurrency.equals("USD")) 
        {
            if (targetCurrency.equals("EUR")) 
            {
                return amount * USD_TO_EUR;
            } 
            else if (targetCurrency.equals("GBP")) 
            {
                return amount * USD_TO_GBP;
            } 
            else if (targetCurrency.equals("TRY")) 
            {
                return amount * USD_TO_TRY;
            }
        }
        // For conversions from EUR
        else if (sourceCurrency.equals("EUR")) 
        {
            if (targetCurrency.equals("USD")) 
            {
                return amount * EUR_TO_USD;
            } 
            else if (targetCurrency.equals("GBP")) 
            {
                return amount * EUR_TO_GBP;
            } 
            else if (targetCurrency.equals("TRY")) 
            {
                return amount * EUR_TO_TRY;
            }
        }
        // For conversions from GBP
        else if (sourceCurrency.equals("GBP")) 
        {
            if (targetCurrency.equals("USD")) 
            {
                return amount * GBP_TO_USD;
            } 
            else if (targetCurrency.equals("EUR")) 
            {
                return amount * GBP_TO_EUR;
            } 
            else if (targetCurrency.equals("TRY")) 
            {
                return amount * GBP_TO_TRY;
            }
        }
        // For conversions from TRY
        else if (sourceCurrency.equals("TRY")) 
        {
            if (targetCurrency.equals("USD")) 
            {
                return amount * TRY_TO_USD;
            } 
            else if (targetCurrency.equals("EUR")) 
            {
                return amount * TRY_TO_EUR;
            } 
            else if (targetCurrency.equals("GBP")) 
            {
                return amount * TRY_TO_GBP;
            }
        }
        // If no coversion is valid
        return -1;
    }
}