/**
 * Created by guangzhouzeng on 2/2/16.
 */

/**
 * Problem Description:

 Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 Hint:

 Consider the palindromes of odd vs even length. What difference do you notice?
 Count the frequency of each character.
 If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class LC266 {
    public static boolean solution(String str){
        int odd = 0;
        int[] map = new int[256];
        for(char c: str.toCharArray()){
            map[c]++;
            odd += (map[c] & 1) == 0 ? -1 : 1;
        }
        return odd <= 1 ? true : false;
    }

    public static void main(String[] args){
        String str = "abcabcabccba";
        System.out.println(solution(str));
    }
}
