package br.com.davikosta.url;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonConverter {
    private JsonObject jsonObject;

    public JsonConverter(InputStream inputStream) throws IOException {
        JsonParser jsonParser = new JsonParser();
        JsonElement root = jsonParser.parse(new InputStreamReader(inputStream));
        this.jsonObject = root.getAsJsonObject();
    }

    public String getConversionResult() {
        return jsonObject.get("conversion_result").getAsString();
    }
}
