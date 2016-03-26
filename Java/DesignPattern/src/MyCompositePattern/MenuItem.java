package MyCompositePattern;

/**
 * Created by guangzhouzeng on 3/25/16.
 */
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public boolean isVegetarian(){
        return vegetarian;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public void print(){
        System.out.print(getName());
        if(isVegetarian()){
            System.out.print("(v)");
        }
        System.out.println(", $" + getPrice());
        System.out.println("\t-- " + getDescription());
    }
}
