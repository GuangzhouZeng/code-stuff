/**
 * Created by guangzhouzeng on 2/5/16.
 */

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
import java.util.HashMap;
public class LC159 {
    public static int solution(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int lo = 0, hi = 0;
        while(hi < str.length()){
            if(map.size() <= 2){
                map.put(str.charAt(hi), hi);
                hi ++;
            }
            if(map.size() > 2){
                char key = ' ';
                int val = str.length();
                for(char curKey: map.keySet()){
                    int curVal = map.get(curKey);
                    if(curVal < val){
                        val = curVal;
                        key = curKey;
                    }
                }
                lo = val + 1;
                map.remove(key);
            }
            res = Math.max(res, hi - lo);

        }

        return res;
    }

    public static int solution2(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int low = -1;
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(map.size() <= 2){
                map.put(str.charAt(i), i);
            }
            if(map.size() > 2){
                int curVal = i;
                char curKey = ' ';
                for(char key: map.keySet()){
                    if(map.get(key) < curVal){
                        curVal = map.get(key);
                        curKey = key;
                    }
                }
                low = curVal;
                map.remove(curKey);
            }
            res = Math.max(res, i - low);
        }
        return res;
    }

    public static void main(String[] args){
        String[] strs = {"acacbacacac",
                        "asdavdsfafe",
                        "adefwrfdsfs",
                        "asdefsdf",
                        "",
                        "a",
                        "ac",
                        "asdiefwonksdfnibfwjbfkdsfrhnwbvdjsbvfieuhvbfjfksbvajkhfuehfwijbfjkdsbforubfijsbjvksbvbirwebv"};
        for(String str: strs) {
            System.out.println(solution(str) + " " + solution2(str));
        }
    }


}
