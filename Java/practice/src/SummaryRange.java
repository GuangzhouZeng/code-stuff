/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
例子 {1，3，5，6，10，14}
要输出 “1-5/2 , 6-14/4”
 */
import PrintOut.PrintList;

import java.util.*;
public class SummaryRange {
    public static String range(int[] nums){
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while(end < nums.length){
            int curGap = 0;
            if(end != nums.length - 1){
                curGap = nums[end + 1] - nums[end];
                while(end != nums.length - 1 && curGap == nums[end + 1] - nums[end]){
                    end++;
                }
            }
            sb.append(getString(nums, start, end, curGap));
            start = end + 1;
            end ++;
        }
        return sb.toString();
    }
    private static String getString(int[] nums, int start, int end, int gap){
        String sb = nums[start] + "-" + nums[end] + "/" +gap;
        return end == nums.length - 1 ? sb : sb + ", ";
    }



    /////////round2
    public static List<String> summary(int[] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1 || nums[i] + 1 != nums[i + 1]){
                res.add(nums[start] == nums[i] ? "" + nums[i] : nums[start] + "-" + nums[i]);
                start = i + 1;
            }
        }
        return res;
    }

    public static List<String> summaryWithDup(int[] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1 || (nums[i] + 1 != nums[i + 1] && nums[i] != nums[i + 1])){
                res.add(nums[start] == nums[i] ? "" + nums[i] : nums[start] + "-" + nums[i]);
                start = i + 1;
            }
        }
        return res;
    }

    public static ArrayList<String> summary2(int[] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        int start = 0, end = 0, gap = 0;
        while(end < nums.length){
            gap = end < nums.length - 1 ? nums[end + 1] - nums[end] : 0;
            while(end < nums.length - 1 && nums[end + 1] - nums[end] == gap){
                end++;
            }
            res.add("" + nums[start] + "-" + nums[end] + "/" + gap);
            end++;
            start = end;
        }
        return res;
    }



    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6, 10, 14, 15,15,15};
        System.out.println(range(nums));
        System.out.println();

        int[] nums1 = {1,2,3,3,3,3,3,3,4,5,6,7,9};
        PrintList.printListString(summary(nums1));
        PrintList.printListString(summaryWithDup(nums1));

        System.out.println(summary2(nums));
    }
}
