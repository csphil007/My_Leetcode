package leetcode;

import java.util.*;

public class leetcode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return Collections.emptyList();
        }
        if(nums.length ==1){
            res.add(new ArrayList<>(Arrays.asList(nums[0])));
            return res;
        }
        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;

    }
    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i<len;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth+1, path, used,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }

}
