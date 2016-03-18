package MyObserverPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
