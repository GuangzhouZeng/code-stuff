package MySingletonClass.Synchronized;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class SingletonTest {
    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance("S1");
        System.out.println(s1.getDescription());
        Singleton s2 = Singleton.getInstance("S2");
        System.out.println(s2.getDescription());
        System.out.println(s1.getDescription());
    }
}
