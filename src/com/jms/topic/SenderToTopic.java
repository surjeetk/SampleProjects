package com.jms.topic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SenderToTopic {

	public static void main(String[] args) {

try{
			
			Hashtable hashTable = new Hashtable();
			hashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
			hashTable.put(Context.PROVIDER_URL, "iiop://localhost:3700");
			hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
			
			//  hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");
			//hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
			
		      //  hashTable.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		       // hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
			
			//create and start connection
			InitialContext ctxt = new InitialContext(hashTable);
			TopicConnectionFactory factory=(TopicConnectionFactory) ctxt.lookup("myTopicConnectionFactory");
			TopicConnection connection = factory.createTopicConnection();
			connection.start();
			
			
			//create Topic session
			TopicSession session=connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//get Topic object
			Topic t = (Topic) ctxt.lookup("myTopic");
			
			//create Topic sender object
			TopicPublisher pub = session.createPublisher(t);
			
			//create TextMessage object
			TextMessage mssg = session.createTextMessage();
			
			//write message
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				System.out.println("Enter message, end to terminate");
				String str = b.readLine();
				
				if("end".equalsIgnoreCase(str)){
					break;
				}
				
				mssg.setText(str);
				pub.publish(mssg);
				System.out.println("Message sent successfully!");
			}
			
			//close the connection
			connection.close();
		}catch(Exception e){
			System.out.println("Exception occurred:"+e.getMessage());
		}
	}

}
