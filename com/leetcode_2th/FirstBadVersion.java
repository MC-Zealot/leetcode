package com.leetcode_2th;


/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * 
 * 
 * @author Zealot
 * @date 2016年6月27日 上午10:03:58
 *
 */
public class FirstBadVersion {
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;// if left and right are both very large, their sum will exceed integer limit
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
	}
	boolean isBadVersion(int version){
		return false;
	}
}
