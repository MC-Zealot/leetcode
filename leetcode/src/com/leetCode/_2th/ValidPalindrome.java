package com.leetCode._2th;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * @author Zealot
 * @date 2016年2月1日 上午10:34:33
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] cc = s.toCharArray();
		int left = 0,right = cc.length-1;
		while(left< right){
			if(cc[left] == cc[right]){
				left++;right--;
			}else{
				return false;
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("121"));
		System.out.println('c'=='c');
		
	}
	
}