package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 4.00;
    }
}
