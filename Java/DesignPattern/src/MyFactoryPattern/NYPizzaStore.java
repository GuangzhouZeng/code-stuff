package MyFactoryPattern;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("pizza1")){
            pizza = new NYPizza1();
        }else if(type.equals("pizza2")){
            pizza = new NYPizza2();
        }
        return pizza;
    }
}
