/**
 * Created by guangzhouzeng on 2/2/16.
 */
/**Problem Description:

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding", word2 = "practice", return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class LC243 {
    public static int solution(String[] words, String word1, String word2){
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            List<Integer> temp;
            if(map.containsKey(word)){
                temp = map.get(word);
            }else{
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(word, temp);
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;

        for(Integer i: l1){
            for(Integer j: l2){
                res = Math.min(res, Math.abs(i-j));
            }
        }

        return res;
    }

    public static int solution2(String[] words, String word1, String word2){
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(word.equals(word1)){
                p1  = i;
            }
            if(word.equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1){
                res = Math.min(Math.abs(p1 - p2), res);
            }
        }
        return res;
    }

    public static void main(String[] args){
        String[] words = {"practice", "makes", "perfect", "coding", "makes", "word","practice"};
        String word1 = "perfect";
        String word2 = "practice";
        System.out.println(solution(words, word1, word2));
        System.out.println(solution2(words, word1, word2));
    }
}
