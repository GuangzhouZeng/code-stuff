/**
 * Created by guangzhouzeng on 2/13/16.
 */
import java.util.*;
public class FindDuplicatesInRange {
    public static boolean isExist(float[] nums, int k){
        HashSet<Float> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(i > k) set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args){
        float[] nums = {1.0000f, 2.03029f, 3.00223f, 2.030300f};
        System.out.println(isExist(nums, 3));
    }
}
