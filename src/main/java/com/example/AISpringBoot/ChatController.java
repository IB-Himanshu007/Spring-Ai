package com.example.AISpringBoot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	/*
	 * private ChatClient chatClient;
	 * 
	 * public ChatController(ChatClient.Builder chatClientBuilder) {
	 * this.chatClient= chatClientBuilder.build(); }
	 */
	@Autowired
	private OpenAiChatModel chatModel;
	
	@GetMapping("/jokes")
	public String generate(@RequestParam(value="message",defaultValue = "Tell me a Joke non veg") String message) {
		return chatModel.call(message);
		
	}
}
