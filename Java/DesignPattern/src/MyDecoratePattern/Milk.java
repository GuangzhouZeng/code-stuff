package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Milk extends Condiment{
    Beverage beverage;
    public Milk(Beverage bvg){
        beverage = bvg;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.50;
    }
}
