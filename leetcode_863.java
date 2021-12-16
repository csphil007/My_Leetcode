package leetcode;

import java.util.*;

/*
二叉树中所有距离为 K 的结点
给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

 */
public class leetcode_863 {
}
class lee_863{
    /**
     * 深度优先搜索 + 哈希表
     * 若将target 当作树的根结点，我们就能从 target 出发，使用深度优先搜索去寻找与target 距离为 kk 的所有结点，即深度为 k 的所有结点。
     * 由于输入的二叉树没有记录父结点，为此，我们从根结点 root 出发，使用深度优先搜索遍历整棵树，同时用一个哈希表记录每个结点的父结点。
     * 然后从 target 出发，使用深度优先搜索遍历整棵树，除了搜索左右儿子外，还可以顺着父结点向上搜索。
     * 代码实现时，由于每个结点值都是唯一的，哈希表的键可以用结点值代替。此外，为避免在深度优先搜索时重复访问结点，
     * 递归时额外传入来源结点 from，在递归前比较目标结点是否与来源结点相同，不同的情况下才进行递归。
     * @param root
     * @param target
     * @param k
     * @return
     */
    Map<Integer,TreeNode> parents = new HashMap<Integer,TreeNode>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findAns(target, null,0, k);
        return res;
    }
    public void findParents(TreeNode root){
        if(root.left != null){
            parents.put(root.left.val,root);
            findParents(root.left);
        }
        if(root.right!= null){
            parents.put(root.right.val, root);
            findParents(root.right);
        }
    }
    public void findAns(TreeNode node, TreeNode from , int depth, int k){
        if(node == null)
            return;
        if(depth == k){
            res.add(node.val);
        }
        if(node.left != from){
            findAns(node.left,node,depth+1,k);
        }
        if(node.right !=from){
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }

    }

}