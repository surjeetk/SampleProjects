package com.jms.topic;

import java.util.Hashtable;

import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ReceiverFromTopic1 {

	public static void main(String[] args) {

		try{
		     
			//create and start connection
			
			Hashtable hashTable = new Hashtable();
			
			hashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
			hashTable.put(Context.PROVIDER_URL, "iiop://localhost:3700");
			hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
			
			
			InitialContext ctxt = new InitialContext(hashTable);
			TopicConnectionFactory factory=(TopicConnectionFactory) ctxt.lookup("myTopicConnectionFactory");
			TopicConnection connection = factory.createTopicConnection();
			connection.start();
			
			System.out.println("Connection created");
			//create Topic session
			TopicSession session=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//get Topic object
			Topic t = (Topic) ctxt.lookup("myTopic");
			
			//create Topic receiver
			TopicSubscriber sub = session.createSubscriber(t);
			
			//Create listener object
			MyTopicMessageListener listener= new MyTopicMessageListener();
			
			//register listner object with the receiver
			sub.setMessageListener(listener);
			
			System.out.println("Receiver 1 is ready..waiting for messages...");
			System.out.println("press Ctrl+c to shutdown...");  
            while(true){                  
                Thread.sleep(1000);  
            }  
			
		}catch(Exception e){
			System.out.println("Exception occurred:"+e.getMessage());
		}

	}

}
