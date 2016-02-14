/**
 * Created by guangzhouzeng on 2/2/16.
 */
/*Problem Description:

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a
move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
*/


import java.util.*;

public class LC293 {
    public static List<String> solution(String str){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1) && str.charAt(i) == '+'){
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                res.add(sb.toString());
            }
        }
        return res;
    }
    public static void printList(List<String> list){
        for(String str: list){
            System.out.println(str+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        String str = "++++";
        printList(solution(str));
    }
}
