package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Zealot
 * @date 2016年7月12日 下午4:10:14 
 *
 */
public class BinaryTreePostorderTraversal {
	
	/**
	 * dfs
	 * @date 2016年7月12日 下午4:12:46
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
    }
	private void dfs(TreeNode root, List<Integer> res) {
		if(root==null){
			return ;
		}
		dfs(root.left, res);
		dfs(root.right, res);
		res.add(root.val);
	}
}
