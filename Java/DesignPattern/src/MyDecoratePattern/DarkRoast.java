package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}
