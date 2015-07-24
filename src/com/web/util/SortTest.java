package com.web.util;

import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
	
		int data[]=new int[10000000];
		Random rm=new Random();
		for(int i=0;i<data.length;i++)
			data[i]=rm.nextInt(data.length);
		Sort1 sort=new Sort1();

		long start=System.currentTimeMillis();
		
//		sort.StraightSort(data, false);
//		sort.BinaryInsertion(data, true);
		sort.QuickSort(data, false);
//		sort.BubbleSort(data, false);
//		sort.SimpleChoice(data, true);
		long end=System.currentTimeMillis();
		
//		for(int i:data)
//			System.out.println(i);
		System.out.println("Time:"+(end-start)+"ms");
	}



}

class Sort1
{
	public void StraightSort(int[] data,boolean isDesc)
	{
		if(isDesc)
		StraightDesc(data);
		else
			StraightAsc(data);
	}
	
	private void StraightDesc(int[] data)
	{
		for(int i=1;i<data.length;i++)
		{
			int temp=data[i];
			int j;
			for(j=i-1;j>=0;j--)
			{
				if(temp>data[j])
				{
					data[j+1]=data[j];
					
				}
				else 
					break;
			}
			data[j+1]=temp;
			
		}
	}
	private void StraightAsc(int[] data)
	{
		for(int i=1;i<data.length;i++)
		{
			int temp=data[i];
			int j;
			for(j=i-1;j>=0;j--)
			{
				if(data[j]>temp)
					data[j+1]=data[j];
				else
					break;
			}
			data[j+1]=temp;
		}
	}
	public void BinaryInsertion(int[] data,boolean isDesc)
	{
		if(isDesc)
		InsertionDesc(data);
		else
		InsertionAsc(data);
	}
	private int binaryDesc(int[] data,int begin,int end,int num)
	{
		int i=begin,j=end,mid;
		while(j-i>1)
		{
			mid=(i+j)/2;
			if(data[mid]>num)
				i=mid;
			else 
				j=mid;		
		}
			if(num>data[i])
				return i;
			else if(num<data[j])
				return (j+1)<=data.length-1?j+1:data.length-1;
			else
				return j;
	
	}
	private void InsertionDesc(int[] data)
	{
		for(int i=1;i<data.length;i++)
		{
			int index=binaryDesc(data,0,i,data[i]);
			int temp=data[i];
			for(int j=i;j-1>=index;j--)
			{
				data[j]=data[j-1];
			}
			data[index]=temp;
		}
	}
	private void InsertionAsc(int[] data)
	{
		for(int i=1;i<data.length;i++)
		{
			int index=binaryAsc(data,0,i,data[i]);
			int temp=data[index];
			for(int j=i;j-1>=index;j--)
			{
				data[j]=data[j-1];
				
			}
			data[index]=temp;
		}
	}
	private int binaryAsc(int[] data,int begin,int end,int num)
	{
		int i=begin,j=end,mid;
		while(j-i>1)
		{
			mid=(i+j)/2;
			if(num>data[mid])
				i=mid;
			else
				j=mid;
		}
		if(num<data[i])
			return i;
		else if(num>data[j])
			return (j+1<=data.length-1)?j+1:data.length-1;
		else
			return j;
	}
	public void QuickSort(int[] data,boolean isDesc)
	{
		if(isDesc)
			QuickDesc(data, 0, data.length-1);
		else
		QuickAsc(data,0,data.length-1);
	}
	private void QuickAsc(int[] data,int begin,int end)
	{
		
		if(begin<end)
		{
			int temp=data[begin];
			int i=begin,j=end;
			
	/*		int mid=(begin+end)/2;
	 * 		int[] find={data[begin],data[mid],data[end]};
			BubbleSort(find, false);
			if(find[1]==data[begin])
				mid=begin;
			else if(find[1]==data[end])
				mid=end;
			data[begin]=data[mid];
			data[mid]=temp;
			temp=data[begin];
			*/
		while(i<j)
		{
		
			while(data[j]>=temp&&i<j)
				j--;
			if(i<j)
			{
				data[i++]=data[j];
			}
			
			while(data[i]<=temp&&i<j)
				i++;
			if(i<j)
			{
				data[j--]=data[i];			
			}
		}
		if(i==j)
		{
			data[i]=temp;
			QuickAsc(data,begin,i-1);
			QuickAsc(data,i+1,end);
		}
		}
	}
	private void QuickDesc(int[] data,int begin,int end)
	{
		if(begin<end)
		{
			int i=begin,j=end,temp=data[begin];
			while(i<j)
			{
				while(data[j]<=temp&&i<j)
					j--;
				if(i<j)
					data[i++]=data[j];
				while(data[i]>=temp&&i<j)
					i++;
				if(i<j)
					data[j--]=data[i];
			}
			if(i==j)
			{
				data[i]=temp;
				QuickDesc(data,begin,i-1);
				QuickDesc(data,i+1,end);
			}
		}
	}
	
	public void BubbleSort(int[] data,boolean isDesc)
	{
		for(int i=0;i<data.length;i++)
		{
			int temp=data[i];
			for(int j=0;j<data.length-i-1;j++)
			{
				temp=data[j];
				if(isDesc)
					{
				if(data[j]<data[j+1])
				{
					data[j]=data[j+1];
					data[j+1]=temp;
				}
					}
				else
					if(data[j]>data[j+1])
					{
						data[j]=data[j+1];
						data[j+1]=temp;
					}
					
			}
		}
	}
	public void SimpleChoice(int[] data,boolean isDesc)
	{
		for(int i=0;i<data.length;i++)
		{
			int index=i;
			int temp=data[i];
			for(int j=i;j<data.length;j++)
			{
				if(isDesc)
				{
				if(data[index]<data[j])
					index=j;
				}
				else
				{
					if(data[index]>data[j])
						index=j;
					
				}
			}
			data[i]=data[index];
			data[index]=temp;
		}
	}
	
}
