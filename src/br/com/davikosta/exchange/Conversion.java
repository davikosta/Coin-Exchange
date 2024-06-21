package br.com.davikosta.exchange;

import br.com.davikosta.url.HttpRequest;
import br.com.davikosta.url.JsonConverter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Conversion {
    private Currencies currencies = new Currencies();
    private String amount;

    public void getCurrenciesFromUser() {
        Scanner scanner = new Scanner(System.in);
        int userInputs;
        int numberOfCurrenciesChosen = 0;

        do {
            showCurrenciesMenu();
            userInputs = scanner.nextInt();

            if (userInputs >= 1 && userInputs <= 6) {
                String currencyCode = convertUserInputToCurrencyCode(userInputs);
                setCurrencies(currencyCode, numberOfCurrenciesChosen);
                numberOfCurrenciesChosen++;
            } else if (userInputs != 7) {
                System.out.println("Por favor escolha uma opção válida!");
            }
        } while (userInputs != 7 && numberOfCurrenciesChosen < 2);
    }

    private void showCurrenciesMenu() {
        System.out.println("""
                1 - BRL (Real Brasileiro)
                2 - USD (Dólar Americano)
                3 - EUR (Euro)
                4 - JPY (Iene Japonês)
                5 - GBP (Libra Esterlina)
                6 - CNY (Renminbi Chinês)
                7 - Encerrar seleção de moedas
                """);
        System.out.println("Escolha uma opção:");
    }

    private String convertUserInputToCurrencyCode(int userInput) {
        switch (userInput) {
            case 1:
                return "BRL";
            case 2:
                return "USD";
            case 3:
                return "EUR";
            case 4:
                return "JPY";
            case 5:
                return "GBP";
            case 6:
                return "CNY";
            default:
                return null;
        }
    }

    private void setCurrencies(String currencyCode, int numberOfChosen) {
        if (numberOfChosen == 0) {
            currencies.setFirstCurrency(currencyCode);
            System.out.println("Agora escolha a segunda moeda!");
        } else {
            currencies.setSecondCurrency(currencyCode);
        }
    }

    public void getAmountFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o valor que deseja converter:");
        amount = scanner.nextLine();
    }

    public void showResult() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        JsonConverter jsonConverter = new JsonConverter(httpRequest.sendRequestAndGetResponse(currencies, amount));
        String conversionResult = jsonConverter.getConversionResult();

        // Formatação para duas casas decimais
        double formattedResult = Double.parseDouble(conversionResult);
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedString = df.format(formattedResult);

        System.out.println("O resultado da conversão foi de " + formattedString);
        System.out.println("Moeda destino: " + currencies.getSecondCurrency());
    }
}
