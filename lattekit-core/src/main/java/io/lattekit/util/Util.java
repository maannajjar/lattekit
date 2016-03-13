package io.lattekit.util;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

	private static Boolean HAS_KOTLIN = null;
	
	public static int makeResId(String packageName, String type, String entryName) {
		int x =0;
    	return (((packageName.hashCode()+1)<<24) | (((type.hashCode()+1)&0xFF)<<16) | (entryName.hashCode()&0xFFFF));		
	}
	
	public static Map<String,Object> props(Object...objects) {
		HashMap<String,Object> map = new HashMap<>(objects.length/2);
		for (int i = 0; i< objects.length;i+=2) {
			map.put((String)objects[i], objects[i+1]);
		}
		return map;
	}

	public static boolean hasKotlin() {
		if (HAS_KOTLIN != null) {
			return HAS_KOTLIN;
		}
		try {
			Class.forName("kotlin.jvm.functions.Function0");
			HAS_KOTLIN = true;
		} catch (ClassNotFoundException cnfe) {
			HAS_KOTLIN = false;
		}
		return HAS_KOTLIN;
	}


}
