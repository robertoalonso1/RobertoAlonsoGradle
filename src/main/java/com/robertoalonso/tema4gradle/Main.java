package com.robertoalonso.tema4gradle;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // El TOKEN no es necesario para interactuar con modelos locales
        var model = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("dummy")
                .modelName("gemma:2b")
                .build();

        List<ChatMessage> history = new ArrayList<>();

        // Primera interacción
        history.add(new UserMessage("Hola, soy Roberto"));
        AiMessage respuesta = model.chat(history).aiMessage();
        history.add(respuesta);

        // Segunda interacción
        history.add(new UserMessage("¿Te acuerdas de como me llamo?"));
        respuesta = model.chat(history).aiMessage();
        history.add(respuesta);

        System.out.println(respuesta.text());
    }

}
