package com.leetcode_2th;
/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * 
 * @author Zealot
 * @date 2016年7月12日 上午11:14:31 
 *
 */
public class InterleavingString {
	/**
直观上，我看到该题，就会去想，s1取一部分，s2取一部分，然后再s1取一部分，反复知道匹配完成s3，算法去模拟这样的操作。

而当s1和s3匹配了一部分的时候，剩下s1‘和剩下的s3‘与s2又是一个子问题。这样很容易写成一个递归，但是需要注意两点：

1. 递归方法中，我们总是拿s1首先去匹配s3，如果不匹配，直接返回false。这样做的原因是保持匹配是“交替”进行的；

2. 当出现既可以匹配s1，又可以匹配s2的时候，一样可以通过递归来解决，看下面的代码。
	 * @date 2016年7月12日 下午3:41:24
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	private boolean isInterleaveInternal(String s1, String s2, String s3){
        if(s1.equals("")) {
            return s2.equals("") && s3.equals("");
        }
        if(s1.equals(s3) && s2.endsWith("")) {
        	return true;
        }
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        if(s1.charAt(0) != s3.charAt(0)) return false;
        while(i1 < s1.length() && i2 < s2.length() && i3 < s3.length() && s1.charAt(i1) == s3.charAt(i3)) {
            i1++;
            i3++;
            //如果这里s2也可以匹配s3，那么我们立马递归进行匹配
            if(s2.charAt(i2) == s3.charAt(i3) && isInterleaveInternal(s2.substring(i2), s1.substring(i1), s3.substring(i3)))
                return true;
        }
        //接下来开始匹配s2
        return isInterleaveInternal(s2, s1.substring(i1), s3.substring(i3));
        
    }
	public boolean isInterleave2(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
        matched[0][0] = true;
        for(int i1 = 1; i1 <= s1.length(); i1++){
            if(s3.charAt(i1-1) == s1.charAt(i1-1)) {
                matched[i1][0] = true;
            }else break;
        }
        for(int i2 = 1; i2 <= s2.length(); i2++){
            if(s3.charAt(i2 - 1) == s2.charAt(i2 - 1)) {
                matched[0][i2] = true;
            }else break;
        }
        
        for(int i1 = 1; i1 <= s1.length(); i1++){
            char c1 = s1.charAt(i1 - 1);
            for(int i2 = 1; i2 <= s2.length(); i2++){
                int i3 = i1 + i2;
                char c2 = s2.charAt(i2 - 1);
                char c3 = s3.charAt(i3 - 1);
                if(c1 == c3){
                    matched[i1][i2] |= matched[i1 - 1][i2];
                }
                if(c2 == c3){
                    matched[i1][i2] |= matched[i1][i2 - 1];
                }
            }
        }
        return matched[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		InterleavingString i = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(i.isInterleaveInternal(s1, s2, s3));
	}
}
