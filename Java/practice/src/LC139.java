/**
 * Created by guangzhouzeng on 2/4/16.
 */

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.*;
public class LC139 {
    public static boolean solution(String str, Set<String> words){
        boolean[] dp = new boolean[str.length()+1];
        dp[0] = true;
        for(int i = 0; i < str.length(); i++){
            if(dp[i] == true) {
                for (int j = i + 1; j <= str.length(); j++) {
                    dp[j] = dp[j] || words.contains(str.substring(i, j));
                }
            }
        }
        return dp[str.length()];
    }

    public static boolean solution2(String str, Set<String> words){
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j < i; j++){
                dp[i] = dp[i] || (dp[j] && words.contains(str.substring(j, i)));
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args){
        Set<String> words =  new HashSet<>();
        words.add("leet");
        words.add("code");
        String str = "leetcode";

        System.out.println(solution(str, words));
        System.out.println(solution2(str, words));
    }
}

