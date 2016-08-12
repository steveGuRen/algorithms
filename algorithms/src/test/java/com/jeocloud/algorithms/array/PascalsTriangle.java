package com.jeocloud.algorithms.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalsTriangle {
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(1);
		List<Integer> row2 = new ArrayList<>();
		row2.add(1);
		row2.add(1);
		if(numRows == 0) {
			return list;
		}
		if(numRows == 1) {
			list.add(row1);
			return list;
		}
		if(numRows == 2) {
			list.add(row1);
			list.add(row2);
			return list;
		}
		list.add(row1);
		list.add(row2);
		for(int i = 2; i < numRows; i++) {  //i代表当前行
			List<Integer> newRow = new ArrayList<>();
			List<Integer> upRow = list.get(i - 1);  //取得上一行
			for(int j = 0; j <= i; j++ ) {
				if(j == 0 || j == i) {
					newRow.add(1);
				}else {  
					//当前值等于上一行的（上一个位置的值+当前位置的值）
					newRow.add(upRow.get(j - 1) + upRow.get(j));
				}
			}
			list.add(newRow);
		}
		return list;
	}
	
	@Test
	public void test() {
		generate(5);
	}
}
