package Stock;
/**
 * Created by guangzhouzeng on 2/12/16.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Stock {
    class StockInfo{
        double price;
        long timestamp;
        StockInfo(double price, long timestamp){
            this.price = price;
            this.timestamp = timestamp;
        }
    }
    Queue<StockInfo> queue;
    double sum;

    public Stock(){
        queue = new LinkedList<StockInfo>();
    }

    public double getAverage(double price, long timestamp){
        final long MIN = 3600;

        queue.add(new StockInfo(price, timestamp));
        sum += price;

        while(!queue.isEmpty() && queue.peek().timestamp < timestamp - MIN){
            StockInfo temp = queue.poll();
            sum -= temp.price;
        }
        return sum / queue.size();
    }
}
