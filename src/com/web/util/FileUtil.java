package com.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FileUtil {

	public static void main(String[] args) throws IOException {
	File from=new File("D:\\CloudMusic\\谭维维 - 往日时光.mp3");

	copyFile(from);

	}
	
	public static void travelse(File file)
	{
		if(file.isDirectory())
		{
			File[] f=file.listFiles();
			for(File s:f)
			System.out.println(s.getAbsolutePath());
			for(File s:f)
			{
				travelse(s);
			}
		}
		else
			System.out.println(file.getAbsolutePath()+file.getName());
	}
	public static void writeRandomAccessFile(File file) throws IOException
	{
		if(!file.exists())
			file.createNewFile();
		
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		raf.writeUTF("我的天空有点蓝");
		raf.close();
	
		
	}
	public static void readRandomAccessFile(File file) throws IOException
	{
		if(file.isFile())
		{
			RandomAccessFile raf=new RandomAccessFile(file, "r");
			long length=raf.length();
			raf.seek(0);
			byte[] b=new byte[(int) length];
			raf.read(b);
			System.out.println(new String(b,"utf-8"));
			raf.close();
		}
	}
	
	public static void copyFile(File from,File to) throws IOException
	{ 
		long start=System.currentTimeMillis();
		createFile(from);
		createFile(to);
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(from));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(to));
		byte[] temp=new byte[1024];
		int length;
		while((length=bis.read(temp))!=-1)
		{
			bos.write(temp, 0, length);
		}
		bis.close();
		bos.close();
		long end=System.currentTimeMillis();
		System.out.println("executed time:"+(end-start)+"ms");
		
	}
	
	
	public static void copyFile(File file) throws IOException
	{
		String name=file.getName();
		File to=new File(file.getParentFile().getAbsolutePath()+"\\"+"(复件)"+name);
		copyFile(file, to);
		
	}

	public static void createFile(File file) throws IOException
	{
		if(!file.exists())
		{
			File parentFile=file.getParentFile();
			if(parentFile!=null)
			{
				if(!parentFile.exists())
					parentFile.mkdirs();
			}
			file.createNewFile();
		}
	}

}
