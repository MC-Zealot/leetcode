package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Zealot
 * @date 2016年6月15日 下午3:28:47 
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode node = head;
		ListNode dummy = new ListNode(-1);
		dummy.next = node;
		node = node.next;
		while(node!=null){
			int val = node.val;
			ListNode pre = dummy.next;
			while(pre!=null){
				int node2Val = pre.val;
				if(val>node2Val){
					pre=pre.next;
				}else{
					 
				}
			}
		}
		
		return dummy.next;
    }
}
