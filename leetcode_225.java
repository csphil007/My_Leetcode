package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
使用队列完成栈得操作,
思路：设置两个队列，一个空队列完成入栈操作，在入弯栈以后将宁一个队列（出栈队列）得元素依次放入入栈队列，再将入栈和出战队列交换
 */
public class leetcode_225 {
}
class MyStack{
    public Queue<Integer> que1;
    public Queue<Integer> que2;
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public void push(int x) {
        que1.offer(x);
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        Queue<Integer> temp= que1;
        que1 = que2;
        que2 = temp;
    }

    public int pop() {
        return que2.poll();

    }

    public int top() {
        return que2.peek();
    }

    public boolean empty() {
        return que2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

