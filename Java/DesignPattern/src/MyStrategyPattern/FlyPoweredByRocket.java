package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class FlyPoweredByRocket implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can fly powered by rocket!");
    }
}
