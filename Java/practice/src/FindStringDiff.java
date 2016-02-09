import java.util.HashMap;

/**
 * Created by guangzhouzeng on 2/8/16.
 */
public class FindStringDiff {
    public static char findDiffChar(String s1, String s2){
        int idx1 = 0, idx2 = 0;
        char c1 = ' ', c2 = ' ';
        while(idx1 < s1.length() || idx2 < s2.length()){
            c1 = idx1 < s1.length() ? s1.charAt(idx1++) : ' ';
            c2 = idx2 < s2.length() ? s2.charAt(idx2++) : ' ';
            if(c1 != c2) break;
        }
        return s1.length() > s2.length() ? c1 : c2;
    }

    public static char findDiffHash(String s1, String s2){
        if(s1.length() > s2.length()) return findDiffHash(s2, s1); //make sure s2 is longer than s1
        int[] map = new int[256];
        for(int i = 0; i < s1.length(); i++){
            map[s1.charAt(i)]++;
            map[s2.charAt(i)]--;
            if(map[s2.charAt(i)] < 0) return s2.charAt(i);
        }
        return s2.charAt(s2.length() - 1);
    }

    public static char findDiffNoDup(String s1, String s2){
        int s1Num = 0, s2Num = 0;
        for(int i = 0; i < s1.length() || i < s2.length(); i++){
            if(i < s1.length()) {
                s1Num |= 1 << (s1.charAt(i) - 'a');
            }
            if(i < s2.length()) {
                s2Num |= 1 << (s2.charAt(i) - 'a');
            }
        }
        return (char)('a' + (int)(Math.log(s1Num ^ s2Num)/Math.log(2)));
    }

    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "abc";

        System.out.println(findDiffChar(s1, s2));
        System.out.println(findDiffHash(s1, s2));
        System.out.println(findDiffNoDup(s1, s2));
    }
}
