package com.test;

import java.util.List;

public class Node {

	private Node parent;
	private String itemid;
	private List<Node> childnodes;
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public List<Node> getChildnodes() {
		return childnodes;
	}
	public void setChildnodes(List<Node> childnodes) {
		this.childnodes = childnodes;
	}
	
	public void addChildNode(Node child){
		childnodes.add(child);
	}
	
}
