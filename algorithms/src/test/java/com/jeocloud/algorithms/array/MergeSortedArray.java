package com.jeocloud.algorithms.array;

import org.junit.Test;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0;
		int j = 0;
		for(; j < n-1; j++) {
			for(int k = i; k < m - 1; ) {
				if(nums1[k] < nums2[j]) {
					k++;
				}else {
					i = k;
				}
			}
		}
	}

	/**
	 * Time Limit Exceeded
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		if(n == 0) {
			return;
		} 
		int i = 0;
		for(int k = i; k < m; ) {
			if(nums1[k] <= nums2[0]) {
				k++;
			}else {
				i = k;
				int tem = nums1[k];
				nums1[k] = nums2[0];
				nums2[0] = tem;
				for(int l = 0; l < n - 1; l++) {
					if(nums2[l] > nums2[l + 1]) {
						int tem2 = nums2[l + 1];
						nums2[l + 1] = nums2[l];
						nums2[l] = tem2;
					}else {
						break;
					}
				}
			}
		}
		
		for(int o = 0; o < n; o++) {
			nums1[o + m] = nums2[o];
		}
		return;
	}
	
	public void test() {
		int[] nums1 = new int[7];
		int[] nums2= new int[4];
		int m = 3;
		int n =4;
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		nums2[0] = 2;
		nums2[1] = 4;
		nums2[2] = 6;
		nums2[3] = 8;
		merge2(nums1, m, nums2, n);
		System.out.println(nums1[0]);
	}
	
	@Test
	public void test2() {
		int[] nums1 = new int[7];
		int[] nums2= new int[3];
		int m = 3;
		int n =3;
		nums1[0] = 1;
		nums1[1] = 2;
		nums1[2] = 3;
		
		nums2[0] = 2;
		nums2[1] = 5;
		nums2[2] = 6;
		
		merge2(nums1, m, nums2, n);
		System.out.println(nums1[0]);
	}
}
