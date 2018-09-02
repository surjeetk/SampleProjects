package com.jms.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyQueueListner implements MessageListener {

	@Override
	public void onMessage(Message mssg) {
		try {
			TextMessage txt = (TextMessage) mssg;
			System.out
					.println("Following message is received:" + txt.getText());
		} catch (Exception e) {
			System.out.println("Exception occurred:" + e.getMessage());
		}
	}

}
