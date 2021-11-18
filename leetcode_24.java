package leetcode;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class leetcode_24 {
    public static void main(String[] args){

    }
}
/*
思路：遍历进行两两交换，注意设置一个头节点，只想head节点
 */
class lee_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head_front = new ListNode(0);
        head_front.next = head;
        ListNode front = head_front;
        while(front.next!=null && front.next.next!=null){
            ListNode temp1 = front.next;
            ListNode temp2 = front.next.next;
            temp1.next = temp2.next;
            front.next = temp2;
            temp2.next = temp1;
            front = front.next.next;
        }
        return head_front.next;
    }
}
/*
使用递归，比较建议使用
 */
class lee_24_1{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tp = head.next;
        ListNode newcode = swapPairs(tp.next);
        tp.next = head;
        head.next = newcode;
        return tp;
    }
}
