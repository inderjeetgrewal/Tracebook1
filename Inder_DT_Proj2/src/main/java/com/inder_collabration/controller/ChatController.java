package com.inder_collabration.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inder_collabration.model.Message;
import com.inder_collabration.model.OutputMessage;

@Controller
public class ChatController {

	  @RequestMapping(value="/user/viewChat", method = RequestMethod.GET)
	  public String viewChat() {
	    return "user/chat";
	  }
	    
	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }
}