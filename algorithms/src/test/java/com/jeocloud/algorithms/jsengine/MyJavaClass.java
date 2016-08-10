package com.jeocloud.algorithms.jsengine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jeocloud.algorithms.model.User;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class MyJavaClass {
	public static String sayHello(String name) {
		return String.format("Hello %s from Java!", name);
	}

	public int add(int a, int b) {
		return a + b;
	}

	public static void printType(Object object) {
		System.out.println(object.getClass());
	}
	
	public static void printObjectMirror(ScriptObjectMirror mirror) {
	    System.out.println(mirror.getClassName() + ": " + Arrays.toString(mirror.getOwnKeys(true)));
	}
	
	public static void jsonToBean(String json) {
		User user = JSON.parseObject(json, User.class);
		int a =0;
	}
	
	public static void beanToJSON(Object user) {
		String str = JSON.toJSONString(user);
		System.out.println(str);
	}
	
	@Test
	public void test() throws NoSuchMethodException, ScriptException, FileNotFoundException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		String testJS = this.getClass().getClassLoader().getResource("static/js/my-java-class.js").getPath();
		engine.eval(new FileReader(testJS));
		// cast the script engine to an invocable instance
//		Invocable invocable = (Invocable) engine;
//
//		Object result = invocable.invokeFunction("sayHello", "John Doe");
//		System.out.println(result);
//		System.out.println(result.getClass());
	}
}
