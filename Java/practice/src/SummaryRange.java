/**
 * Created by guangzhouzeng on 2/26/16.
 */
/*
例子 {1，3，5，6，10，14}
要输出 “1-5/2 , 6-14/4”
 */
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

    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6, 10, 14};
        System.out.println(range(nums));
    }
}
