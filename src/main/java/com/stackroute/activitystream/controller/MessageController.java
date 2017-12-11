package com.stackroute.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

/*
 * Annotate the class with @Controller annotation.@Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 */
@Controller
public class MessageController {

	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement two functionalities. They are as following:
	 * 
	 * 1. display the list of existing messages from the database. Each message
	 *    should contain senderName, message, and timestamp 
	 * 2. send a message which should contain the senderName, message, and timestamp.
	 * 
	 */
	
	/*
	 * Autowiring should be implemented for the MessageDAO and Message. Please note that we should
	 * not create any object using the new keyword
	 * */

	@Autowired
	@Qualifier("messageDAO")
	private MessageDAO messageDAO;
	
	@Autowired
	private Message message;
	
	
	/*
	 * Define a handler method to read the existing messages from the database and add it to
	 * the ModelMap which is an implementation of Map for use when building model data for use 
	 * with views. it should map to the default URL i.e. "/" 
	 * */
	@RequestMapping(value = "/")
	public String getAllMessages(final ModelMap modelMap) {
		final List<Message> messageList = messageDAO.getMessages();
		if (null != messageList && !messageList.isEmpty()) {
			modelMap.put("messages", messageList);
		}
		return "index";
	}
	
	
	
	
	/*Define a handler method which will read the senderName and message from request parameters and
	 * save the message in message table in database. Please note that the timestamp should always
	 * be auto populated with system time and should not be accepted from the user. Also, after 
	 * saving the message, it should show the same along with existing messages. Hence, reading 
	 * messages has to be done here again and the retrieved messages object should be sent back to the 
	 * view using ModelMap
	 * This handler method should map to the URL "/sendMessage". 
	*/
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(final Message message) {
		message.setPostedDate();
		if (null == message.getSenderName() || null == message.getMessage() || message.getSenderName().isEmpty()
				|| message.getMessage().isEmpty()) {
			return new ModelAndView("index");
		}

		messageDAO.sendMessage(message);
		return new ModelAndView("redirect:/");
	}
		

}
