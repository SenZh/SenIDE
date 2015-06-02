package com.web;

import java.util.Random;

public class PaiXu{
	
	int[] data;
	public static void main(String[] args) {	
		Sort sort=new Sort();
		PaiXu px=new PaiXu(100);
		int[] da=new int[px.data.length];
		for(int i=0;i<da.length;i++)
		{
			da[i]=px.data[i];
		}
		sort.BinarySort(px.data);
		px.print();
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
		{	if(num<=100)
			data[i]=rm.nextInt(101);
			else
				data[i]=rm.nextInt(num);
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
		long a=System.currentTimeMillis();
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

class ShellSort
{
	int[] data;
	public ShellSort()
	{
		Initialize(100);
	
	}
	public ShellSort(int number)
	{
		Initialize(number);
	}
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
			data[i]=rm.nextInt(number+100);
	}
	
	public void sort()
	{
		int d=data.length/2;
		while(d>0)
		{
			
			for(int i=0;i<d;i++)
			{
				
				for(int j=i+d;i+j*d<data.length;j++)
				{
					int temp=data[j];
					int m;
					for(m=j-d;m>=0;m-=d)
					{
						if(data[m]<temp)
							data[m+d]=data[m];
						else
							break;
					}
					data[m+d]=temp;
						
				}
			}
			d=d/2;
		}
	}
	public void print()
	{
		for(int i:data)
			System.out.println(i);
	}
	
}
class SimpleSelectionSort
{
	int[] data;
	public SimpleSelectionSort()
	{
		Initialize(100);
	}
	public SimpleSelectionSort(int number)
	{
		Initialize(number);
	}
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
			data[i]=rm.nextInt(number+100);
	}
	public void sort()
	{
		for(int i=0;i<data.length;i++)
		{
			int max=data[i];
			int index=i;
			for(int j=i;j<data.length;j++)
			{
				if(data[j]>max)
				{
					max=data[j];
					index=j;
				}
			}
			data[index]=data[i];
			data[i]=max;
			
		}
	}
	public void print()
	{
		for(int i:data)
			System.out.println(i);
	}
}
class BubbleSort
{
	int[] data;
	public BubbleSort()
	{
		Initialize(100);
	}
	public BubbleSort(int number)
	{
		Initialize(number);
	}
	
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
		{
			data[i]=rm.nextInt(100+number);
		}
	}
	public void sort()
	{
		for(int i=0;i<data.length;i++)
		{
			
			for(int j=0;j<data.length-i-1;j++)
			{
				 int temp=data[j];
				if(data[j+1]>temp)
				{  
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
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

class QuickSort
{

	int[] data;
	public QuickSort()
	{
		Initialize(100);
	}
	public QuickSort(int number)
	{
		Initialize(number);
	}
	
	public void Initialize(int number)
	{
		data=new int[number];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
		{
			data[i]=rm.nextInt(100+number);
		}
	}
	
	public void ArrayAdjust(int begin,int end)
	{
		
		if(begin<end)
		{
			int i=begin;
			int j=end;
			int temp=data[i];
		while(i<j)
		{	
			while(data[j]<=temp&&i<j)
				j--;
			if(data[j]>temp)
			{
				data[i++]=data[j];
				
			}
			while(data[i]>temp&&i<j)
				i++;
			if(data[i]<=temp)
			{
				data[j--]=data[i];
			
			}
		}
		data[i]=temp;
		ArrayAdjust(begin, i-1);
		ArrayAdjust(i+1, end);
		}
	}
	public void sort()
	{
		long a=System.currentTimeMillis();
		ArrayAdjust(0,data.length-1);
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

class Sort
{
	public void QuickSort(int[] data)
	{
		long a=System.currentTimeMillis();
		qs(data,0,data.length-1);
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	private void qs(int[] data,int begin,int end)
	{
		if(begin<end)
		{
			int temp=data[begin];
			int i=begin;
			int j=end;
			while(i<j)
			{
				while(i<j&&data[j]<temp)
					j--;
				if(i<j)
					data[i++]=data[j];
				while(i<j&&data[i]>=temp)
					i++;
				if(i<j)
					data[j--]=data[i];
			}
			data[i]=temp;
			qs(data,begin,i-1);
			qs(data,i+1,end);
		}
	}
	private void sis(int[] data,int begin,int end)
	{
		for(int i=begin+1;i<end+1;i++)
		{
			int temp=data[i];
			int j;
			for(j=i;j-1>=0;j--)
			{
				if(data[j-1]<temp)
					data[j]=data[j-1];
				else
					break;
			}
			data[j]=temp;
		}
	}
	public void StraightInsertionSort(int[] data)
	{
		long a=System.currentTimeMillis();
		sis(data,0,data.length-1);
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	public void SimpleSelectionSort(int[] data)
	{
		long a=System.currentTimeMillis();
		int max;
		int index;
		for(int i=0;i<data.length;i++)
		{
			max=data[i];
			index=i;
			for(int j=i+1;j<data.length;j++)
			{
				if(data[j]>max)
				{
					max=data[j];
					index=j;
				}
			}
			data[index]=data[i];
			data[i]=max;
		}
		
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	public void BubbleSort(int[] data)
	{
		long a=System.currentTimeMillis();
		int temp=0;
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j+1<data.length-i;j++)
			{
				if(data[j]<data[j+1])
				{
					temp=data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
		}
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	public void AdvancedQuickSort(int[] data)
	{
		long a=System.currentTimeMillis();
		aqs(data,0,data.length-1);
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	private void aqs(int[] data,int begin,int end)
	{
		if(end-begin>17)
		{
			int i=begin;
			int j=end;
			int temp=data[i];
			while(i<j)
			{
				while(i<j&&data[j]<temp)
					j--;
				if(i<j)
					data[i++]=data[j];
				while(i<j&&data[i]>=temp)
					i++;
				if(i<j)
					data[j--]=data[i];
				
			}
			data[i]=temp;
			aqs(data,begin,i-1);
			aqs(data,i+1,end);
		}
		else if(end-begin>1)
		{
			sis(data, begin, end);
		}
	}
	private int binarySearch(int[] data,int begin,int end,int value)
	{
		int i=begin;
		int j=end;
		if(j-i>1)
		{
			int mid=(i+j)/2;
			if(value>data[mid])
				return binarySearch(data,begin,mid,value);
			else 
				return binarySearch(data,mid,end,value); 
				
		}
		else if(i==j)
		{
			if(data[i]<value)
				return i;
			else 
				return i+1;
		}
		else if(i+1==j)
		{
			if(value>data[i])
				return i;
			else if(value<data[j])
				return j+1;
			else
				return j;
		}
		else 
		{
			System.out.println("error");
			return 0;
		}
	}
	private void bs(int[] data,int begin,int end)
	{
		for(int i=begin+1;i<end+1;i++)
		{
			int index=binarySearch(data, begin, i-1, data[i]);
			int dq=data[i];
			for(int j=i;j>index;j--)
			{
				data[j]=data[j-1];
			}
			data[index]=dq;
		}
	}
	public void BinarySort(int[] data)
	{
		long a=System.currentTimeMillis();
		bs(data,0, data.length-1);
		long b=System.currentTimeMillis();
		System.out.println("Time:"+(b-a)+"ms");
	}
	
}

