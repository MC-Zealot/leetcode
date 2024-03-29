//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1208 👎 0


package oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
*   [25] reverse-nodes-in-k-group
*   2021-07-31 13:23:32
*/
public class P25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // TO TEST
    }
    //[25] reverse-nodes-in-k-group
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        List<Stack> list = new ArrayList<Stack>();
        Stack s = new Stack();
        int index = 0;
        while (head != null) {
            s.add(head.val);
            head = head.next;
            index++;
            if (index % k == 0 && s.size() > 0) {
                list.add(s);
                s = new Stack();
            }
        }
        if (s.size() > 0) {
            Stack lastStack = new Stack();
            while (s.size() > 0) {
                lastStack.add(s.pop());
            }
            list.add(lastStack);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < list.size(); i++) {
            Stack<Integer> ss = list.get(i);
            while (ss.size() > 0) {
                ListNode tmp = new ListNode(ss.pop());
                p.next = tmp;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}