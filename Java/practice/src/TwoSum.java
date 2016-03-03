/**
 * Created by guangzhouzeng on 2/27/16.
 */
import PrintOut.PrintArray;

import java.util.*;
public class TwoSum {
    public static int[] twoSumNotSorted(int[] arrs, int target){
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int arr: arrs){
            if(set.contains(target - arr)){
                res[0] = target - arr;
                res[1] = arr;
                return res;
            }
            set.add(arr);
        }
        return res;
    }

    public static int[] twoSumSorted(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int[] res = new int[2];
        while(left < right){
            if(arr[left] + arr[right] == target){
                res[0] = arr[left];
                res[1] = arr[right];
                return res;
            }else if(arr[left] + arr[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    ////////round 2
    public static boolean twoSumUnsorted2(int[] nums, int target){
        if(nums == null || nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(target - num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public static boolean twoSumSorted2(int[] nums, int target){
        if(nums == null || nums.length < 2) return false;
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return true;
            }else if(nums[left] + nums[right] < target){
                left += 1;
            }else {
                right -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr1 = {4,3,1,7,6,9};
        int[] arr2 = {1,3,4,6,7,9};
        int target =9;

        PrintArray.printArrayInt(twoSumNotSorted(arr1, target));
        PrintArray.printArrayInt(twoSumSorted(arr2, target));

        System.out.println(twoSumUnsorted2(arr2, target));
        System.out.println(twoSumSorted2(arr2, target));
    }
}
