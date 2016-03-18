package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Test {
    public static void main(String[] args){
        DuckMallard mallard = new DuckMallard();
        mallard.display();
        mallard.swim();
        mallard.performQuack();
        mallard.performFly();

        System.out.println();

        DuckModel model = new DuckModel();
        model.display();
        model.swim();
        model.performQuack();
        model.performFly();

        System.out.println();

        model.setFlyBehavior(new FlyPoweredByRocket());
        model.performFly();

    }
}
