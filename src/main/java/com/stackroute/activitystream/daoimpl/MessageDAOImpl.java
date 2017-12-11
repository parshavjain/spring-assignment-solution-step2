package com.stackroute.activitystream.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

/*
 * This class is implementing the MessageDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory. 
	 */
	 @Autowired
	 private SessionFactory sessionFactory;

	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	/*
	 * retrieve all existing messages sorted by posted Date in descending
	 * order(showing latest message first)
	 */
	@Override
	public List<Message> getMessages() {
		List<Message> list = sessionFactory.getCurrentSession().createQuery("from Message order by senderName").list();
		return list;
	}


	/*
	 * Save the message in the database in message table 
	 */
	@Override
	public boolean sendMessage(Message message) {
		if (null != message && null != sessionFactory && null != message.getSenderName() && null != message.getMessage()
				&& !message.getSenderName().isEmpty() && !message.getMessage().isEmpty()) {
			sessionFactory.getCurrentSession().saveOrUpdate(message);
			return true;
		}
		return false;
	}
	
	/*
	 * Remove the message from the database in message table. Please note that this
	 * method is not required for implementing the functionality but is required for passing
	 * the test cases
	 */

	@Override
	public boolean removeMessage(Message message) {
		sessionFactory.getCurrentSession().delete(message);
		return true;
	}

	

}
