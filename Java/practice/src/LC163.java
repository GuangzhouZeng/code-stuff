import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/4/16.
 */
/*
Problem: Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class LC163 {
    public static List<String> solution(int[] vals, int start, int end){
        List<String> res = new LinkedList<>();
        for(int val: vals){
            if(start < val) {
                res.add(getString(start, val - 1));
            }
            start = val + 1;
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
