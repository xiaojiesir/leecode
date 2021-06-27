package array;

import dataStructure.ListNode;

/**
 * 两个非空链表相加,表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        int a = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int i = i1 + i2 + a;

            if (head == null) {
                result = head = new ListNode(i % 10);
            } else {
                head.next = new ListNode(i % 10);
                head = head.next;
            }
            a = i / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (a > 0) {
            head.next = new ListNode(a);
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode3 = new ListNode(2);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(3, listNode2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode5 = new ListNode(6, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        addTwoNumbers.addTwoNumbers(listNode1, listNode4);
    }
}
