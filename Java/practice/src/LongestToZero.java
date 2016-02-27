import PrintOut.PrintArray;

import java.util.HashMap;
import java.util.Arrays;
/**
 * Created by guangzhouzeng on 2/16/16.
 */
public class LongestToZero {
    static int[] function(int[] nums){
        if(nums == null || nums.length == 0) return nums;
        int[] sums = new int[nums.length];
        //long[] sums = new long[nums.length];

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums[i] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i = 0; i < sums.length; i++){
            if(map.containsKey(sums[i]) || sums[i] == 0){ //
                int begin = sums[i] == 0 ? 0 : map.get(sums[i]);
                if(maxLen < i - begin){
                    maxLen = i - begin; //maxLen = 4
                    start = begin; // 0
                    end = i; // 4
                }
            }
            if(!map.containsKey(sums[i])){
                map.put(sums[i], i); //[4,0], //[12,1] // [15,2]//[8,3]//
            }
        }
        return Arrays.copyOfRange(nums, start + 1, end + 1);
    }
    public static void main(String[] args){
        int[] arr = {8, 3, 4, -7, 2, -2};
        int[] newarr = function(arr);
        //System.out.println(newarr[0]);
        PrintArray.printArrayInt(newarr);
    }
}


/*
map:
[4,0], [12, 1], [15, 2], [8, 3], [4, 4], [12, 5]

[]
[0]
[8, 3, 4, -7, 2, -2]
[8, 11, 15, 8 ,10, 8]


[4, 2, -6]
[4, 6, 0]

sums: [0]

[Integer.MAX_VALUE, Integer.MAX_VALUE]
[]
 */