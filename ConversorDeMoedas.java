import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMoedas {
    private static final String API_KEY = "0d5765c27d66f9eec484b4dc";
    private static final String API_ENDPOINT = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private HttpClient client;

    public ConversorDeMoedas() {
        client = HttpClient.newHttpClient();
    }

    public static void main(String[] args) {
        ConversorDeMoedas converter = new ConversorDeMoedas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        System.out.print("Insira a moeda de origem (por exemplo, EUR, USD, etc.): ");
        String fromCurrency = scanner.next();

        System.out.print("Insira a moeda de destino (por exemplo, EUR, USD, etc.): ");
        String toCurrency = scanner.next();

        converter.convert(amount, fromCurrency, toCurrency);
    }

    private void convert(double amount, String fromCurrency, String toCurrency) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_ENDPOINT + fromCurrency + "/" + toCurrency))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = parseJsonResponse(response.body());

            double conversionRate = getConversionRate(jsonObject);

            displayResults(amount, fromCurrency, toCurrency, conversionRate);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private JsonObject parseJsonResponse(String responseBody) {
        JsonParser parser = new JsonParser();
        return parser.parse(responseBody).getAsJsonObject();
    }

    private double getConversionRate(JsonObject jsonObject) {
        return jsonObject.get("conversion_rate").getAsDouble();
    }

    private void displayResults(double amount, String fromCurrency, String toCurrency, double conversionRate) {
        System.out.printf("Resultado da Conversão: %f %s = %f %s%n", amount, fromCurrency, amount * conversionRate, toCurrency);
    }
}