package MyCompositePattern;

/**
 * Created by guangzhouzeng on 3/25/16.
 */
import java.util.ArrayList;
public class Menu extends MenuComponent{
    private String name;
    private String description;
    private ArrayList<MenuComponent> menuComponents;

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
        menuComponents = new ArrayList<>();
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
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent){
        menuComponent.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i){
        return menuComponents.get(i);
    }

    @Override
    public void print(){
        System.out.print("\n" + name + ", ");
        System.out.println(description);
        System.out.println("-----------------------");

        for(MenuComponent menuComponent: menuComponents){
            menuComponent.print();
        }
    }

}
