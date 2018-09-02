package com.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class SystemConfigManagement {

	public static int THREAD_COUNT=10;
	public static String DEFAULT_SCHEMA="default";
	
	public static void main(String args[]) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException{
	
		SystemConfig mBean = new SystemConfig(THREAD_COUNT,DEFAULT_SCHEMA);
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.jmx1:type=basic,name=SystemConfig1");
		mbs.registerMBean(mBean, name);
		do{
			Thread.sleep(3000);
			System.out.println("Thread count:"+mBean.getThreadCount()+" and Schema Name:"+mBean.getDefaultSchema());
		}while(mBean.getThreadCount()!=0);
	}
}
