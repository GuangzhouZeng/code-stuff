/**
 * Created by guangzhouzeng on 3/6/16.
 */
import PrintOut.PrintArray;

import java.util.HashSet;
public class ReverseVowel{
    public static HashSet<Character> vowel;
    static {
        vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
    }
    public static void reverseVowel(char[] chars){
        int p1 = 0, p2 = chars.length - 1;
        while(p1 < p2){
            while(p1 < p2 && !vowel.contains(chars[p1])){
                p1++;
            }
            while(p1 < p2 && !vowel.contains(chars[p2])){
                p2--;
            }
            if(p1 < p2 && vowel.contains(chars[p1]) && vowel.contains(chars[p2])) swap(chars, p1, p2);
            p1++;p2--;
        }
    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] agrs){
        String str = "I love google";
        char[] chars = str.toCharArray();
        reverseVowel(chars);
        PrintArray.printArrayChar(chars);
    }
}
