package leetcode;

import javax.xml.bind.annotation.XmlAnyAttribute;

/*
设计循环队列，一个时使用数组，一个是使用链表
MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。

 */
public class leetcode_622 {
}

class MyCircularQueue {
    public int[] a;
    public int maxlen;
    public int head;
    public int tail;
    public int len;
    public MyCircularQueue(int k) {
        a =new int[k];
        this.maxlen = k;
        len = 0;
    }

    public boolean enQueue(int value) {
        if(maxlen<=len)
            return false;
        a[tail++] =value;
        tail = tail%maxlen;//这里循环关键
        len++;
        return true;
    }

    public boolean deQueue() {//从头出
        if(len == 0)
            return false;
        head = (head+1)%maxlen;
        len--;
        return true;
    }

    public int Front() {
        if(len ==0)
            return -1;
        return a[head];
    }

    public int Rear() {
        if(len ==0)
            return -1;
        return a[(tail-1+maxlen)%maxlen];
    }

    public boolean isEmpty() {
        if(len ==0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(len == maxlen)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
