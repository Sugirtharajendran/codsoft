import java.util.Scanner;
import java.io.IOException;


public class currency{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Currency Converter (Task 4) ---");

        try {
           
            System.out.print("Enter the Base Currency (e.g., USD, EUR, INR): ");
            String baseCurrency = scanner.nextLine().toUpperCase();
            
            System.out.print("Enter the Target Currency (e.g., JPY, GBP, AUD): ");
            String targetCurrency = scanner.nextLine().toUpperCase();
            
           
            System.out.print("Enter the Amount to convert: ");
            double amountToConvert = scanner.nextDouble();
            
            
            double exchangeRate = getRealTimeExchangeRate(baseCurrency, targetCurrency);
            
            if (exchangeRate == 0) {
                System.err.println("Error: Could not fetch a valid exchange rate for the given currencies.");
                return;
            }

            
            double convertedAmount = amountToConvert * exchangeRate;
            
           
            System.out.println("\n--- CONVERSION RESULT ---");
            System.out.printf("Base Currency: %s\n", baseCurrency);
            System.out.printf("Target Currency: %s\n", targetCurrency);
            System.out.printf("Exchange Rate (%s to %s): %.4f\n", baseCurrency, targetCurrency, exchangeRate);
            System.out.printf("%.2f %s is equal to %.2f %s\n", 
                                amountToConvert, 
                                baseCurrency, 
                                convertedAmount, 
                                targetCurrency);
            System.out.println("-------------------------");

        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid number for the amount.");
        } catch (IOException e) {
            System.err.println("An error occurred while fetching exchange rates: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * SIMULATES fetching the real-time exchange rate from an API.
     * In a real application, this method would contain the logic to 
     * call a service like ExchangeRateAPI.
     * * @param base The base currency code (e.g., "USD").
     * @param target The target currency code (e.g., "EUR").
     * @return The exchange rate (1 base unit = X target units).
     */
    public static double getRealTimeExchangeRate(String base, String target) throws IOException {
        // Hardcoded rates for demo. Replace this with real API call logic.
        // To run this code without external dependencies, we use dummy data.
        
        if (base.equals("USD") && target.equals("EUR")) {
            return 0.93; // 1 USD = 0.93 EUR
        } else if (base.equals("USD") && target.equals("INR")) {
            return 83.50; // 1 USD = 83.50 INR
        } else if (base.equals("EUR") && target.equals("USD")) {
            return 1.08; // 1 EUR = 1.08 USD
        } else if (base.equals("INR") && target.equals("USD")) {
            return 0.012; // 1 INR = 0.012 USD
        } else if (base.equals(target)) {
            return 1.0; // Same currency
        }
        
        // Return 0 if the currency pair is not supported in this simulation
        // The main method will catch this and print an error.
        return 0; 
    }
}