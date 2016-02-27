package EncodeDecode;

/**
 * Created by guangzhouzeng on 2/15/16.
 */
import java.util.*;
public class EncodeDecodeString {
    public static String encodeString(String[] strs){
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(str.length() + "#" + str );
        }
        return res.toString();
    }


    public static String[] decodeString(String str){
        int start = 0;
        List<String> res = new ArrayList<>();
        while(str.length() != 0){
            int end = str.indexOf('#');
            System.out.println(end);
            int length = Integer.valueOf(str.substring(start, end));
            res.add(str.substring(end + 1, end + 1 + length));
            str = str.substring(end + 1 + length);
        }
        return res.toArray(new String[res.size()]);
        //return res;
    }
}
