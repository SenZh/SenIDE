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
		Map<String, Object> Applation=ActionContext.getContext().getApplication();//璇诲彇鍜屼繚瀛樻垚鍔�
		Map<String, Object> Session=ActionContext.getContext().getSession();//璇诲彇淇濆瓨鎴愬姛
		Map<String, Object> para=ActionContext.getContext().getParameters();
		Map<String, Object> request=(Map<String, Object>)ActionContext.getContext().get("request");
		
		Applation.put("ApplationKey", "value");
		Session.put("SessionKey", "value");
		para.put("paraKey", "value");
		request.put("requestKey", "value");
	//	System.out.println(request.get("username"));
	//	System.out.println(request.get("age"));
		System.out.println(request.get("requesttest"));//璇诲彇澶辫触锛屼及璁equestMap鏄痳equestParameter鐨刴ap锛岃�涓嶆槸Attribute鐨刴ap
	//	System.out.println(Session.get("session"));//璇诲彇鎴愬姛
	//	System.out.println(Applation.get("test"));//璇诲彇鎴愬姛
	//	System.out.println(((String[])para.get("username"))[0]);
		return "success";
	}
	public String add()
	{
		return "success";
	}

}
