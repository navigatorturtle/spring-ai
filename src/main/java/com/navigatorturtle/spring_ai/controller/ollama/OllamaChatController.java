package com.navigatorturtle.spring_ai.controller.ollama;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.model.ChatModel;

@RestController
public class OllamaChatController {

    private final ChatModel chatModel;

    public OllamaChatController(ChatModel chatModel){
        this.chatModel = chatModel;
    }


    @GetMapping("/ollama/")
    public String callChatModel(@RequestParam String prompt){
        String response=null;
        try {
            response = chatModel.call(prompt);
        } catch (Exception e) {
            response = e.getMessage();
            e.printStackTrace();
        }
        return response;
    }
}
