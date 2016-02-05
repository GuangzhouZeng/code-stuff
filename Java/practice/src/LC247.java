import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangzhouzeng on 2/4/16.
 */
public class LC247 {
    //0, 1, 6, 8, 9
    public static List<String> solution(int n){
        List<String> strobos;
        if((n & 1) == 0){
            strobos = Arrays.asList("");
        }
        else{
            strobos = Arrays.asList("0", "1", "8");
        }

        List<String> bases = Arrays.asList("00", "11", "69", "88", "96");

        while(n > 1) {
            n -= 2;
            List<String> temp = new LinkedList<>();
            for (String strobo : strobos) {
                for (String base : bases) {
                    temp.add(base.charAt(0) + strobo + base.charAt(1));
                }
            }
            strobos = temp;
        }
        return strobos;
    }
    private static void printList(List<String> lists){
        for(String str: lists){
            System.out.println(str);
        }
    }
    public static void main(String[] args){
        printList(solution(1));
    }
}
