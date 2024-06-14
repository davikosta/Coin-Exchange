import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        //Definindo a API Key do usuário
        String apiKey = "f11641234a325052a06631fe";

        //Definindo primeira moeda
        String firstCurrency = "BRL";

        //Definindo segunda moeda
        String secondCurrency = "USD";

        //Definindo o endereço de requisição
        String pairAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + firstCurrency + "/" + secondCurrency + "/4";

        //Fazendo a requisição
        URL url = new URL(pairAddress);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        //Convertendo resposta para JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();



        String query = "conversion_result";

        String req_result = jsonobj.get(query).getAsString();


        System.out.println(req_result);
    }
}