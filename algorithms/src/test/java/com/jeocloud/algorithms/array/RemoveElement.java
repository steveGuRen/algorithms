package com.jeocloud.algorithms.array;

import org.junit.Test;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
    	int i = 0; //当前遍历
    	int length = 0;  //数量
    	for(; i < nums.length; i++) {
    		if(nums[i] != val) {
    			length++;
    			nums[length - 1] = nums[i];
    		}
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
		int val = 4;
		System.out.println(removeElement(nums, val));
    }
}
