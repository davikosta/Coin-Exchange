package br.com.davikosta.url;

import br.com.davikosta.exchange.Conversion;
import br.com.davikosta.exchange.Currencies;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequest {
    private static Conversion conversion = new Conversion();
    private static final UserApiKey apiKey = new UserApiKey();
    private static Currencies currencies = new Currencies();
    private static String pairAddress = "https://v6.exchangerate-api.com/v6/" + apiKey.getApiKey() + "/pair/" + currencies.getFirstCurrency() + "/" + currencies.getSecondCurrency() + //valor a ser convertido;

    public static String getPairAddress() {
        return pairAddress;
    }
    public URLConnection getRequest() throws IOException {

        URL url = new URL(HttpRequest.getPairAddress());
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        return request;
    }
}
