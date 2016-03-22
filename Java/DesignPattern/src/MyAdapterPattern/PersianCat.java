package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class PersianCat implements Cat {
    @Override
    public void meow() {
        System.out.println("Miao! Miao! Miao!");
    }

    @Override
    public void run() {
        System.out.println("I am running now!");
    }
}
