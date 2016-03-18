package MyStrategyPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class QuackNoWay implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("<< Silence >>");
    }
}
