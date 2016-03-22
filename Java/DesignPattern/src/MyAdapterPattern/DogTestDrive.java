package MyAdapterPattern;

/**
 * Created by guangzhouzeng on 3/22/16.
 */
public class DogTestDrive {
    public static void main(String[] args){
        PoodleDog poodleDog = new PoodleDog();
        PersianCat persianCat = new PersianCat();
        Dog catAdapter = new CatAdapter(persianCat);

        System.out.println("persian cat's show time:");
        persianCat.meow();
        persianCat.run();

        System.out.println("\npoodle dog's show time:");
        show(poodleDog);

        System.out.println("\npersian cat's show time by using adapter:");
        show(catAdapter);
    }

    public static void show(Dog dog){
        dog.bark();
        dog.run();
    }
}
