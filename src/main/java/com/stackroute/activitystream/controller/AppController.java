package com.stackroute.activitystream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

@Controller
public class AppController {

	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private Message message;


	@RequestMapping("/")
	public String index(ModelMap model) {
		System.out.println(messageDAO.getMessagesFromCircle());
		model.addAttribute("messages", messageDAO.getMessagesFromCircle());
		return "index";
	}
	
	@RequestMapping("/sendMessage")
	public String sendMessage(@RequestParam("sender") String sender,@RequestParam("message") String messageContent, ModelMap model) {
		
		message.setSenderId(sender);
		message.setMessage(messageContent);
		
		messageDAO.sendMessageToCircle(message);
		System.out.println(messageDAO.getMessagesFromCircle());
		model.addAttribute("messages", messageDAO.getMessagesFromCircle());
		return "redirect:/";
	}
		

}
