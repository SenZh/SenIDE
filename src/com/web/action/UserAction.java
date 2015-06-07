package com.web.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.web.model.User;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute()
	{
		System.out.println(user.getUsername());
		return SUCCESS;
	}
	
	

}
