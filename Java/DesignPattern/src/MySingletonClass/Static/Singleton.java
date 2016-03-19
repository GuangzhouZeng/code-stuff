package MySingletonClass.Static;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return uniqueInstance;
    }

    public String getDescription(){
        return "I am single instance";
    }

}
