import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/8/16.
 * Check if all integers in the list can be grouped into 5 consecutive number. For example [1,2,2,3,3,4,4,5,5,6]
 * should return True because it can be grouped into (1,2,3,4,5)(2,3,4,5,6) with no other elements left.
 */
public class GroupNumber {
    private static boolean groupNumbers(int[] arr){
        if(arr.length % 5 != 0) return false;

        List<Integer> list = new LinkedList<>();
        for(int num: arr){
            list.add(num);
        }

        while(!list.isEmpty()){
            int count = 5;
            Integer cur = list.get(0);
            while(count -- > 0){
                if(!list.remove(cur)) return false;
                cur+=1;
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,3,3,4,4,5,5,6,7,8,9,10,11};
        System.out.println(groupNumbers(arr));
    }
}
