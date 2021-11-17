package leetcode;

import java.lang.management.LockInfo;

public class leetcode_707 {
    public static void main(String[] args){}

}

class MyLinkedList{
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if(index <0 || index>=size){
            return -1;
        }
        ListNode node = head;
        for(int i =0; i<=index;i++){
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        //头插法
        addAtIndex(0,val);

    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size)  return;
        if(index < 0) index = 0;

        size++;
        ListNode temp = head;
        for(int i = 0;i < index;i++) {
            temp = temp.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = temp.next;
        temp.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        size--;
        ListNode temp = head;
        for(int i = 0; i < index;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}