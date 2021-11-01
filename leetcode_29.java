
public class leetcode_29 {
    public static void main(String[] args){
        T_29 t = new T_29();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(t.divide(dividend,divisor));
    }

}


class T_29{
    public int divide(int dividend, int divisor) {
        double result =0;
        double abs_dividend= (double)dividend, abs_divisor= (double)divisor;
        if(dividend<0)
            abs_dividend = abs_dividend-abs_dividend-abs_dividend;
        if(divisor<0)
            abs_divisor =abs_divisor-abs_divisor-abs_divisor;
        int temp =0;
        //System.out.println(abs_dividend+","+abs_divisor);
        if(dividend>=0&&divisor>0 || dividend<0 && divisor<0)
            temp = 1;//1 is zhengshu
        while(abs_dividend>=0){
            abs_dividend -= abs_divisor;
            if(abs_dividend>=0)
                result+=1;
        }
        System.out.println(result);
        if(temp ==1)
            return (int)result;
        else
            return (int)(result-result-result);
    }
}