import java.util.Arrays;

/**
 * Created by guangzhouzeng on 2/6/16.
 */
/*
Problem:

Given an array of n integers nums and a target, find the number of index triplets i, j, k
with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n^2) runtime?
* */
public class LC259 {
    public static int solution(int[] num, int target){
        Arrays.sort(num);

        int res = 0;
        for(int i = 0; i < num.length; i++){
            int j = i + 1, k = num.length - 1;
            while(j < k){
                int sum = num[i] + num[j] + num[k];
                if(target <= sum){
                    k--;
                }else{
                    res += (k - j);
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] num = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(solution(num, target));
    }
}

//-2, 0, 1, 3
/*
-2, 0, 3

*/