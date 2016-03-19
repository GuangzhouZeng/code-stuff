package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class StarBucks {
    public static void main(String[] args){
        Beverage drink1 = new Espresso();
        drink1 = new Soy(drink1);
        drink1 = new Milk(drink1);
        drink1 = new Mocha(drink1);
        drink1 = new Whip(drink1);
        System.out.println("Description: " + drink1.getDescription() + "\nCost: " + drink1.cost());

    }
}
