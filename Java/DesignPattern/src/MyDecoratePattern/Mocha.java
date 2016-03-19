package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Mocha extends Condiment {
    Beverage beverage;

    public Mocha(Beverage bvg){
        beverage = bvg;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.50;
    }
}
