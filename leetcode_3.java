package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class leetcode_3 {
    public static void main(String[] args)
    {
        lee3 l = new lee3();
        int res = l.lengthOfLongestSubstring("aab");
        System.out.println("11111");
    }
}
class lee3 {
    /**
     * 找出不含重复项的字串
     * 使用左右指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        if (s.length() == 0)
            return 0;
        if(s.length() ==1)
            return 1;
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            Character c = new Character(s.charAt(right));
            if (!list.contains(c)) {
                list.add(c);
                right++;
            } else {
                res = Math.max(res, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    Character c1 = new Character(s.charAt(left));
                    list.remove(c1);
                    left++;
                }
                list.remove(c);
                list.add(c);
                right++;
                left++;
            }
        }
        res = Math.max(list.size(),res);

        return res;

    }

    public int lengthOfLongestSubstring_2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}