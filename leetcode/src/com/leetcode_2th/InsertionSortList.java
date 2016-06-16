package com.leetcode_2th;

import java.util.Arrays;

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

		if (head == null) {
			return null;
		}
		ListNode node = head;
		ListNode dummy = new ListNode(-1);

		while (node != null) {
			int val = node.val;
			ListNode newNodePre = dummy;
			ListNode newNodeCur = newNodePre.next;
			if (newNodeCur == null) {
				ListNode tmp = new ListNode(node.val);
				newNodePre.next = tmp;
			} else {
				while (newNodeCur != null) {
					int newNodeVal = newNodeCur.val;
					if (val <= newNodeVal) {
						ListNode tmp = new ListNode(node.val);
						tmp.next = newNodePre.next;
						newNodePre.next = tmp;
						break;
					}
					newNodeCur = newNodeCur.next;
					newNodePre = newNodePre.next;
				}
				if(newNodeCur==null){
					ListNode tmp = new ListNode(val);
					newNodePre.next = tmp;
				}
			}
			node = node.next;
		}

		return dummy.next;
	}

	public ListNode insertionSortList2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;//先把原链表的下一个节点保存。
			pre = helper;
			while (pre.next != null && pre.next.val <= cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;//这样把当前节点拿出来放到返回链表当中时，就原链表就还有索引了
			pre.next = cur;
			cur = next;
		}
		return helper.next;
	}  
	public static void main(String[] args) {
//		InsertionSortList is = new InsertionSortList();
//		ListNode l1 = new ListNode(3);
//		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(2);
//		ListNode l4 = new ListNode(5);
//		ListNode l5 = new ListNode(4);
//		ListNode l6 = new ListNode(9);
//		ListNode l7 = new ListNode(6);
//		l1.next = l2;
//		l2.next =l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
//		ListNode l = is.insertionSortList(l1);
//		while(l!=null){
//			System.out.print(l.val+"\t");
//			l = l.next;
//		}
		/*Set<String> set = new HashSet<String>();
		set.add("count:1");
		set.add("count:aid1");
		set.add("count:isJoinEXO");
		set.add("count:4");
		set.add("count:aid4");
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		for(String str: list){
			System.out.println(str);
		}*/
		
	}
}
