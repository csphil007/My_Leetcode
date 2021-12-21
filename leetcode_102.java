package leetcode;

import com.sun.prism.shader.Texture_Color_AlphaTest_Loader;

import java.util.*;

public class leetcode_102 {
}
class Lee_102 {
    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null)
            return res;
        deque.addFirst(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> tem = new ArrayList<>();
            while(size>0){
                TreeNode node = deque.pollLast();
                tem.add(node.val);
                if(node.left!= null)
                    deque.addFirst(node.left);
                if(node.right != null)
                    deque.addFirst(node.right);
                size--;
            }
            res.add(tem);

        }
        return res;
    }
}