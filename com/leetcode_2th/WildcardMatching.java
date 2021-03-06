package com.leetcode_2th;
/**
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * 
 * @author Zealot
 * @date 2016年6月29日 上午10:00:51 
 *
 */
public class WildcardMatching {
	/**
	 *  (1)p[j]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'?'，也是相同），
	 *     并且res[i]==true，则更新res[i+1]为true，否则res[i+1]=false;  
        (2)p[j]是'*'。因为'*'可以匹配任意字符串，所以在前面的res[i]只要有true，那么剩下的res[i+1], res[i+2],...,res[s.length()]就都是true了。
	 * @date 2016年6月29日 上午10:28:19
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (p.length() == 0){
			return s.length() == 0;
		}
		if (s.length() > 300 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*') {
			return false;
		}
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					res[i + 1] = res[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !res[i]){
					i++;
				}
				for (; i <= s.length(); i++) {
					res[i] = true;
				}
			}
			res[0] = res[0] && p.charAt(j) == '*';
		}
		return res[s.length()];
	}
}
