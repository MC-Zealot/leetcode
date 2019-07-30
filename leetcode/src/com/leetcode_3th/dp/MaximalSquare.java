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
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];
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
