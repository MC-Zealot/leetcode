package com.classicAlgorithm;
/**
 * 全排列，无重复数字
 * 
 * @author Zealot
 * @date 2016年5月5日 上午9:48:29 
 *
 */
public class Permutation {
	static int[] a = new int[10];
	private void permu(int cur) {
		if(a.length - 1 == cur){
			for(int i = 0; i < a.length; i ++) {
				System.out.print(a[i]+"\t");
			}
			System.out.println();
			return;
		}
		for(int i = cur; i < a.length ; i++) {
			swap(i, cur);
			permu(cur+1);
			swap(i, cur);
		}
	}
	private void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		a = arr;
		Permutation  p = new Permutation();
		p.permu(0);
	}
}
