package MyObserverPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class WeatherStation2 implements Observer, Display {
    WeatherData weatherData;
    float temperature;
    float humidity;
    float pressure;

    public WeatherStation2(WeatherData data){
        this.weatherData = data;
        data.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Weather Station2:");
        System.out.println("Temperature: " + temperature + " C\n" +
                "Humidity: " + humidity +"%\n" +
                "Pressure: " + pressure + " Pa\n");
    }

    @Override
    public void update() {
        temperature = weatherData.getTemperature();
        humidity = weatherData.getHumidity();
        pressure = weatherData.getPressure();
        display();
    }
}
