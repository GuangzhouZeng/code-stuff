package MyFactoryPattern;

/**
 * Created by guangzhouzeng on 3/20/16.
 */
import java.util.ArrayList;
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println("Prepare pizza");
    }

    public void bake(){
        System.out.println("Bake pizza");
    }

    public void cut(){
        System.out.println("Cut pizza");
    }

    public void box(){
        System.out.println("Box pizza");
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Here is the pizza I get:-------\n");
        res.append(name + "\n");
        res.append(dough + "\n");
        res.append(sauce + "\n");
        for(String topping: toppings){
            res.append(topping + " ");
        }
        res.append("\n");
        return res.toString();
    }
}
