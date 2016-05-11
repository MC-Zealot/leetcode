package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;
/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Zealot
 * @date 2016年5月11日 下午5:55:48 
 *
 */
public class MergekSortedLists {
	/**
	 * TIME:O(nk^2)
	 * SPACE:O(1)
	 * @date 2016年5月11日 下午6:17:15
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		for(int i = 0; i < lists.length; i++){
			dummy = mergeTwoLists(dummy, lists[i]);
		}
		return dummy.next;
    }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        return dummy.next;
	}
}
