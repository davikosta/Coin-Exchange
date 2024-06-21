package br.com.davikosta.message;

public class Message {
    private final String welcomeMessage = """
            Olá! Bem vindo ao meu aplicativo de conversão de moedas!
            
            - Como funciona?
            
            Você deve escolher a primeira moeda na lista na opções. Logo após a segunda. Por fim você deve inserir o valor que será convertido.
            E tcharam! O resultado será exibido na sua tela baseado nas cotações das moedas em tempo real.
            """;

    public void showIntroductionMessage() {
        System.out.println(welcomeMessage);
    }
}
