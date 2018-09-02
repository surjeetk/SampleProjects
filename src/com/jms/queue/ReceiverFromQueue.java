package com.jms.queue;

import java.util.Hashtable;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ReceiverFromQueue {

	public static void main(String[] args) {
		try{
		     
			//create and start connection
			
			Hashtable hashTable = new Hashtable();
			
			hashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
			hashTable.put(Context.PROVIDER_URL, "iiop://localhost:3700");
			hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
			
			
			InitialContext ctxt = new InitialContext(hashTable);
			QueueConnectionFactory factory=(QueueConnectionFactory) ctxt.lookup("myQueueConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			connection.start();
			
			System.out.println("Connection created");
			//create queue session
			QueueSession session=connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//get queue object
			Queue t = (Queue) ctxt.lookup("myQueue");
			
			//create queue receiver
			QueueReceiver receiver = session.createReceiver(t);
			
			//Create listener object
			MyQueueListner listener= new MyQueueListner();
			
			//register listner object with the receiver
			receiver.setMessageListener(listener);
			
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
