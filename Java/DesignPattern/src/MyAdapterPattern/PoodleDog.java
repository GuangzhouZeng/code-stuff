package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class PoodleDog implements Dog {
    @Override
    public void bark() {
        System.out.println("Wang! Wang! Wang!");
    }

    @Override
    public void run() {
        System.out.println("I am running now!");
    }
}
