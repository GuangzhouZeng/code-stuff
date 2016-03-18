package MyObserverPattern;

/**
 * Created by guangzhouzeng on 3/18/16.
 */
public class Test {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        WeatherStation1 ws1 = new WeatherStation1(weatherData);
        WeatherStation2 ws2 = new WeatherStation2(weatherData);

        System.out.println("----------1st Set Data: ----------");
        weatherData.setData(25, 80, 15);

        System.out.println("----------2nd Set Data: ----------");
        weatherData.setData(30, 70, 25);

        System.out.println("----------3rd Set Data: ----------");
        weatherData.setData(20, 50, 5);
    }
}
