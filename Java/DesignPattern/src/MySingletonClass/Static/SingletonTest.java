package MySingletonClass.Static;


/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class SingletonTest {
    public static void main(String[] args){
        Singleton myInstance = Singleton.getInstance();
        System.out.println(myInstance.getDescription());
    }
}
