import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/4/16.
 */
public class LC163 {
    public static List<String> solution(int[] vals, int start, int end){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < vals.length; i ++){
            if(start < vals[i]){
                res.add(getString(start, vals[i]-1));
            }
            start = vals[i] + 1;
        }
        if(start < end) {
            res.add(getString(start, end));
        }
        return res;
    }

    private static String getString(int start, int end){
        return start == end? String.valueOf(start) : start + "->" + end;
    }

    private static void printList(List<String> strs){
        for(String str: strs){
            System.out.print(str+", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] vals = {0,3,4,5, 50, 75,80};
        printList(solution(vals, 0, 79));
    }
}
