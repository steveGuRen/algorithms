package com.jeocloud.algorithms;

import edu.princeton.cs.algorithms.Queue;

public class QueueUseTest {


	
	@org.junit.Test
	public void test() {
		Queue<MyObject> q = new Queue<MyObject>();
		q.enqueue(new MyObject("denghuizhi", "man", "24"));
		q.enqueue(new MyObject("dengbolun", "man", "23"));
		q.enqueue(new MyObject("dengwanjun", "girl", "22"));
		System.out.println(q.isEmpty());
		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}

}
class MyObject{
	private String name;
	private String gender;
	private String old;
	
	public MyObject() {
		// TODO Auto-generated constructor stub
	}
	public MyObject(String name, String gender, String old) {
		this.name = name;
		this.gender = gender;
		this.old = old;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	@Override
	public String toString() {
		return "name is : " + name + "\n"
				+ "gender is : " + gender + "\n"
						+ "old is : " +old + "\n";
	}
	
	
}