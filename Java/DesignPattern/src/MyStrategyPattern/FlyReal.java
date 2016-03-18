package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class FlyReal implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can fly!");
    }
}
