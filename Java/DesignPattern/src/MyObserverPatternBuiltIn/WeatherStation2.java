package MyObserverPatternBuiltIn;


/**
 * Created by guangzhouzeng on 3/18/16.
 */
import java.util.Observable;
import java.util.Observer;
public class WeatherStation2 implements Observer, Display{
    float temperature;
    float humidity;
    float pressure;
    Observable observable;
    public WeatherStation2(Observable obs){
        observable = obs;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            temperature = weatherData.getTemperature();
            humidity = weatherData.getHumidity();
            pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display(){
        System.out.println("builtin Weather Station2:");
        System.out.println("Temperature: " + temperature + " C\n" +
                "Humidity: " + humidity +"%\n" +
                "Pressure: " + pressure + " Pa\n");
    }
}
