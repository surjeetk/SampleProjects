package com.jms.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SenderToQueue {

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
			QueueConnectionFactory factory=(QueueConnectionFactory) ctxt.lookup("myQueueConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			connection.start();
			
			
			//create queue session
			QueueSession session=connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//get queue object
			Queue t = (Queue) ctxt.lookup("myQueue");
			
			//create queue sender object
			QueueSender sender = session.createSender(t);
			
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
				sender.send(mssg);
				System.out.println("Message send successfully!");
			}
			
			//close the connection
			connection.close();
		}catch(Exception e){
			System.out.println("Exception occurred:"+e.getMessage());
		}
		
	}

}
