package com.jmx;

public interface SystemConfigMBean {
	public void setThreadCount(int numThread);
	public int getThreadCount();
	
	public void setDefaultSchema(String schema);
	public String getDefaultSchema();
	
	public String doConfig();
	
}
