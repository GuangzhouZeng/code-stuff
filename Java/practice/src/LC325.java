/**
 * Created by guangzhouzeng on 2/2/16.
 */

import java.util.HashMap;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?
 */

public class LC325 {
    public static int solution(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>(); //(sum, index)
        map.put(0,-1);
        int sum = 0;
        int res = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)){
                res = Math.max(res, i - map.get(sum - k));
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {5, 1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(solution(arr, k));
    }
}
