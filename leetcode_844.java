package leetcode;

public class leetcode_844 {
    public static void main(String[] args){
        String s = "a##c", t = "#a#c";
        Comp c =new Comp();
        System.out.println(c.backspaceCompare(s,t));
    }
}
/*
思路1：针对两字符串做处理，得到最后结果，再比较用到string类的一些方法
 */
class Comp{
    public boolean backspaceCompare(String s, String t) {
        int length_s= s.length(), length_t = t.length();
        String s_r="", t_r="";
        for(int i =0;i<length_s;i++){
            if(s.charAt(i)== '#'&& s_r.length()>0){
                s_r=s_r.substring(0,s_r.length()-1);
            }
            else if(s.charAt(i)== '#'&& s_r.length()==0)
                s_r=s_r;
            else
                s_r+=s.charAt(i);
        }
        for(int i =0;i<length_t;i++){
            if(t.charAt(i)== '#'&& t_r.length()>0){
                t_r=t_r.substring(0,t_r.length()-1);
            }
            else if(t.charAt(i)== '#'&& t_r.length()==0)
                t_r=t_r;
            else
                t_r+=t.charAt(i);
        }

        return s_r.equals(t_r);
    }
}
