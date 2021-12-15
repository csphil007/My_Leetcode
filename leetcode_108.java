package leetcode;
/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
 */
public class leetcode_108 {
}
class lee_108{
    /**
     * 将有序数组转换为二叉搜索树
     * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。
     * 给定二叉搜索树的中序遍历，是否可以唯一地确定二叉搜索树？答案是否定的。如果没有要求二叉搜索树的高度平衡，则任何一个数字都可以作为二叉搜索树的根节点，因此可能的二叉搜索树有多个。
     *我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 11，
     * 可以使得树保持平衡。如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，
     * 则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点，
     * 选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
     * 方法1：选择中序遍历，选择中间节点作为根节点
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int left, int right) {
        if(left>right)
            return null;
        int mid = (left+right)/2;
        TreeNode node =new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid-1);
        node.right = helper(nums, mid+1,right);
        return node;
    }
}

class lee_108_2{
    /**
     * 方法2：总是选择中间位置右边的数字作为根节点
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right +1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
