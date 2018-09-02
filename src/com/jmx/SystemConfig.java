package com.jmx;

public class SystemConfig implements SystemConfigMBean{

	public SystemConfig(int tHREAD_COUNT, String dEFAULT_SCHEMA) {
		super();
		THREAD_COUNT = tHREAD_COUNT;
		DEFAULT_SCHEMA = dEFAULT_SCHEMA;
	}

	private  int THREAD_COUNT;
	private  String DEFAULT_SCHEMA;
	
	@Override
	public void setThreadCount(int numThread) {
		this.THREAD_COUNT=numThread;
	}

	@Override
	public int getThreadCount() {
		return this.THREAD_COUNT;
	}

	@Override
	public void setDefaultSchema(String schema) {
		this.DEFAULT_SCHEMA=schema;
	}

	@Override
	public String getDefaultSchema() {
		return this.DEFAULT_SCHEMA;
	}

	@Override
	public String doConfig() {
		return "No of threads:"+this.THREAD_COUNT+" and schema:"+this.DEFAULT_SCHEMA;
		
	}

	
}
