/**
 * Created by guangzhouzeng on 2/9/16.
 */
import java.util.*;
import PrintOut.PrintArray;
public class CutNumbers {
    static int cutNumbers(int cuts, Integer[] nums){
        Arrays.sort(nums, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                if(i1 % 10 == 0 && i2 % 10 == 0){
                    return i1 - i2;
                }else if(i1 % 10 == 0){
                    return -1;
                }else if(i2 % 10 == 0){
                    return 1;
                }else return i1 - i2;
            }
        });

        PrintArray.printArrayInt(nums);

        int idx = 0;
        int res = 0;
        while(cuts > 0 && idx < nums.length){
            int curNum = nums[idx];
            int curCut;
            int realCut;
            if(curNum != 0 && curNum % 10 == 0) {
                curCut = curNum / 10 - 1;
                realCut = Math.min(cuts, curCut);
                res += cuts >= curCut ? realCut + 1 : realCut;
                cuts -= realCut;
            }else{
                curCut = curNum / 10;
                realCut = Math.min(cuts, curCut);
                res += realCut;
                cuts -= realCut;
            }
            idx++;
        }
        return res;
    }
    public static void main(String[] args){
        Integer[] nums = {10, 0, 7,8,3,19, 20, 39, 30, 98, 83};
        System.out.println(cutNumbers(1, nums));
    }
}


/*
num     cuts    10s     ratio
0-9     0       0       0
10      0       1       0
11-19   1       1       1
20      1       2       1/2
21-29   2       2       1
30      2       3       2/3
 */