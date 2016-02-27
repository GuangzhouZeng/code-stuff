/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
"search for jobs"
n=3 return null;
n=6 or 7 return search
n=13, return search for
 */
public class ReturnCompleteString {
    public static String completeString(String str, int n){
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        if(n > str.length()) return str;

        for(int i = 0; i < n && i < str.length() - 1; i++){
            if(str.charAt(i + 1) == ' '){
                temp.append(str.charAt(i));
                res.append(temp);
                temp = new StringBuilder();
            }else{
                temp.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args){
        String str = "search for jobs";
        System.out.println(completeString(str, 3));
        System.out.println(completeString(str, 6));
        System.out.println(completeString(str, 7));
        System.out.println(completeString(str, 13));
        System.out.println(completeString(str, 16));
    }
}
