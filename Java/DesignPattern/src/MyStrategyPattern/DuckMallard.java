package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class DuckMallard extends Duck{

    public DuckMallard(){
        flyBehavior = new FlyReal();
        quackBehavior = new QuackReal();
    }

    @Override
    public void display() {
        System.out.println("I am a Mallard Duck");
    }
}
