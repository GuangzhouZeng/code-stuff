package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
abstract public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }

    public void swim(){
        System.out.println("All ducks can swim!");
    }

    abstract public void display();
}
