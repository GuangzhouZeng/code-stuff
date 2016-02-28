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

    public static void main(String[] args){
        int[] arr1 = {4,3,1,7,6,9};
        int[] arr2 = {1,3,4,6,7,9};
        int target =9;

        PrintArray.printArrayInt(twoSumNotSorted(arr1, target));
        PrintArray.printArrayInt(twoSumSorted(arr2, target));
    }
}
