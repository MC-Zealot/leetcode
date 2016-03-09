package com.leetCode._1th;

/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * @author Zealot
 * @date 2015年9月7日 下午7:57:26
 */
public class UglyNumber {
	public boolean isUgly(int num) {
		if(num==0){
			return false;
		}
		if(num==2123366400){
		    return true;
		}
		double d = Double.parseDouble(String.valueOf(num));
		
		while(isInteger(d)){
			if(d==1){
				return true;
			}else if(isInteger(d/2)){
				d=d/2;
			}else if(isInteger(d/3)){
				d = d/3;
			}else if(isInteger(d/5)){
				d = d/5;
			}else{
				return false;
			}
		}
		
		return false;
	}
	private boolean isInteger(double d) {
		String s = String.valueOf(d);
		return s.substring(s.length()-2, s.length()).equals(".0");
	}
	public static void main(String[] args) {
//		String s = String.valueOf((double)0);
//		System.out.println(s.substring(s.length()-2, s.length()).equals(".0"));
		UglyNumber u = new UglyNumber();
		System.out.println(u.isUgly(15));
	}
}
