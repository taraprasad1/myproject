package com.rest.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
private int mid;
private String messages;
private String desc;
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMessages() {
	return messages;
}
public void setMessages(String messages) {
	this.messages = messages;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public Message(int mid, String messages, String desc) {
	this.mid = mid;
	this.messages = messages;
	this.desc = desc;
}
public Message() {
	 
	// TODO Auto-generated constructor stub
}

}
