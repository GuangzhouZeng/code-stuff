package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class CatTestDrive {
    public static void main(String[] args){
        PoodleDog poodleDog = new PoodleDog();
        PersianCat persianCat = new PersianCat();
        Cat dogAdapter = new DogAdapter(poodleDog);

        System.out.println("Poodle dog's show time:");
        poodleDog.bark();
        poodleDog.run();

        System.out.println("\nPersian cat's show time:");
        show(persianCat);

        System.out.println("\nPoodle dog's show time with adapter");
        show(dogAdapter);
    }

    private static void show(Cat cat){
        cat.meow();
        cat.run();
    }
}
