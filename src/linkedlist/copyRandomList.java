package linkedlist;

import dto.Node;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Random;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * tip:
 *  1.使用HashMap, 第一次将所有的节点都存储下来,第二次变量根据原节点key来取对应的新节点  Map<原节点,新节点></原节点,新节点>
 *  2.拼接链表的形式
 *      首先将链表拼接为 1 -> new 1 -> 2 -> new2
 *      第二步为random处理,  new 1节点的random 就是 1 节点的random的next
 *      判断的条件应该是以方法处理中用到最深长度来判断,否则会出现空指针
 *      拆链表的时候注意判空
 *
 */
public class copyRandomList {

    HashMap<Node,Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }

        // 拼接链表
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }

        // 拼接Random
        temp = head;
        while(temp != null){
            Node newNode = temp.next;
            Node random = temp.random;
            if(random != null){
                newNode.random = random.next;
            }else{
                newNode.random = null;
            }

            temp = newNode.next;
        }

        // 拆分链表
        temp = head;
        Node res  = temp.next;
        while(temp != null){
            Node newNode = temp.next;
            temp.next = newNode.next;
            temp = newNode.next;

            if(temp != null){
                newNode.next = temp.next;
            }
        }

        return res;
    }



    public Node copyRandomList1(Node head) {
        if (head == null){
            return null;
        }

        // 构建map
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp = temp.next;
        }

        // 遍历 根据Map组件新的列表
        temp = head;
        while(temp != null){
            Node next = temp.next;
            Node random = temp.random;

            Node newNext = next == null?null:map.get(next);
            Node newRandom = random == null?null: map.get(random);

            Node newNode = map.get(temp);
            newNode.next = newNext;
            newNode.random  = newRandom;
            temp = temp.next;
        }

        return map.get(head);
    }
}
