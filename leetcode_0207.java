package leetcode;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class leetcode_0207 {
    public static void main(String[] args){

    }
}
/*
思路：注意是指针相同节点，并不是val数值相同
首先我们可以想到遍历二重，但是时间复杂度太高
由于相同节点后面的共用一条链表，股可以及逆行长度匹配
 */
class lee_0207{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lengthA = 0, lengthB = 0;
        while(curA!=null)//获取ab的长度
        {
            lengthA++;
            curA = curA.next;
        }
        while(curB!=null)
        {
            lengthB++;
            curB = curB.next;
        }
        curA = headA;//寻找A，B的公告交点
        curB = headB;
        if(lengthA > lengthB){
            int gap = lengthA-lengthB;
            while(gap>0){
                curA = curA.next;
                gap--;
            }
        }
        else{
            int gap = lengthB - lengthA;
            while(gap>0){
                curB = curB.next;
                gap--;
            }
        }
        while(curA!=null){
            if(curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
