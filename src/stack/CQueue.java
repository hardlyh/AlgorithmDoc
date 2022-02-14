package stack;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  tip:
 *      1. LinkedList   pop 是出 push 是入
 *      2. 核心逻辑:
 *          append时,直接放入Stack1中,
 *          delete时,从stack2中取值,如果没有的话,则从stack1中pop放入,  这样stack2的数据就是先进先出的
 */
public class CQueue {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer val = stack1.pop();
                stack2.push(val);
            }
        }

        return stack2.pop();
    }
}
