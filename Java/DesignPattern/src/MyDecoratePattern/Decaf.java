package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Decaf extends Beverage {

    public Decaf(){
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 2.25;
    }
}
