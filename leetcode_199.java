package leetcode;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class leetcode_199 {
}
/*
广度优先遍历：BFS\
Queue 中 add() 和 offer()都是用来向队列添加一个元素。
在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
我们对树进行深度优先搜索，在搜索过程中，我们总是先访问右子树。那么对于每一层来说，我们在这层见到的第一个结点一定是最右边的结点。
 */
class lee_199{
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        List<Integer> res =new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(i == size-1){
                    res.add(node.val);
                }
            }

        }
        return res;
    }
}
