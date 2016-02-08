package io.lattekit.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.xbase.lib.Inline;

public class Util {
	@Inline("new int[$1][]")
	public static int[][] intArray(int outerSize) {
		throw new UnsupportedOperationException();
	}
	
	@Inline(value="io.lattekit.xtend.ArrayLiterals2.unwrap($1)", imported=Util.class)
	public static int[][] unwrap(List<List<Integer>> list) {
		int[][] arr = new int[list.size()][];
		int i = 0;
		for (List<Integer> inner : list) {
			int[] innerArr = arr[i++] =  new int[inner.size()];
			int j = 0;
			for (int innerVal : inner) innerArr[j++] = innerVal;
		}
		return arr;
	}
	
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

}