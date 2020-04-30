package com.ooo.ooo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Score implements Comparator<Map.Entry<Integer,Mymap>>//比较器的重写，实现按成绩排名，从大到小
{
	public int compare(Entry<Integer, Mymap> o1, Entry<Integer, Mymap> o2) 
	{
		if (o1.getValue().score<o2.getValue().score)
		{
			return 1;
		}
		else
		{
			return -1;
		}		
	}	
}
public class Mymap //主类
{	
	String name;
	int score;
	
	public Mymap(String name, int score) 
	{
		this.name = name;
		this.score = score;
	}
	public String toString() //重写toString方法，按格式打印测试结果
	{
		return   "   "+name   +"   "+   score;
	}
	public static void menu(Map<Integer, Mymap> map)//执行测试结果的方法
	{
		map.put(1001, new Mymap("张三",100));
		map.put(1006, new Mymap("李四",58));
		map.put(1003, new Mymap("王五",64));
		map.put(1004, new Mymap("孙六",10));
		map.put(1005, new Mymap("赵七",89));
		String str1="y";
		while (str1.equals("y")||str1.equals("Y"))//功能操作的循环，为了更好的查看测试结果
		{	
		System.out.println("学号                名字              分数");
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			System.out.println(i.getKey()+" "+i.getValue());
		}
		System.out.println("请选择你要进行的操作");
		System.out.println("1、查找内容");
		System.out.println("2、修改内容");
		System.out.println("3、删除内容");
		System.out.println("4、增加内容");
		System.out.println("5、查看全部信息");
		System.out.println("6、按分数排序从大到小");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();//接收数字来进行功能选择
		switch (a)
		{
		case 1:
			search(map);//实现查找功能的方法
		break;
		case 2:
			change(map);//实现修改功能的方法
		break;
		case 3:
			delete(map);//实现删除功能的方法
		break;
		case 4:
			add(map);//实现增加功能的方法
		break;
		case 5:
			information(map);//打印全部信息
		break;
		case 6:
			scorecompare(map);//实现分数排序的方法
		break;
		}
		System.out.println("是否继续y/n");
		str1=sc.next();
		}
	}
	public static void search(Map<Integer, Mymap> map)//查找
	{
		System.out.println("请输入要查找的学号");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		Integer A=new Integer(a);//int型要封装成integer型
		int l=1;//此处用来if判断
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			if (A.equals(i.getKey()))//比较内容是否存在，是的话打印键和值
			{
				l=2;
				System.out.println("                               学号     名字   分数");
				System.out.println("查询到的内容为："+i.getKey()+" "+i.getValue());
			}
		}
		if (l==1)
		{
			System.out.println("没有匹配到相关内容！");
		}
	}
	public static void change(Map<Integer,Mymap> map)//修改
	{
		System.out.println("请输入要修改的学号");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		Integer A=new Integer(a);//int型要封装成integer型
		int l=1;
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			if (A.equals(i.getKey()))//先查后改的思路
			{
				l=2;
				System.out.println("                               学号     名字   分数");
				System.out.println("将要修改的内容："+i.getKey()+" "+i.getValue());
				System.out.println("请输入新的学号");
				int a1=sc.nextInt();
				Integer A1=new Integer(a1);
				A=A1;
				System.out.println("请输入新的名字");
				i.getValue().name=sc.next();
				System.out.println("请输入新的分数");
				i.getValue().score=sc.nextInt();
				System.out.println("修改成功，修改后的信息如下");
				for (Map.Entry<Integer, Mymap> k:map.entrySet())
				{
					System.out.println(k.getKey()+" "+k.getValue());
				}
			}
		}
		if (l==1)
		{
			System.out.println("没有匹配到相关内容！");
		}	
	}
	public static void delete(Map<Integer,Mymap>map)//删除
	{
		System.out.println("请输入要删除的学号");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		Integer A=new Integer(a);//int型要封装成integer型
		int l=1;
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			if (A.equals(i.getKey()))
			{
				
				System.out.println("                               学号     名字   分数");
				System.out.println("要删除的内容为："+i.getKey()+" "+i.getValue());
				l=2;
			}
		}
		if (l==1)
		{
			System.out.println("没有匹配到相关内容！");
		}
		else
		{
			if (l==2)
			{
				map.remove(A);
				System.out.println("成功删除！，删除后的内容如下：");
				for (Map.Entry<Integer, Mymap> k:map.entrySet())
				{
					System.out.println(k.getKey()+" "+k.getValue());
				}
			}
		}	
	}
	public static void add(Map<Integer,Mymap> map)//添加
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入新的学号");
		int a1=sc.nextInt();
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			if (a1==i.getKey())//首先判断书否已有的键，只能添加不重复的键
			{
				System.out.println("这个学号已存在！请重新输入");
				a1=sc.nextInt();
			}
		}
		Integer A1=new Integer(a1);
		System.out.println("请输入新的名字");
		String str=sc.next();
		System.out.println("请输入新的分数");
		int a11=sc.nextInt();
		map.put(A1,new Mymap(str,a11));
		Map<Integer,Mymap> map1=new TreeMap<Integer,Mymap>();
		map1.putAll(map);
		System.out.println("添加成功！，添加后的内容如下：");
		for (Map.Entry<Integer, Mymap> i:map1.entrySet())
		{
			System.out.println(i.getKey()+" "+i.getValue());
		}
	}
	static void information(Map<Integer, Mymap> map)//打印全部信息
	{
		System.out.println("学号                名字              分数");
		for (Map.Entry<Integer, Mymap> i:map.entrySet())
		{
			System.out.println(i.getKey()+" "+i.getValue());
		}
	}
	static void scorecompare(Map<Integer, Mymap> map)//按分数排序
	{
		List<Map.Entry<Integer,Mymap>> list=new ArrayList<>();//排序将键值映射关系全部取出，用list承载
		list.addAll(map.entrySet());                         //sort方法可以进行排序
	    Collections.sort(list,new Score());  
		System.out.println("学号                名字              分数");
		for (int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}	
}	