/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
e.g. "1234&euro;" => "&euro;4321"
"1234&euro" => "orue&4321"
"1234&euro;567" => "765&euro;4321"
 */
import PrintOut.PrintArray;

import java.util.*;
public class ReverseStringWithEntity {
    ////////////round1
    public static String reverse(String str){
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isInEntity = false;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '&'){
                isInEntity = true;
                temp.reverse();
                res.insert(0, temp);
                temp = new StringBuilder();
                temp.append('&');
            }else if(isInEntity && str.charAt(i) == ';'){
                isInEntity = false;
                temp.append(';');
                res.insert(0, temp);
                temp = new StringBuilder();
            }else {
                temp.append(str.charAt(i));
            }
        }
        temp.reverse();
        res.insert(0, temp);
        return res.toString();
    }

    ////////////round2
    public static String reverseEntity(String str){
        LinkedList<StringBuilder> list = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '&'){
                temp.reverse();
                list.add(0, temp);
                flag = true;
                temp = new StringBuilder();
                temp.append(str.charAt(i));
            }else if(flag && str.charAt(i) == ';'){
                temp.append(str.charAt(i));
                list.add(0, temp);
                flag = false;
                temp = new StringBuilder();
            }else{
                temp.append(str.charAt(i));
            }
        }
        temp.reverse();
        list.add(0, temp);

        StringBuilder res = new StringBuilder();
        for(StringBuilder s: list){
            res.append(s);
        }
        return res.toString();
    }

    ////////////round3
    public static char[] reverseInPlace(char[] chars){
        int start = -1;
        boolean isInEntity = false;

        reverseChars(chars, 0, chars.length - 1);
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == ';'){
                start = i;
                isInEntity = true;
            }
            if(isInEntity && c == '&'){
                reverseChars(chars, start, i);
                isInEntity = false;
            }
        }
        return chars;
    }

    public static void reverseChars(char[] s, int i, int j){
        while(i < j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    ////////////round4
    public static void reverseEntity(char[] chars){
        reverseString(chars, 0, chars.length - 1);
        boolean isEntity = false;
        int start = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ';'){
                isEntity = true;
                start = i;
            }
            if(isEntity && chars[i] == '&'){
                reverseString(chars, start, i);
                isEntity = false;
            }
        }
    }
    public static void reverseString(char[] chars, int l, int r){
        while(l < r){
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }

    public static void main(String[] args){
        String str1 = "1234&euro;123";
        String str2 = "1234&euro567";
        String str3 = "1234&eu;ro;567;";
        String str4 = "12&34&eu;ro;567";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] chars3 = str3.toCharArray();
        char[] chars4 = str4.toCharArray();


        System.out.println(reverse(str1));
        System.out.println(reverse(str2));
        System.out.println(reverse(str3));
        System.out.println(reverse(str4));

        System.out.println();

        System.out.println(reverseEntity(str1));
        System.out.println(reverseEntity(str2));
        System.out.println(reverseEntity(str3));
        System.out.println(reverseEntity(str4));

        System.out.println();

        System.out.println(reverseInPlace(chars1));
        System.out.println(reverseInPlace(chars2));
        System.out.println(reverseInPlace(chars3));
        System.out.println(reverseInPlace(chars4));



        System.out.println();

        char[] chars5 = str1.toCharArray();
        char[] chars6 = str2.toCharArray();
        char[] chars7 = str3.toCharArray();
        char[] chars8 = str4.toCharArray();

        reverseEntity(chars5);
        reverseEntity(chars6);
        reverseEntity(chars7);
        reverseEntity(chars8);

        PrintArray.printArrayChar(chars5);
        PrintArray.printArrayChar(chars6);
        PrintArray.printArrayChar(chars7);
        PrintArray.printArrayChar(chars8);


    }
}


/*
abc&123;def

fde;321&cba

fde&123;cba

fed&123;cba

 */