package MyFactoryPattern;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
public class OrderPizza {
    public static void main(String[] args){
        PizzaStore nystore = new NYPizzaStore();
        Pizza nyPizza1 = nystore.orderPizza("pizza1");
        System.out.println(nyPizza1);

        //System.out.println();

        PizzaStore laStore = new LAPizzaStore();
        Pizza laPizza1 = laStore.orderPizza("pizza2");
        System.out.println(laPizza1);


    }
}
