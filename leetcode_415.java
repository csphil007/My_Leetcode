package leetcode;

public class leetcode_415 {
    public static void main(String[] args) {
        lee415 l = new lee415();
        String nums1 ="123";
        String nums2 = "12";
        l.addStrings(nums1, nums2);
    }
}
/*
字符串相加
给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。

你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。

 */
class lee415{
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        String res ="";
        int i = len1-1;
        int j = len2 -1;
        while (i>=0 && j>=0){
            int a = Integer.valueOf(num1.charAt(i)-'0');
            int b = Integer.valueOf(num2.charAt(j)-'0');
            a= a+b+carry;
            i --;
            j--;
            if(a>=10) {
                a = a - 10;
                carry = 1;
            }else {carry =0;}
            res = String.valueOf(a)+ res;
        }
        if(len1 == len2 && carry == 0){
            return res;
        }
        if(len1 == len2 && carry ==1){
            res = "1"+res;
            return res;
        }
        if(len1>len2){
            i = len1 -len2-1;
            while(i>=0){
                int a = Integer.valueOf(num1.charAt(i)-'0');
                a =a+carry;
                i --;
                if(a>=10){
                    a= a-10;
                    carry =1;
                }else {carry =0;}
                res = String.valueOf(a)+res;
            }
        }
        if(len1<len2){
            i = len2 -len1-1;
            while(i>=0){
                int a = Integer.valueOf(num2.charAt(i)-'0');
                a= a+carry;
                i --;
                if(a>=10){
                    a= a-10;
                    carry =1;
                }else {carry =0;}
                res = String.valueOf(a)+res;
            }
        }
        if(carry ==0)
            return res;
        return "1"+res;
    }


    /**
     * 方法一可以改进
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString(); 
    }
}