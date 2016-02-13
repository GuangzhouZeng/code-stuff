package Stock;

/**
 * Created by guangzhouzeng on 2/12/16.
 */

import java.util.*;

public class TestStock {
    public static void main(String[] args){
        Stock mystock = new Stock();

        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        while(price != 0.0){
            long curTime = new Date().getTime();
            System.out.println("price: "+ price + " time: " +curTime + " result: " +mystock.getAverage(price, curTime));
            price = sc.nextDouble();
        }

    }
}
