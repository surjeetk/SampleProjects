package com.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RunningJavaScript {

	public static void main(String args[]) {

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");

		String script = "var welcome='hello';" + "welcome+=' David';"
				+ "welcome;";

		Object result = null;
		try {

			result = engine.eval(script); //it can also accept FileReader for script file
		} catch (ScriptException ex) {
			System.out.println("exception occurred:"+ex.getMessage());
		}
		
		System.out.println(result.toString());
		
		

	}
}
