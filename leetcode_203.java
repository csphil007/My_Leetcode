package leetcode;

class leetcode_203 {
    public static void main(String[] args){}

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
思路：最关键的就是选取头节点
 */
class lee_203{
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val==val)//初始化
        {
            ListNode pre=head;
            head=pre.next;
            pre.next=null;
        }
        if(head==null)//头节点为空
        {
            return null;
        }
        ListNode pre=head;
        while(pre.next!=null)
        {
            ListNode cur=pre.next;
            if(cur.val==val)//移除节点
            {
                pre.next=cur.next;
                cur.next=null;
            }
            else //指针后移
            {
                pre=pre.next;
            }
        }
        return head;
    }
}