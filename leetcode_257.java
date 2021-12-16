package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
25
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。
 */
public class leetcode_257 {

}

class lee_257{
    /**
     * 思路：使用深度优先搜索
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root, "", res);
        return res;
    }

    public void constructPaths(TreeNode root, String path, List<String> res) {
        if(root == null)
            return;
        StringBuffer p = new StringBuffer(path);
        p.append(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            res.add(p.toString());
        }else {
            p.append("->");
            constructPaths(root.left, p.toString(), res);
            constructPaths(root.right, p.toString(), res);
        }
    }

}
