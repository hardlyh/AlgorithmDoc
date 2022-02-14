package stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 *
 *  tip: stack2用来存储当前队列中的最小值的队列,判断条件必须是<=, 这样pop取的时候才不会出问题
 *  2.  Integer 和Integer互相比较的问题要看清楚, 两个类型都是Integer时,则比较的是地址,不是值,需要用intValue转换后做比较
 *      Integer和int比较的时候会自动拆箱
 *       Integer == Integer false
 *       Integer == int true
 *       Integer.intValue == Integer true
 */
public class MinStack {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public MinStack() {
    }

    public void push(int x) {
        stack1.push(x);

        if(stack2.isEmpty()){
            stack2.push(x);
        }else{
            Integer peek = stack2.peek();
            if(peek >= x){
                stack2.push(x);
            }
        }
    }

    public void pop() {
        int pop = stack1.pop();
        Integer peek = stack2.peek();
        if(pop == peek){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
