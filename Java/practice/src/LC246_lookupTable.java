/**
 * Created by guangzhouzeng on 2/2/16.
 */

/**
 * Problem Description:

 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class LC246_lookupTable {
    public static String table1 = "01689";
    public static String table2 = "01986";
    public static boolean isStrobogrammatic(String str){
        int len = str.length();
        for(int i = 0; i < len/2; i++){
            int p = table1.indexOf(str.charAt(i));
            int q = table2.indexOf(str.charAt(len - 1 - i));
            if( p == -1 || q == -1 ) return false;
            if( p != q) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String str = "11108696980111";
        System.out.println(isStrobogrammatic(str));
    }
}
