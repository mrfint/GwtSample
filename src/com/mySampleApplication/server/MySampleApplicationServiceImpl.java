package com.mySampleApplication.server;

import com.mySampleApplication.shared.Message;
import com.mySampleApplication.shared.MySampleApplicationService;

import javax.ws.rs.QueryParam;

public class MySampleApplicationServiceImpl implements MySampleApplicationService {

	@Override
    public Message getMessage(String msg) {
        return new Message("Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"");
    }

	@Override
	public String getTest() {
		return "Test";
	}
}