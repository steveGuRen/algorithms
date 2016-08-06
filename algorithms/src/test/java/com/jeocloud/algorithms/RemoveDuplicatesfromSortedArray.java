package com.jeocloud.algorithms;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {
	
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		int length = 0;
		int i = 0;  //当前遍历的位置
		boolean issame = false;  //上个位置比较的结果
		int last = nums[0];
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
	@Test
	public void test() {
		int[] nums = new int[5];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		nums[3] = 3;
		nums[4] = 4;
		System.out.println(removeDuplicates(nums));
		System.out.println(removeDuplicates(nums));
	}
}
