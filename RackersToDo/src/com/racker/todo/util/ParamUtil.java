package com.racker.todo.util;
import java.util.HashMap;
import java.util.Map;

/**
 * Used to parse the xml by spliting the xml and return tasks with key value pairs.
 * 
 * @author 
 *
 */
public class ParamUtil {
	public static Map<String,String> parse(String paramString) {
		Map<String,String> params = new HashMap<String,String>();
		String[] paramPairs = paramString.split("&");
		for(String param : paramPairs) {
			String[] key_value = param.split("=");
			params.put(key_value[0], key_value[1]);
		}
		return params;
	}
}
