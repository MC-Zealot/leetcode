package com.leetcode_3th.others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), 

where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 

Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


 * 
 * @author Zealot
 * @date Aug 2, 2019 4:38:40 PM 
 *
 */
public class QueueReconstructionbyHeight {
	/**
	 * 1、按身高从小到大排序
 [4,4], [5,0], [5,2], [6,1], [7,0], [7,1]

2、从小到大占坑，规则：当前元素放在k的位置，如果前边有x个小于当前元素的元素，则放在x+k，如果x+k被占了，往后+1循环
	 * @date Aug 2, 2019 5:15:03 PM
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
		int[][] res = new int[people.length][];
		ArraysCom com = new ArraysCom();
		Arrays.sort(people,com);
		for(int i = 0; i < people.length; i++) {
			int h = people[i][0];
			int k = people[i][1];
			//前边有x个小于当前元素的元素，计算x
			int x = 0;
			for(int j = 0; j < k; j++) {
				int h_tmp = res[j][0];
				if(h_tmp<h) {
					x++;
				}
			}
			
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();
		int[][] nums = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}; 
		ArraysCom com = new ArraysCom();
		Arrays.sort(nums,com);
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}
}
class ArraysCom implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[0] - o2[0];
	}
	
}
