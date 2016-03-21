package MyFactoryPattern;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
public class LAPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("pizza1")){
            pizza = new LAPizza1();
        }else if(type.equals("pizza2")){
            pizza = new LAPizza2();
        }
        return pizza;
    }
}
