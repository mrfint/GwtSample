package com.mySampleApplication.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Message {
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
