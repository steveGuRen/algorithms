package com.jeocloud.algorithms;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {
	
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		int length = 0;
		int i = 0;  //当前遍历的位置
		boolean issame = false;  //上个位置比较的结果
		//一次遍历一样的
		for(; i < nums.length - 1; i++) {
			if(!issame) {
				length++;
				nums[length - 1] = nums[i];
				
			}
			if(nums[i] == nums[i+1]){
				issame = true;
			}else {
				issame = false;
			}
		}
		if(!issame) {
			length++;
			nums[length - 1] = nums[i];
		}
		return length;
	}
	
	public int removeDuplicates2(int[] nums) {
		if(nums.length == 0) return 0;
		int length = 0;
		int i = 0;  //当前遍历的位置
		int samenum = 0;  //上次比较结果，可能是0，说明上次比较不一样，可能是1，说明上次一样，也可能是2
		for(; i < nums.length - 1; i++) {
			if(samenum >= 0 && samenum <= 1) {
				length++;
				nums[length - 1] = nums[i];
			}
			if(nums[i] == nums[i+1]) {
				samenum++;
			}else {
				samenum = 0;
			}
		}
		if(samenum >= 0 && samenum <= 1) {
			length++;
			nums[length - 1] = nums[i];
		}
		return length;
	}
	
	@Test
	public void test() {
		int[] nums = new int[6];
		nums[0] = 1;
		nums[1] = 3;
		nums[2] = 3;
		nums[3] = 3;
		nums[4] = 4;
		nums[5] = 4;
		System.out.println(removeDuplicates(nums));
	}
	@Test
	public void test2() {
		int[] nums = new int[6];
		nums[0] = 1;
		nums[1] = 3;
		nums[2] = 3;
		nums[3] = 3;
		nums[4] = 4;
		nums[5] = 4;
		System.out.println(removeDuplicates2(nums));
	}
}
