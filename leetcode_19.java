package leetcode;
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
import java.security.PublicKey;

public class leetcode_19 {
    public  static void main(String[] args){

    }
}
/*
思路1：扫描一边，确定位置然后就可以确定,然后删除
 */
class lee_19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length =0;
        ListNode temp = head;
        while(temp!=null){//确当位置
            length++;
            temp = temp.next;
        }
        length = length - n;
        temp = head;
        if(length == 0){
            ListNode h  =head.next;
            head.next =null;
            return h;
        }
        ListNode temp1 = head;
        while(temp!=null){
            if(length == 1)
                temp1 = temp;
            if(length ==0){
                temp1.next = temp.next;
                temp.next  =null;
                break;
            }
            length --;
            temp = temp.next;
        }
        return head;
    }
}

/*
思路二：如何使用一次循环就直接删除节点呢
使用双指针,设置头节点，将一个指针移动n+1位置，两个指针同时移动，当前面的指针到达重点，后面的指针就可以进行操作了
头节点指向head，
 */
class lee_191{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        prev.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return dummy.next;
    }
}