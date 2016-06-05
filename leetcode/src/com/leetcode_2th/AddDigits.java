package com.leetcode_2th;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * @author Zealot
 * @date 2016年6月5日 下午1:33:16
 *
 */
public class AddDigits {
	public int addDigits(int num) {
		
		while(num/10 != 0){
			int sum = 0;
			while(num!=0){
				sum+=num % 10;
				num = num / 10;
			}
			num = sum;
		}
		
		return num;
    }
	public static void main(String[] args) {
		AddDigits a = new AddDigits();
		System.out.println(a.addDigits(38));
	}
}
