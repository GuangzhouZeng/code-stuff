package MySingletonClass.Classic;


/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class SingletonTest {
    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance("I am S1");
        System.out.println(s1.getDescription());
        Singleton s2 = Singleton.getInstance("I am S2"); // here will fail to get 2nd instance
        System.out.println(s2.getDescription());
        System.out.println(s1.getDescription());
    }
}
