package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class DogAdapter implements Cat {
    private Dog dog;

    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void meow() {
        System.out.println("I am a dog, but I am treated as a cat");
        dog.bark();
    }

    @Override
    public void run() {
        System.out.println("I am a dog, but I am treated as a cat");
        dog.run();
    }
}
