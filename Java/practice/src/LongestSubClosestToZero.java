import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/2/16.
 */

/**
 * /*
 Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 Example
 Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 Challenge
 O(nlogn) time
 Tags Expand
 Subarray Sort
 Thoughts:
 Took a me a while to think through how to find the closest sum to 0.
 Credits should be given to: http://rafal.io/posts/subsequence-closest-to-t.html
 */

/*class CustomComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}*/

public class LongestSubClosestToZero {
    public static List<Integer> solution(int[] arrs){
        int[][] pairs = new int[arrs.length][2];
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < arrs.length; i++){
            sum += arrs[i];
            pairs[i][0] = sum;
            pairs[i][1] = i;

        }

        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] pair1, int[] pair2){
                return pair1[0]-pair2[0];
            }
        });
        //Arrays.sort(pairs, new CustomComparator());

        int minVal = Integer.MAX_VALUE;
        int begin = 0, end = 0;
        for(int i = 0; i < pairs.length - 1; i++){
            int val = pairs[i+1][0] - pairs[i][0];
            if(val < minVal) {
                minVal = val;
                begin = pairs[i][1];
                end = pairs[i + 1][1];
            }
        }
        if(begin < end){
            res.add(begin+1);
            res.add(end);
        }else {
            res.add(end+1);
            res.add(begin);
        }
        return res;
    }

    private static void printListArray(List<Integer> nums){
        for(int num: nums){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args){
        int[] arrs = {-3, 1, 1, -3, 5};
        printListArray(solution(arrs));
    }
}
