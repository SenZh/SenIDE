package com.web.util;

public class ThreadTest extends Thread{
private boolean run=true;
	public static void main(String[] args) throws InterruptedException {
		ThreadTest tt=new ThreadTest();
//		tt.run();
		tt.start();
		Thread.sleep(5000);
		tt.setRun(false);
	}
	public void run()
	{
		while(true)
		{
		while(run)
		{
		System.out.println("running......");
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		}
	}
	public boolean isRun() {
		return run;
	}
	public void setRun(boolean run) {
		this.run = run;
	}
	

}
