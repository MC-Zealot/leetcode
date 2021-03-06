package com.leetcode_3th.dp;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
如果左上角>0,则计算能否成矩形：判断上方和左方是否>0，如果大于0，则修改数值
 * 
 * @author Zealot
 * @date Jul 30, 2019 10:34:56 AM 
 *
 */
public class MaximalSquare {
	/**
	 * 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
	 * 否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，
	 * 最多比它的上方，左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，
	 * 这样加上该点就可以构成一个更大的正方形。但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
	 * 这时候只能取那三个正方形中最小的正方形的边长加1了。假设dpi表示以i,j为右下角的正方形的最大边长，则有
	 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
	 * @date Jul 30, 2019 4:20:01 PM
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];//最大正方形的长度
		int maxLen = 0;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}
		return maxLen * maxLen;
	}
}
