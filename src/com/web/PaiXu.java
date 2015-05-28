package com.web;

import java.util.Random;

public class PaiXu{
	
	int[] data;
	public static void main(String[] args) {
		
		PaiXu charu=new PaiXu(100000);
		StackSort stacksort=new StackSort(100);
		StraightInsertionSort straight=new StraightInsertionSort();
		BinaryInsertionSort binarysort=new BinaryInsertionSort(20);
		binarysort.sort();
		binarysort.print();
		
	//	straight.sortAsc();
	//	straight.print(10);
	//	stacksort.sort();
	//	stacksort.print();
	//	charu.xierpx(2);
	//	charu.paixu();
	//	charu.px2fen();
	//	charu.simpleChoiceSort();
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
class StackSort
{
	int[] data;
	public StackSort()
	{
		Initialize(100);
	}
	public StackSort(int number)
	{
		Initialize(number);
	}
	
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
		{
			data[i]=rm.nextInt(number);
		}
	}
	public void print()
	{
		for(int i:data)
		System.out.println(i);
	}
	
	public void makeMiniStack()
	{
		for(int i=data.length-1;i>0;i-=2)
		{
		
			   sortStack((i-1)/2,data.length-1);
		}
	}
	public void sortStack(int root,int end)
	{
		int index;
		int last;
		int temp;		
		for(int i=root;i*2+1<end;i++)
		{
			temp=data[2*i+1];
			if(temp>data[2*i+2])
			{
				data[2*i+1]=data[2*i+2];
				data[2*i+2]=temp;
			}
			temp=data[i];
			if(temp>data[2*i+1])
			{
				data[i]=data[2*i+1];
				data[2*i+1]=temp;
			}
		}
	}
	public void sort()
	{
		int index;
		int last;
		makeMiniStack();
		long a=System.currentTimeMillis();
		for(index=data.length-1;index>0;index--)
		{
			last=data[index];
			data[index]=data[0];
			data[0]=last;
			sortStack(0, index-1);
		}
		long b=System.currentTimeMillis();
		System.out.println("time  :"+(b-a));
	}
}
class StraightInsertionSort
{
	int[] data;
	public StraightInsertionSort()
	{
		Initialize(100);
	}
	public StraightInsertionSort(int number)
	{
		Initialize(number);
	}
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
		{
			data[i]=rm.nextInt(number+100);
		}
	}
	public void sortDesc()
	{
		int temp;
		int j;
		for(int i=1;i<data.length;i++)
		{
			temp=data[i];
			for(j=i-1;j>=0;j--)
			{
				if(data[j]<temp)
					data[j+1]=data[j];
				else
				{
					
					break;
				}
			}
			data[j+1]=temp;
		}
	}
	public void sortAsc()
	{
		int temp;
		int j;
		for(int i=1;i<data.length;i++)
		{
			temp=data[i];
			for(j=i-1;j>=0;j--)
			{
				if(data[j]>temp)
					data[j+1]=data[j];
				else
				{
					
					break;
				}
			}
			data[j+1]=temp;
		}
	}
	public void print(int number)
	{
		for(int i=0;i<data.length;i++)
		{
			if((i)%number==0)
				System.out.println(data[i]);
			else
				System.out.print(data[i]+" ");
		}
	}
	public void print()
	{
		print(1);
	}
	
}
class BinaryInsertionSort
{
	int[] data;
	public BinaryInsertionSort()
	{
		Initialize(100);
	}
	public BinaryInsertionSort(int number)
	{
		Initialize(number);
	}
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
		{
			data[i]=rm.nextInt(100);
		}
	}
	public int binartSearch(int begin,int end,int dat)
	{
		int left=begin;
		int right=end;
		int mid=(left+right)/2;
		while(right-left>1)
		{
			mid=(left+right)/2;
			if(dat>=data[mid])
				right=mid;
			else if(dat<data[mid])
				left=mid;
		}
		return right;
		
	}
	public void sort()
	{
		int temp;
		int index;
		for(int i=1;i<data.length;i++)
		{
			temp=data[i];		
			if(temp>=data[0])
				index=0;
			else if(temp<=data[i-1])
				index=i;
			else
			index=binartSearch(0,i-1,temp);
		
			for(int j=i-1;j>=index;j--)
			{
				data[j+1]=data[j];
			}
			data[index]=temp;
			
		}
	}
	public void print()
	{
		for(int i:data)
		{
			System.out.println(i);
		}
	}
}