package leetcode;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1: 输入: s = "anagram", t = "nagaram" 输出: true

示例 2: 输入: s = "rat", t = "car" 输出: false

说明: 你可以假设字符串只包含小写字母。
 */
public class leetcode_242 {
    public static void main(String[] args){

    }
}
/*
思路：使用hash算法

 */

class lee_242{
    public boolean isAnagram(String s, String t) {
        int[] code = new int[26];
        for(int i = 0;i<26;i++)
            code[i]=0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int ascii = (int) ch-97;
            code[ascii] +=1;
        }
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            int ascii = (int) ch-97;
            code[ascii] -=1;
        }
        for (int i = 0;i<26;i++){
            if(code[i]!=0)
                return false;
        }
        return true;
    }


    /*
   将代码进行改进，代码有许多可以改进的地方
     */
    public boolean isAnagram_2(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }
}