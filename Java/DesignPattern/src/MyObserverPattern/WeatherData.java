package MyObserverPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
import java.util.ArrayList;
public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Observer> observers;

    WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers){
            o.update();
        }
    }

    public void dataChanged(){
        notifyObservers();
    }

    public void setData(float temp, float humi, float pres){
        this.temperature = temp;
        this.humidity = humi;
        this.pressure = pres;
        dataChanged();
    }

    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    public float getPressure(){
        return pressure;
    }
}
