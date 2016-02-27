/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
e.g. "1234&euro;" => "&euro;4321"
"1234&euro" => "orue&4321"
"1234&euro;567" => "765&euro;4321"
 */
public class ReverseString {
    public static String reverse(String str){
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '&'){
                temp.reverse();
                res.insert(0, temp);
                temp = new StringBuilder();
                temp.append('&');
            }else if(str.charAt(i) == ';'){
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

    public static void main(String[] args){
        String str1 = "1234&euro;123";
        String str2 = "1234&euro567";
        String str3 = "1234&euro;567";

        System.out.println(reverse(str1));
        System.out.println(reverse(str2));
        System.out.println(reverse(str3));
    }
}
