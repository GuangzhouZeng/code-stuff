package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Soy extends Condiment {
    Beverage beverage;
    public Soy(Beverage bvg){
        beverage = bvg;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.00;
    }
}
