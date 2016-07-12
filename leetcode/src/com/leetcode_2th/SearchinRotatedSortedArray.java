package com.leetcode_2th;

/**
 * （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
（2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。

 * 
 * @author Zealot
 * @date 2016年6月7日 下午9:42:19
 *
 */
public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (target == A[m])
				return m;
			if (A[m] < A[r]) {
				if (target > A[m] && target <= A[r]){//单调
					l = m + 1;
				}
				else{
					r = m - 1;
				}
			} else {
				if (target >= A[l] && target < A[m]){//单调
					r = m - 1;
				}
				else{
					l = m + 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] a = {3,1,1};
		System.out.println(s.search(a, 3));
		
	}
}
