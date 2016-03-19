package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Whip extends Condiment {
    Beverage beverage;

    public Whip(Beverage bvg){
        beverage = bvg;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.30;
    }
}
