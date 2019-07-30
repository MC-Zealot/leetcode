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
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i - 1 >= 0 && j - 1 >= 0) {
					int left_up = matrix[i - 1][j - 1];
					if(left_up > 0) {
//						左边，上边都>0
						boolean flags = true;
						int tmp_j = j,tmp_i = i;
						while(tmp_j>=0) {
							if(matrix[i][tmp_j]==0) {
								flags=false;
								break;
							}
							j--;
						}
						
						while(tmp_i >= 0) {
							
						}
					}
				}
			}
		}
		//遍历一次矩阵，找到最大的值
		return res;
	}
}
