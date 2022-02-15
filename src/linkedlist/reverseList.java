package linkedlist;

import dto.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 *tip:
 *  1. 循环的时候首先要将curr.next存储下来, 否则的话在curr指向pre的之后就取不到后面的节点
 *  2. 依次循环,注意开头两个变量使用
 *  3. 最后要将头结点的next置位null
 */
public class reverseList {


    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        head.next = null;
        return pre;
    }
}
