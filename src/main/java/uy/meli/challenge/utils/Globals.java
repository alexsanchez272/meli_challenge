package uy.meli.challenge.utils;

import java.util.HashMap;
import java.util.Map;

public class Globals {

	public static ThreadLocal<Map<String, Object>> GLOBAL_CACHE;

	static {
		GLOBAL_CACHE = new ThreadLocal<Map<String, Object>>() {
			@Override
			public Map<String, Object> initialValue() {
				return new HashMap<>();
			}
		};
	}

}
