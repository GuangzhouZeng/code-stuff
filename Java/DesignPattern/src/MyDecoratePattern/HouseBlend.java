package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "HouseBlend";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
