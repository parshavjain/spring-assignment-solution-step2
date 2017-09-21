package com.stackroute.activitystream.test;
import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stackroute.activitystream.config.ApplicationContextConfig;
import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes= {ApplicationContextConfig.class})
public class ActivityStreamTest {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private Message message;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
		
		
	}
	
	@Test
	public void testGetListOfMessages() {
		
		List<Message> messages=messageDAO.getMessagesFromCircle();
		assertNotNull("Retrieval of messages failed.",messages);
	}
	
	@Test
	public void testSendMessages() {
		
		Message message=new Message();
		message.setSenderId("John");
		message.setMessage("Sample message");
		message.setPostedDate();
		
		messageDAO.sendMessageToCircle(message);
		
		List<Message> messages=messageDAO.getMessagesFromCircle();
		
		boolean found=false;
		for(Message msg:messages)
		{
			if(msg.getSenderId().equals("John") && msg.getMessage().equals("Sample message")) {
				found=true;
			}
		}
		
		assertEquals("Sending of messages failed",true,found);
		
		messageDAO.removeMessageToCircle(message);
		//sessionFactory.getCurrentSession().delete(message);
			
	}
	

}