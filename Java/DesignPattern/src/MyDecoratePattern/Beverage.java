package MyDecoratePattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public abstract class Beverage {
    public String description = "unknown beverage";

    public String getDescription(){
        return description;
    }

    abstract public double cost();
}
