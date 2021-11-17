package leetcode;
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class leetcode_206 {
    public static void main(String[] args){

    }
}
/*
思路：首先可以使用双指针方法，定义两个指针
 */
class lee_206{
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//current前一个
        ListNode cur = head;
        ListNode temp = null;//current后一个
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
/*
思路除了使用双指针方法，还可以使用递归递归法相对抽象一些，但是其实和双指针法是一样的逻辑，同样是当cur为空的时候循环结束，不断将cur指向pre的过程。

关键是初始化的地方，可能有的同学会不理解， 可以看到双指针法中初始化 cur = head，pre = NULL，在递归法中可以从如下代码看出初始化的逻辑也是一样的，只不过写法变了。

具体可以看代码（已经详细注释），双指针法写出来之后，理解如下递归写法就不难了，代码逻辑都是一样的。
 */
class lee_206_2{
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if (head.next == null) return head;
        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
}