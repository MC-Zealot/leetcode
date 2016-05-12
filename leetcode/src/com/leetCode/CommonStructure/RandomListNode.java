package com.leetCode.CommonStructure;
/**
 * Definition for singly-linked list with a random pointer.
 * 
 * @author Zealot
 * @date 2016年5月12日 下午6:33:10 
 *
 */
public class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
