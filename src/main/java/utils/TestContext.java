package utils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
	private static Map<String,Object> testContext = new HashMap<String, Object>();

	public static Object getContext(Keys key) {
		return testContext.get(key.toString());
	}

	public static void setContext(Keys key, Object object) {
		testContext.put(key.toString(), object);
	}
	
	public static Object isContains(Keys key) {
		return testContext.containsKey(key.toString());
	}

}
