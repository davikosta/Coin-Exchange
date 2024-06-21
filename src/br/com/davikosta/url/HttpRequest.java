package br.com.davikosta.url;

import br.com.davikosta.exchange.Currencies;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    private static final UserApiKey apiKey = new UserApiKey();

    public static String getPairAddress(Currencies currencies, String amount) {
        return "https://v6.exchangerate-api.com/v6/" + apiKey.getApiKey() + "/pair/" + currencies.getFirstCurrency() + "/" + currencies.getSecondCurrency() + "/" + amount;
    }

    public InputStream sendRequestAndGetResponse(Currencies currencies, String amount) throws IOException {
        String pairAddress = getPairAddress(currencies, amount);
        URL url = new URL(pairAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return connection.getInputStream();
        } else {
            throw new IOException("Erro ao fazer a requisição HTTP: " + responseCode);
        }
    }
}
