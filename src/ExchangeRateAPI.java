import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/d9cc0ee568a990db6ff76750/latest/";

    public static ConversionRate getRates(String currency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + currency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        return gson.fromJson(jsonObject, ConversionRate.class);
    }
}
