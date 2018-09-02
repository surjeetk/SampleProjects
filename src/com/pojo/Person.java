package com.pojo;

public class Person {
	private String fname;
	private String lname;
	private String addr;
	public String getFname() {
		return fname;
	}
	
	@Override
	public String toString() {
		return " Person [fname=" + fname + ", lname=" + lname + ", addr=" + addr
				+ "]";
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
