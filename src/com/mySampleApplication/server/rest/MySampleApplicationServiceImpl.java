package com.mySampleApplication.server.rest;

import com.mySampleApplication.shared.MySampleApplicationService;

import javax.ws.rs.QueryParam;

public class MySampleApplicationServiceImpl implements MySampleApplicationService {

	@Override
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

	@Override
	public String getTest() {
		return "Test";
	}
}