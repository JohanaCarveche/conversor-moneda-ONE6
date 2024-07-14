import java.io.IOException;
import java.util.Map;

public class CurrencyConversion {
    public static double convert(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        ConversionRate rates = ExchangeRateAPI.getRates(fromCurrency);
        Map<String, Double> conversionRates = rates.getConversionRates();

        if (conversionRates.containsKey(toCurrency)) {
            return amount * conversionRates.get(toCurrency);
        } else {
            throw new IllegalArgumentException("Invalid target currency: " + toCurrency);
        }
    }
}
