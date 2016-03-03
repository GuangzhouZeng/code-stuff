package PrintOut;

/**
 * Created by guangzhouzeng on 2/10/16.
 */
public class PrintArray {
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

    public static void printArrayChar(char[] chars){
        for(char c: chars){
            System.out.print(c);
        }
        System.out.println();
    }

    public static void print2DArray(int[][] arrs){
        for(int[] arr: arrs){
            for(int num: arr){
                System.out.print(num + "\t");
            }
            System.out.println();
        }

    }
}
