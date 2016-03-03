import PrintOut.PrintArray;

/**
 * Created by guangzhouzeng on 2/29/16.
 */
public class ReverseWordsInString {
    public static void reverseWords1(char[] chars){
        //the length of the string is n, average word's length is k
        reverseString(chars, 0, chars.length - 1); //O(n) time
        int start = 0;
        for(int i = 0; i <= chars.length; i++){//O(n)
            if(i == chars.length || chars[i] == ' '){
                reverseString(chars, start, i - 1);//O(k)
                start = i + 1;
            }
        }
    }
    //assume each word's length is k
    //every k character need to reverse once.
    //there are totally n/k word
    //time spend on reverse is O(n/k * k) = O(n)
    //so it is O(n) time complexity
    //in place.
    //problem here is several space between two words.


    public static void reverseString(char[] chars, int l, int r){
        while(l < r){
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }

    public static String reverseWords2(String str){
        String[] words = str.split(" +");
        reverse(words);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            res.append(i == words.length - 1 ? words[i] : words[i] + " ");
        }
        return res.toString();
    }

    public static void reverse(String[] words){
        int l = 0, r = words.length - 1;
        while(l < r){
            String temp = words[l];
            words[l++] = words[r];
            words[r--] = temp;
        }
    }

    public static void main(String[] args){
        String str = "Hello !my name is Guangzhou Zeng";
        System.out.println(reverseWords2(str));
        char[] chars = str.toCharArray();

        reverseWords1(chars);
        PrintArray.printArrayChar(chars);

    }
}
