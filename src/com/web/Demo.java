package com.web;

import java.util.Random;

public class Demo {
	

	public static void main(String[] args)
	{
		Demo demo=new Demo();
	}
public Demo()
{
	Initialize();
}
private void Initialize()
{
	User[] user=new User[5000];
	
	String namedataString="qwertyuiopasdfghjklzxcvbnm";
	
	for(int i=0;i<user.length;i++)		
	{	
		Random rm=new Random(System.currentTimeMillis());
		StringBuffer name=new StringBuffer();	
		user[i]=new User();		
		user[i].setAge(rm.nextInt(1000));
		for(int m=0;m<5;m++)
		{
			name.append(namedataString.charAt(rm.nextInt(namedataString.length())));
		}
		user[i].setName(name.toString());
		user[i].setId(i);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	for(int i=0;i<user.length;i++)
	{
		paixu(0,user);
	}
	for(User u:user)
		u.print();
	
}
public void paixu(int index,User[] user)
{
	if(index>=0&&index<=user.length-2)
	{
		User u1=user[index];
		User u2=user[index+1];
		if(u1.getAge()<u2.getAge())
		{
			user[index]=u2;
			user[index+1]=u1;
		}
		paixu(index+1,user);
	}
}

}

class User
{
private int age=0;
private String name="";
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User()
{}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void print()
{
	System.out.println("ID:"+id+" 用户名："+name+" 年龄："+age);
}
}

