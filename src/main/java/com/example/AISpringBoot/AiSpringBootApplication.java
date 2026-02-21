package com.example.AISpringBoot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class AiSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AiSpringBootApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
	    return args -> {
	        ChatClient chatClient = builder.build();
	        String response = chatClient.prompt("Tell me a joke").call().content();							
	        System.out.println(response);
	    };
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
