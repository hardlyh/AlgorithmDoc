package linkedlist;

import dto.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 *
 */
public class printLinkedList {

    ArrayList<Integer> arr = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        print(head);

        int[] result = new int[arr.size()];


        for(int i =0;i<arr.size();i++){
            result[i] = arr.get(i);
        }

        return result;
    }


    public void print(ListNode head){
        if(head == null){
            return;
        }
        print(head.next);
        arr.add(head.val);
    }



}
