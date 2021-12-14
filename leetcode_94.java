package leetcode;

import java.util.*;

public class leetcode_94 {

}
class lee_94{
    /**
     * 中序遍历 use a non-recursive approach
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque  = new LinkedList<>();
        while(root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
class lee_94_2{
    /**
     * use a recursive approach
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}