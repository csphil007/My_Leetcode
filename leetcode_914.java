package leetcode;
/*
给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
每组都有X张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回true。

 */
public class leetcode_914 {
    public static void main(String[] args){
        int deck[]={1,1,2,2,2,2};
    }

}

class lee_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1)
            return false;
        int[] res = new int[10000];
        for (int i : deck) {
            res[i]++;
        }
        int x = 0;
        for (int cnt : res) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }


    private int gcd(int a,int b){
        return b ==0? a:gcd( b,a%b);
    }




}
