package leetcode;

import java.util.Stack;

/*
用栈实现队列的操作
仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 */
public class leetcode_232 {

}
class MyQueue {
    private Stack<Integer> a;//输入栈
    private Stack<Integer> b;//输出栈
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        if(b.empty()) {
            while(!a.isEmpty()){
                b.push(a.pop());
            }}
        return b.pop();
    }

    public int peek() {
        if(b.empty()) {
            while(!a.isEmpty()){
                b.push(a.pop());
            }}
        return b.peek();
    }

    public boolean empty() {
        return a.empty() && b.empty();
    }
}