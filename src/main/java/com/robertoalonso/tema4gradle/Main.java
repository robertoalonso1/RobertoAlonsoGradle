package com.robertoalonso.tema4gradle;

import dev.langchain4j.model.openai.OpenAiChatModel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final String TOKEN = "PEGA_AQUI_TU_TOKEN";

        var model = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey(TOKEN)
                .modelName("gemma:2b")
                .build();
        String respuesta = model.chat("Cuéntame un chiste");
        System.out.println(respuesta);
    }
}
