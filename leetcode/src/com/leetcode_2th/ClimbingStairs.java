package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午9:15:07 
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
    }
	public int climbStairs2(int n) {
		int[] a = new int[n + 1];
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		a[1] = 1;
		a[2] = 2;
		for(int i = 3; i <=n; i++) {
			a[i] = a[i -1] + a[i -2];
		}
		return a[n];
    }
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println();
	}
}
