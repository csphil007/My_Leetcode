package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class leetcode_230 {
}
/*
thinking:
first of all, 首先我们要明白二叉搜索树的性质，
结点的左子树只包含小于当前结点的数。
结点的右子树只包含大于当前结点的数。
所有左子树和右子树自身必须也是二叉搜索树。
使用中序遍历
 */
class lee_230{
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        while(!deque.isEmpty() || root!=null){
            while(root != null){
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.pollFirst();
            --k;
            if(k == 0)
                break;
            root  = root.right;
        }
        return root.val;
    }
}