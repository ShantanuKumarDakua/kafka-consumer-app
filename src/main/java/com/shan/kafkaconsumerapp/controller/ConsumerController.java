package com.shan.kafkaconsumerapp.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsumerController {
    ArrayList<String> messages = new ArrayList();
    @GetMapping("/consumeFromTopic")
    public List<String> getMessageFromTopic(){
        return messages;
    }
    @KafkaListener(groupId = "enggadda-1", topics = "topic1", containerFactory = "concurrentKafkaListenerContainerFactory")
    public List<String> consumeFromTopic(String data){
        messages.add(data);
        return messages;
    }
}
