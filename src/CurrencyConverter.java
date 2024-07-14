import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("******************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda :)");
            System.out.println("\n1. Dólar============>> Peso Argentino");
            System.out.println("2. Peso Argentino===>> Dólar");
            System.out.println("3. Dólar============>> Real Brasileño");
            System.out.println("4. Real Brasileño===>> Dólar");
            System.out.println("5. Dólar============>> Peso Colombiano");
            System.out.println("6. Peso Colombiano==>> Dólar");
            System.out.println("7. Salir");
            System.out.print("Elija una opción válida: ");
            System.out.println("\n******************************************");

            int option = scanner.nextInt();
            if (option == 7) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.print("Ingrese la cantidad a cambiar: ");
            double amount = scanner.nextDouble();

            try {
                double result = 0;
                switch (option) {
                    case 1:
                        result = CurrencyConversion.convert("USD", "ARS", amount);
                        System.out.printf("Resultado: %.2f ARS\n", result);
                        break;
                    case 2:
                        result = CurrencyConversion.convert("ARS", "USD", amount);
                        System.out.printf("Resultado: %.2f USD\n", result);
                        break;
                    case 3:
                        result = CurrencyConversion.convert("USD", "BRL", amount);
                        System.out.printf("Resultado: %.2f BRL\n", result);
                        break;
                    case 4:
                        result = CurrencyConversion.convert("BRL", "USD", amount);
                        System.out.printf("Resultado: %.2f USD\n", result);
                        break;
                    case 5:
                        result = CurrencyConversion.convert("USD", "COP", amount);
                        System.out.printf("Resultado: %.2f COP\n", result);
                        break;
                    case 6:
                        result = CurrencyConversion.convert("COP", "USD", amount);
                        System.out.printf("Resultado: %.2f USD\n", result);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor intente de nuevo.");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error en la comunicación con la API de tasas de cambio.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
