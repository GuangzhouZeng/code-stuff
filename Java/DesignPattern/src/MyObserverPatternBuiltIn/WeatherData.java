package MyObserverPatternBuiltIn;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
import java.util.Observable;
public class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float pressure;

    public void setData(float temp, float humi, float pres){
        this.temperature = temp;
        this.humidity = humi;
        this.pressure = pres;
        dataChanged();
    }

    public void dataChanged(){
        setChanged(); //built in method
        notifyObservers(); //built in method; then we just implement the update(obs, arg) method in observer.
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
