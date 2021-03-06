package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * @author Zealot
 * @date 2016年6月24日 下午4:24:39 
 *
 */
public class BinarySearchTreeIterator {
	List<Integer> list = new ArrayList<Integer>();
    int index = 0;
	public BinarySearchTreeIterator(TreeNode root) {
		 midTraceTree(root);
    }
	public void midTraceTree(TreeNode root){
       if(root!=null){
          midTraceTree(root.left);
          list.add(root.val);
          midTraceTree(root.right);
       }
   }
	/** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(list.size()==0){
            return false;
        }
        
        return index==list.size()?false:true;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}
