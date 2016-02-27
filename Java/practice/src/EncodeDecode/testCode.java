package EncodeDecode;

import PrintOut.PrintArray;
import PrintOut.PrintList;

import java.util.*;
/**
 * Created by guangzhouzeng on 2/15/16.
 */
public class testCode {
    /*
&ae, a8, d#4e
3#&ae2#a84#4e
 */
    public static void main(String[] args){
        String[] strs = {"&ae","a8","d#4e"};
        String encode = EncodeDecodeString.encodeString(strs);
        System.out.println(encode);
        //List<String> decode = EncodeDecodeString.decodeString(encode);
        String[] decode = EncodeDecodeString.decodeString(encode);
        System.out.println(Arrays.deepEquals(decode, strs));

        //PrintList.printListString(decode);
        for(String str: decode){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
