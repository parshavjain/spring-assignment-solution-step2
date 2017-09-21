package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;

public interface MessageDAO {
		
		public List<Message> getMessagesFromCircle(); 
		public boolean sendMessageToCircle(Message message);
		public boolean removeMessageToCircle(Message message);
		 
		

}
