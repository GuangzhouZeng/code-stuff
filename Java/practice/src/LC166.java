import java.util.HashMap;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class LC166 {
    public static String getFraction(int numerator, int denominator){
        if(denominator == 0) return "";
        if(numerator == 0) return "0";

        StringBuilder res = new StringBuilder();

        res.append((numerator < 0) ^ (denominator < 0) ? "-" : "");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        long mod = num % den;
        num /= den;

        res.append(num);

        if(mod == 0){
            return res.toString();
        }
        res.append('.');

        HashMap<Long, Integer> map = new HashMap(); //<number, index>
        map.put(mod, res.length());
        while(mod != 0){
            mod *= 10;
            res.append(mod / den);
            mod %= den;
            if(map.containsKey(mod)){
                res.insert(map.get(mod), "(");
                res.append(")");
                break;
            }
            map.put(mod, res.length());
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(getFraction(1,6));
    }
}
/*
34 / 3 = 11 ... 1 => 1*10 = 10
10 / 3 = 3 ... 1


corner case: -1, Integer.MIN_VALUE
 */
