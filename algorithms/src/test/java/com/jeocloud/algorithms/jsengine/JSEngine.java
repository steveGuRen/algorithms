package com.jeocloud.algorithms.jsengine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.Test;

/**
 * @see http://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/
 * @author steve
 *
 */
public class JSEngine {

	public static void main(String[] args) throws ScriptException {
		test5();
		test55();
	}

	/*
	 * "Hello, World"
	 * 
	 * From the ScriptEngineManager instance, we request a JavaScript engine
	 * instance using getEngineByName method. On the script engine, the eval
	 * method is called to execute a given String as JavaScript code! For
	 * brevity, in this as well as in subsequent examples, we have not shown
	 * exception handling. There are checked and runtime exceptions thrown from
	 * javax.script API. Needless to say, you have to handle the exceptions
	 * appropriately.
	 * 
	 */
	// @Test
	public void test() throws ScriptException {
		// create a script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// create a JavaScript engine
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		// evaluate JavaScript code from String
		engine.eval("print('Hello, World')");
	}

	/*
	 * Evaluating a Script File
	 */
	 @Test
	public void test2() {
		String[] strs = new String[3];
		String testJS = this.getClass().getClassLoader().getResource("static/js/test.js").getPath();
		// create a script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// create JavaScript engine
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		
		// evaluate JavaScript code from given file - specified by first
		// argument
		try {
			engine.eval(new java.io.FileReader(testJS));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Invoking Script Functions and Methods
	 * 
	 */
	// @Test
	public void test3() throws NoSuchMethodException, ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		// JavaScript code in a String
		String script = "function hello(name) { print('Hello, ' + name); }";
		// evaluate script
		engine.eval(script);

		// javax.script.Invocable is an optional interface.
		// Check whether your script engine implements or not!
		// Note that the JavaScript engine implements Invocable interface.
		Invocable inv = (Invocable) engine;

		// invoke the global function named "hello"
		inv.invokeFunction("hello", "Scripting!!");
	}

	/*
	 * Invoking Script Functions and Methods 2
	 * 
	 */
	// @Test
	public void test4() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		// JavaScript code in a String. This code defines a script object 'obj'
		// with one method called 'hello'.
		String script = "var obj = new Object(); obj.hello = function(name) { print('Hello, ' + name); }";
		// evaluate script
		engine.eval(script);

		// javax.script.Invocable is an optional interface.
		// Check whether your script engine implements or not!
		// Note that the JavaScript engine implements Invocable interface.
		Invocable inv = (Invocable) engine;

		// get script object on which we want to call the method
		Object obj = engine.get("obj");

		// invoke the method named "hello" on the script object "obj"
		inv.invokeMethod(obj, "hello", "Script Method !!");
	}

	/*
	 * Implementing Java Interfaces by Scripts
	 * 
	 * 需要用main方法跑，否则会出问题
	 */

	public static void test5() throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		// JavaScript code in a String
		String script = "function run() { print('run called' + 'run run run'); }";

		// evaluate script
		engine.eval(script);

		Invocable inv = (Invocable) engine;

		// get Runnable interface object from engine. This interface methods
		// are implemented by script functions with the matching name.
		Runnable r = inv.getInterface(Runnable.class);

		// start a new thread that runs the script implemented
		// runnable interface
		Thread th = new Thread(r);
		th.start();
	}

	/*
	 * Implementing Java Interfaces by Scripts 2
	 * 
	 * 需要用main方法跑，否则会出问题
	 */
	public static void test55() throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		// JavaScript code in a String
		String script = "var obj = new Object(); obj.run = function() { print('run method called'); }";

		// evaluate script
		engine.eval(script);

		// get script object on which we want to implement the interface with
		Object obj = engine.get("obj");

		Invocable inv = (Invocable) engine;

		// get Runnable interface object from engine. This interface methods
		// are implemented by script methods of object 'obj'
		Runnable r = inv.getInterface(obj, Runnable.class);

		// start a new thread that runs the script implemented
		// runnable interface
		Thread th = new Thread(r);
		th.start();
	}

	// @Test
	public void test6() throws ScriptException, FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		File f = new File("test.txt");
		FileOutputStream fos = new FileOutputStream(f);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		// expose File object as variable to script
		engine.put("file", f);
		engine.put("osw", osw);
		engine.put("bw", bw);
		// evaluate a script string. The script accesses "file"
		// variable and calls method on it
		engine.eval("print(file.getAbsolutePath()); bw.write('hello world');bw.flush();bw.close();");
	}

//	@Test
	public void test7() throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		engine.put("x", "hello");
		// print global variable "x"
		engine.eval("print(x);");
		// the above line prints "hello"

		// Now, pass a different script context
		ScriptContext newContext = new SimpleScriptContext();
		Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);

		// add new variable "x" to the new engineScope
		engineScope.put("x", "world");

		// execute the same script - but this time pass a different script
		// context
		engine.eval("print(x);", newContext);
		// the above line prints "world"
	}

//	public void test2Fun(String[] args) {
//		// create a script engine manager
//		ScriptEngineManager factory = new ScriptEngineManager();
//		// create JavaScript engine
//		ScriptEngine engine = factory.getEngineByName("JavaScript");
//		// evaluate JavaScript code from given file - specified by first
//		// argument
//		try {
//			engine.eval(new java.io.FileReader(args[0]));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
