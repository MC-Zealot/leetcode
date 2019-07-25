package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,3,2] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 * 
 * @author Zealot
 * @date Jul 25, 2019 9:35:47 PM
 *
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
	}
	public void dfs(TreeNode root,List<Integer> res) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			dfs(root.left, res);
		}
		res.add(root.val);
		if(root.right!=null) {
			dfs(root.right,res);
		}
	}
}
