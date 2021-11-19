package leetcode;
import java.util.*;
/*
给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 */
public class leetcode_438 {

}
/*
方法一：太复杂，不建议使用
 */
class lee_438{
    public List<Integer> findAnagrams(String s, String p) {
        int length = p.length();
        //int[] count = new int[26];
        //for(int i = 0;i<length; i++){
         //   count[p.charAt(i)-'a']++;
        //}
        char[] p_c = p.toCharArray();
        Arrays.sort(p_c);
        p = String.valueOf(p_c);
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<=s.length()-length; i++){
            String str  = s.substring(i,i+length);
            char[] str_c = str.toCharArray();
            Arrays.sort(str_c);
            str = String.valueOf(str_c);
            if(p.equals(str)){
                result.add(i);
            }
        }
        return result;
    }
}
/*
方法2
 */
class SolutionFor438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[(int) (c - 'a')]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (hash[(int) (s.charAt(right++) - 'a')]-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return result;
    }
}