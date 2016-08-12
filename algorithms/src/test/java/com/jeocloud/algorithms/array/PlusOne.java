package com.jeocloud.algorithms.array;

import org.junit.Test;

public class PlusOne {
	
	/**
	 * 题目意思是指，用一个数组里面的数排成一列构成一个数字，然后继续用数组的形式将这个数字加一后的值存储起来。数组里面的值都是0~9，第一位不为0
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		int plusTag = 0;
		int tem = 0;
		int i = digits.length - 1;
		digits[i]++;
		for(; i >= 0; i--) {
			digits[i] = digits[i] + plusTag;
			tem = digits[i] % 10;
			plusTag = digits[i] / 10;
			digits[i] = tem;
		}
		if(plusTag == 1) {
			int [] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}else {
			return digits;
		}
	}
	
	@Test
	public void test() {
		int[] nums = new int[6];
		nums[0] = 9;
		nums[1] = 9;
		nums[2] = 9;
		nums[3] = 9;
		nums[4] = 9;
		nums[5] = 9;
		System.out.println(plusOne(nums));
	}
}
