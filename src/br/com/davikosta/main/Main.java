package br.com.davikosta.main;

import br.com.davikosta.exchange.Conversion;
import br.com.davikosta.message.Message;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Conversion conversion = new Conversion();
        Message message = new Message();

        message.showIntroductionMessage();

        // Obtém as moedas escolhidas pelo usuário
        conversion.getCurrenciesFromUser();

        // Obtém o valor a ser convertido
        conversion.getAmountFromUser();

        // Mostra o resultado da conversão
        conversion.showResult();
    }
}
