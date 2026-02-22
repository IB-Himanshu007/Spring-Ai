package com.example.AISpringBoot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

@RequestMapping("/ai")
public class AiController {
	private ChatClient chatClient;
	
	public AiController(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}

	@RequestMapping("/genre")
	public String bestGenreCreators() {
	    return chatClient.prompt()
	            .user("What is SpringBoot AI ")
	            .call()
	            .content();
	}
	}
