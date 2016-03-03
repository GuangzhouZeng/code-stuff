/**
 * Created by guangzhouzeng on 3/1/16.
 */
public class ConvertExcel {
    public static String numberToTitle(int n){
        StringBuilder res = new StringBuilder();
        while(true){
            res.insert(0, (char)('A' + n % 26));
            n /= 26;
            if(n == 0) break;
            n -= 1;
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(numberToTitle(0));
        System.out.println(numberToTitle(1));
        System.out.println(numberToTitle(24));
        System.out.println(numberToTitle(25));

        System.out.println(numberToTitle(26));

        System.out.println(numberToTitle(52));
        System.out.println(numberToTitle(51));
        System.out.println(numberToTitle(11128));

    }
}
//0 -> A
//1 -> B
//25 -> Z
//26 -> AA
//51 -> AZ
//52 -> BA
/*
77 -> BZ
103 -> CZ
129 -> DZ
 */

/*
26 % 26 = 0; => A
26 / 26 = 1; => B - 1 => A


 */

//26 % 26 = 0;
//26 / 26 = 1;

