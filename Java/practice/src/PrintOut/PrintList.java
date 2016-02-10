package PrintOut;

import java.util.List;

/**
 * Created by guangzhouzeng on 2/9/16.
 */
public class PrintList {
    public static void printListInt(List<Integer> list){
        for(int num: list){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printListString(List<String> list){
        for(String str: list){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void printArrayInt(int[] arr){
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArrayInt(Integer[] arr){
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
