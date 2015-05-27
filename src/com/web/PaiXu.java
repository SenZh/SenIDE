package com.web;

import java.util.Random;

public class PaiXu{
	
	int[] data;
	public static void main(String[] args) {
		
		PaiXu charu=new PaiXu(100000);
	//	charu.xierpx(2);
	//	charu.paixu();
	//	charu.px2fen();
		charu.simpleChoiceSort();
	//	charu.print();
	}
	public PaiXu(int num)
	{
		Initialied(num);
	}
	
	public PaiXu()
	{
		Initialied(100);
	}
	public void Initialied(int num)
	{
		data=new int[num];	
		Random rm=new Random(System.currentTimeMillis());
		for(int i=0;i<data.length;i++)		
		{	
			data[i]=rm.nextInt(101);
		
		
		}
		
		
	}
	
	public void paixu()
	{
		long a=System.currentTimeMillis();
		for(int i=1;i<data.length;i++)
		{
			int dq=data[i];
			int j;
			for(j=i;j-1>=0;j--)
			{
				if(data[j-1]<dq)
				{
					data[j]=data[j-1];
				}
				else
					break;
			}
			data[j]=dq;
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
	public void px2fen()
	{
		long a=System.currentTimeMillis();
		for(int i=1;i<data.length;i++)
		{
			int begin=0;
			int end=i-1;
			int dq=data[i];
			if(dq<=data[end])
			{
				continue;
			}
			else if(dq>data[begin])
			{
				for(int j=i;j>begin;j--)
				{
					data[j]=data[j-1];
				}
				data[begin]=dq;
			}
			else
			{
				int index=fen2(begin,end,dq);
				for(int j=i;j>index;j--)
				{
					data[j]=data[j-1];
				}
				data[index]=dq;
			}
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
	
	public int fen2(int begin,int end,int dq)
	{
		
	if(end-begin>1)
	{
		if(data[(end+begin)/2]>dq)
		{
			return fen2((end+begin)/2,end,dq);
		}
		else if(data[(end+begin)/2]<dq)
		{
			
			return fen2(begin,(begin+end)/2,dq);
		}
		else {
			
			return (begin+end)/2;
		}
		
	}
	else if(end-begin==1)
	{
		return end;
	}
	else
	{
		if(data[begin]>dq)
		{
			return begin+1;
		}
		else
			return begin;
	}
	
		
	}
	
	public void mypx()
	{
		long a=System.currentTimeMillis();
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data.length-1;j++)
			{
				int temp=data[j];
				if(data[j]<data[j+1])
				{
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
	
	public void xierpx(int step)
	{
		int d=data.length/step;
		long a=System.currentTimeMillis();
		while(d>0)
		{
			int index=0;
			for(int i=1;index+i*d<data.length;i++)
			{
				int dq=data[index+i*d];
				int j;
				for(j=i-1;j>=0;j--)
				{
					if(dq>data[index+j*d])
					{
						data[index+(j+1)*d]=data[index+j*d];
					}
					else {
						break;
					}
				}
				data[index+(j+1)*d]=dq;
				
			}
			if(d<step)
				d=d/2;
			else
			d=d/step;
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
	public void simpleChoiceSort()
	{
		long a=System.currentTimeMillis();
		for(int i=0;i<data.length;i++)
		{
			int index=i;
			int temp=data[i];
			for(int j=i+1;j<data.length;j++)
			{
				if(data[index]<data[j])
				{
					index=j;
				}
			}
			data[i]=data[index];
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
	public void print()
	{
		for(int i:data)
		{
			System.out.println(i);
		}
	}

}
