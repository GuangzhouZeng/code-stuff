package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class DuckModel extends Duck {
    public DuckModel(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new QuackNoWay();
    }

    @Override
    public void display() {
        System.out.println("I am a Model duck");
    }


}
