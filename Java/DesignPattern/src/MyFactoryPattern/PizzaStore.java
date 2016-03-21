package MyFactoryPattern;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
public abstract class PizzaStore {
    public abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);

        if(pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }else{
            System.out.println("Sorry! No such kind of pizza.");
        }

        return pizza;
    }

}
