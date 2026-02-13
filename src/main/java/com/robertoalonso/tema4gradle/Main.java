package com.robertoalonso.tema4gradle;

import dev.langchain4j.data.message.*;
import dev.langchain4j.model.openai.OpenAiChatModel;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // IA 1 (pregunta)
        var ia1 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("dummy")
                .modelName("gemma:2b")
                .build();

        // IA 2 (respuesta)
        var ia2 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("dummy")
                .modelName("gemma:2b")
                .build();

        List<ChatMessage> history1 = new ArrayList<>();
        history1.add(new SystemMessage("Eres una IA curiosa que hace preguntas sobre el valor el oro en la economia."));

        history1.add(new UserMessage("Haz una pregunta."));
        AiMessage pregunta = ia1.chat(history1).aiMessage();

        System.out.println("Pregunta de la IA 1");
        System.out.println(pregunta.text());

        // Historial IA 2
        List<ChatMessage> history2 = new ArrayList<>();
        history2.add(new SystemMessage("Eres una IA experta en economia, sobre todo del oro"));

        history2.add(new UserMessage(pregunta.text()));
        AiMessage respuesta = ia2.chat(history2).aiMessage();

        System.out.println("\nRespuesta de la IA 2:");
        System.out.println(respuesta.text());
    }
}
