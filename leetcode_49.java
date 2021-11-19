package leetcode;

import java.util.*;

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。

 */
public class leetcode_49 {
    public static void main(String[] args){

    }
}

/*
此种方法结构比较复杂，需要理解一下
 */
class lee_49{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);//字符排序
            String keys = String.valueOf(chars);//字符串组合
            if(!map.containsKey(keys)){
                map.put(keys,new ArrayList<String>());
            }
            map.get(keys).add(str);

        }
        return new ArrayList(map.values());
    }
}
/*

 */

class lee_49_2{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return Collections.emptyList();
        Map<String, List> map = new HashMap<String,List>();
        int [] count = new  int[26];//统计26个字母出现的次数
        for(String str : strs){
            Arrays.fill(count, 0);//数组填0
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }
            String s = String.valueOf(count);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(str);



        }
        return new ArrayList(map.values());
    }
}