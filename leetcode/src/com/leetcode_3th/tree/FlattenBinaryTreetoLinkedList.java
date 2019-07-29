package com.leetcode_3th.tree;

import java.util.Stack;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * 
 * @author Zealot
 * @date Jul 29, 2019 9:07:19 AM
 *
 */
public class FlattenBinaryTreetoLinkedList {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public void flatten(TreeNode root) {
		if(root!=null) {
			dfs(root);
		}
	}
	public void dfs(TreeNode root) {
		if(root.left!=null) {
			if(root.right!=null) {
				stack.push(root.right);	
			}
			root.right = root.left;
			root.left=null;
			dfs(root.right);
		}
		
		if(root.right!=null){
			dfs(root.right);
		}
		if(stack.size()>0) {
			root.right=stack.pop();
			dfs(root.right);
		}
	}
}
