package br.com.davikosta.menu;

public class ChoiceMenu {
    public void wellcomeMessage() {
        System.out.println("""
        Bem-vindo à minha aplicação de Exchange!
        Como funciona? 
        Você deve escolher que será convertida. Depois a moeda destino dessa conversão. Após isso insira o valor que será convertido.
        """);
    }
    public void ChooseFirstCurrency() {
        System.out.println("Por favor escolha a primeira moeda.");
    }
    public void CurrenciesMenu() {
        System.out.println("""
                1 - BRL (Brazilian Real)
                2 - USD (United States Dollar)
                3 - EUR (Euro)
                4 - JPY (Japanese Yen)
                5 - GBP (Pound Sterling)
                6 - CNY (Chinese Renminbi)
                """);
    }
}
