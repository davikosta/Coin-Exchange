package br.com.davikosta.exchange;

import br.com.davikosta.url.JsonConverter;

import java.io.IOException;

public class Conversion {
    /*private String amount =
    private String conversionResult() {
        public String setAmount(double amount) {
            return String.valueOf(amount);
        }*/

    public void showResult() throws IOException {
        JsonConverter jsonConverter = new JsonConverter();
        System.out.println("O resultado da conversão foi de " + jsonConverter.getReq_result() + //segunda moeda);
    }
    }
