package com.leetcode_2th;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
		int i = 0, j = s.length() - 1;
		s = s.toLowerCase();
		while(i < j){
			while(i <s.length()&&!((s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 25)||(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9))){
				i++;
			}
			while(j >=0 &&!((s.charAt(j) - 'a' >= 0 && s.charAt(j) - 'a' <= 25)||(s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9))){
				j--;
			}
			if(i < j&&s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
    }
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
