package com.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;


public class contextDemo {
	private String username;
    private int age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@SuppressWarnings("unchecked")
	public String execute()
	{
		Map<String, Object> Applation=ActionContext.getContext().getApplication();//读取和保存成功
		Map<String, Object> Session=ActionContext.getContext().getSession();//读取保存成功
		Map<String, Object> para=ActionContext.getContext().getParameters();
		Map<String, Object> request=(Map<String, Object>)ActionContext.getContext().get("request");
		
		Applation.put("ApplationKey", "value");
		Session.put("SessionKey", "value");
		para.put("paraKey", "value");
		request.put("requestKey", "value");
	//	System.out.println(request.get("username"));
	//	System.out.println(request.get("age"));
		System.out.println(request.get("requesttest"));//读取失败，估计requestMap是requestParameter的map，而不是Attribute的map
	//	System.out.println(Session.get("session"));//读取成功
	//	System.out.println(Applation.get("test"));//读取成功
	//	System.out.println(((String[])para.get("username"))[0]);
		return "success";
	}

}
