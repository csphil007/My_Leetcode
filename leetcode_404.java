package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
左右子树之和
 */
public class leetcode_404 {
}
class lee_404{
    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return zijiedian(root);

    }
    private int zijiedian(TreeNode node){
        int res = 0;
        if(node.left != null){
            TreeNode tleft = node.left;
            if(tleft.left == null && tleft.right == null){
                res+=tleft.val;
            }else {
                res += zijiedian(tleft);
            }
        }
        if(node.right != null){
            TreeNode treeNode = node.right;
            if(treeNode.left !=null || treeNode.right!= null)
                res += zijiedian(treeNode);

        }
        return res;


    }

}
class lee_404_2 {
    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.addFirst(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pollLast();
            if(node.left != null) {
                if (isLeafNode(node.left)) {
                    res += node.left.val;
                } else {
                    deque.addFirst(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    deque.addFirst(node.right);
                }
            }
        }
        return res;
    }
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}