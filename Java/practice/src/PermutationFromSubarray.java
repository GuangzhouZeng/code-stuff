/**
 * Created by guangzhouzeng on 2/8/16.
 */
/*
给一个数组，平均分成 k 份，从 k 个子数组中每个抽一个数出来，输出所有可能的排列
 */
import java.util.*;
public class PermutationFromSubarray {
    public static List<List<Integer>> permutation(int[] arr, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(arr, k, 0, cur, res);
        return res;
    }
    // n elements, k partitions, each partition has n/k elements
    private static void helper(int[] arr, int k, int step,  List<Integer> cur, List<List<Integer>> res){
        if(step == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        int num = (int)Math.ceil((double)arr.length / k); // number of each partitions;
        for(int i = 0; i < num; i++){
            int index = step * num + i;
            if(index < arr.length) {
                cur.add(arr[index]);
                helper(arr, k, step + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private static void printList(List<List<Integer>> lists){
        for(List<Integer> list: lists){
            for(Integer num: list){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int k = 3;
        printList(permutation(arr, k));
    }
}
