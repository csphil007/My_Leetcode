package leetcode;

import com.sun.scenario.effect.Brightpass;

import java.util.Deque;
import java.util.LinkedList;

/*
求二叉树的高度
 */
public class leetcode_104 {
}
class lee_104 {
    public int maxDepth(TreeNode root) {
        if(root ==null)
            return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right)+1;
        }

    }

    /**
     * 使用bfs
     * @param root
     * @return
     */
    public int maxDepth_2(TreeNode root) {
        if(root ==null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        int hight = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size>0)
            {
                TreeNode node = deque.pollLast();
                if(node.left != null)
                    deque.addFirst(node.left);
                if(node.right != null)
                    deque.addFirst(node.right);
                size --;
            }
            hight++;
        }
        return hight;
    }
}