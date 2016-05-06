package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月6日 下午3:33:21 
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		int tmp = x, rev = 0;
		while (tmp > 0) {
			rev = rev * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		return x == rev;
	}
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(12210));
		System.out.println();
	}
}
