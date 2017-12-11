package com.stackroute.activitystream.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
@Service
@Table(name = "MESSAGE")
public class Message {

	/**
	 * This class should have four fields (messageId,senderName,postedDate,message).
	 * Out of these four fields, the field messageId should be auto-generated. This
	 * class should also contain the getters and setters for the fields. The value
	 * of postedDate should not be accepted from the user but should be always
	 * initialized with the system date
	 */

	/**
	 * Auto-Generated. Used to store message Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "messageId", nullable = false)
	int messageId;

	/**
	 * Used to store senderName.
	 */
	@Column(name = "senderName", nullable = false)
	String sender;

	/**
	 * Used to store postedDate.
	 */
	@Column(name = "postedDate", nullable = false)
	Date postedDate;

	/**
	 * Used to store message.
	 */
	@Column(name = "MESSAGE", nullable = false)
	String message;

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(final int messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return sender;
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSenderName(final String sender) {
		this.sender = sender;
	}

	/**
	 * @return the senderName
	 */
	public String getSender() {
		return getSenderName();
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSender(final String sender) {
		setSenderName(sender);
	}

	/**
	 * @return the postedDate
	 */
	public Date getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate
	 *            the postedDate to set
	 */
	public void setPostedDate() {
		if (null == postedDate) {
			postedDate = new java.sql.Date(new java.util.Date().getTime());
		}
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

}
/*public class Message {

	public void setSenderName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPostedDate() {
		// TODO Auto-generated method stub
		
	}

	public Object getSenderName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	 * This class should have four fields
	 * (messageId,senderName,postedDate,message). Out of these four fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 
	
	

}*/
