package com.example.AISpringBoot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromptController {
    private final ChatClient chatClient;
    public PromptController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    @Autowired
    OpenAiChatModel chatModel;



    @GetMapping("/")
    public  String message(){
        var system= new SystemMessage("You are a Interviewer");
        var assistant= new AssistantMessage("Dependency Injection let Spring manage Object Wiring");
        var user = new UserMessage("Give me real Interview QUestion");
        var prompt = new Prompt(List.of(system,assistant,user));
        return chatModel.call(prompt).getResult().getOutput().getText();
        //return chatModel.call(new Prompt("Tell me about Spring AI use case in Interview")).getResult().getOutput().getText();
    }
}
