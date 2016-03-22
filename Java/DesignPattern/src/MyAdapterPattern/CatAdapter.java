package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class CatAdapter implements Dog {
    private Cat cat;
    public CatAdapter(Cat cat){
        this.cat = cat;
    }
    @Override
    public void bark() {
        System.out.println("I am a Cat, but I am treated as a dog.");
        cat.meow();
    }

    @Override
    public void run() {
        System.out.println("I am a Cat, but I am treated as a dog.");
        cat.run();
    }
}
