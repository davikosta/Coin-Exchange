package br.com.davikosta.url;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonConverter {
    HttpRequest httpRequest = new HttpRequest();

    JsonParser jp = new JsonParser();
    JsonElement root = jp.parse(new InputStreamReader((InputStream) httpRequest.getRequest().getContent()));
    JsonObject jsonobj = root.getAsJsonObject();

    private String query = "conversion_result";

    private String req_result = jsonobj.get(query).getAsString();

    public JsonConverter() throws IOException {
    }

    public String getReq_result() {
        return req_result;
    }
}
