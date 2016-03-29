/**
 * Created by guangzhouzeng on 3/6/16.
 */
import PrintOut.PrintArray;

import java.util.*;
public class wiggleSort {
    //O(nlogn) time
    public static void sort1(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i+=2){
            swap(nums, i, i + 1);
        }
    }

    //method2 O(n) time and O(1) space
    public static void sort2(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if((i & 1) == 1){
                if(nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            }else{
                if(nums[i] > nums[i - 1]) swap(nums, i, i - 1);
            }
        }
    }


    public static void swap(int[] nums, int i, int j){
        if(j >= nums.length) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums1 = {4,5,6,8,0,9,4,3,2,1,2,4};
        int[] nums2 = {4,5,6,8,0,9,4,3,2,1,2,4};
        sort1(nums1);
        PrintArray.printArrayInt(nums1);

        sort2(nums2);
        PrintArray.printArrayInt(nums2);
    }
}
//1,2,3,4,5,6,7
//2,1,4,3,6,5,7

//arr: 2,3,4,5,1,0,8,7,6
//idx: 0,1,2,3,4,5,6,7,8
//     3,2,5,1,4,0,8,6,7
