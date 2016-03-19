package MySingletonClass.Synchronized;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Singleton {
    String description;
    private Singleton(String desc){
        description = desc;
    }

    private static Singleton uniqueInstance;

    public static synchronized Singleton getInstance(String desc){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton(desc);
        }
        return uniqueInstance;
    }

    public String getDescription(){
        return description;
    }


}
