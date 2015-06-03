package com.web.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")

public class UserAction extends ActionSupport{
private String username;
private String password;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String execute()
{
	System.out.println(username+"        "+password);
	return SUCCESS;
}
public String login()
{
	System.out.println(username+"     11111111111   "+password);
	return SUCCESS;
}
@Override
	public void validate() {
		addFieldError("password", "error!!!!!!!!!");
	}
}
