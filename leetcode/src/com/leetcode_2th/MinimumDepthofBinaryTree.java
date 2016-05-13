package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月13日 下午5:44:01 
 *
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left==null){
			return minDepth(root.right) + 1;
		}
		if(root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
