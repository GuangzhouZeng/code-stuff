/**
 * Created by guangzhouzeng on 2/12/16.
 */
import java.util.*;
public class LongestPalindrome {
    private static String getPalindrome(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        StringBuilder res = new StringBuilder();
        char mid = ' ';
        for(char c: map.keySet()){
            while(map.get(c) >= 2){
                map.put(c, map.get(c) - 2);
                res.append(c);
                res.insert(0, c);
            }
            if(mid == ' ' && map.get(c) == 1) mid = c;
        }

        if(mid != ' ') res.insert(res.length() / 2, mid);
        return res.toString();
    }

    public static void main(String[] args){
        String str = "aaaabbbccc";
        System.out.println(getPalindrome(str));
    }
}
