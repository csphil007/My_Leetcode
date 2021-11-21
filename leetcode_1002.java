package leetcode;
import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
示例 1：
输入：words = ["bella","label","roller"] 输出：["e","l","l"] 示例 2：
输入：words = ["cool","lock","cook"] 输出：["c","o"]
提示：
1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] 由小写英文字母组成
 */

public class leetcode_1002 {
    public static void main(String[] args){

    }
}
/*
先选出一个，得出结果，然后把结果带后续进行比较
 */
class lee_1002{
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int length = words.length;
        if(length == 0)
            return result;
        int[] hash =new int[26];
        for(int i = 0; i<words[0].length(); i++){//
            //char[] chars = words[i].toCharArray();
            hash[words[0].charAt(i)-'a']++;
        }
        for(int i= 1;i<length; i ++){
            int[] hash_two = new int[26];
            for(int  j = 0;j<words[i].length(); j++){
                hash_two[words[i].charAt(j)-'a']++;
            }
            for(int k = 0; k < 26; k++){
                hash[k] = Math.min(hash[k], hash_two[k]);
            }
        }
        for(int i = 0; i < 26; i ++){
            while(hash[i] != 0){//注意这里不能用if 要用while
                char c = (char)(i + 'a');
                result.add(String.valueOf(c));
                hash[i]--;//chongfu 给眼见
            }
        }
        return result;
    }
}
