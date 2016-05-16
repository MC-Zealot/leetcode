package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月16日 下午1:28:11
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
