package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class QuackReal implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("Quack! Quack!");
    }

}
