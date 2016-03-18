package MyObserverPatternBuiltIn;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
import java.util.Observer;
import java.util.Observable;
public class WeatherStation1 implements Observer,Display {
    float temperature;
    float humidity;
    float pressure;
    Observable observable;
    public WeatherStation1(Observable obs){
        observable = obs;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display(){
        System.out.println("builtin Weather Station1:");
        System.out.println("Temperature: " + temperature + " C\n" +
                "Humidity: " + humidity +"%\n" +
                "Pressure: " + pressure + " Pa\n");
    }
}
