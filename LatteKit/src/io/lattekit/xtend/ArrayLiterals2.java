package io.lattekit.xtend;

import java.util.List;

import org.eclipse.xtext.xbase.lib.Inline;

public class ArrayLiterals2 {
	@Inline("new int[$1][]")
	public static int[][] intArray(int outerSize) {
		throw new UnsupportedOperationException();
	}
	
	@Inline(value="io.lattekit.xtend.ArrayLiterals2.unwrap($1)", imported=ArrayLiterals2.class)
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

}
