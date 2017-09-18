/**
 * Created by Emil on 2017-09-15.
 */
public class CustomerWeatherResearch implements WeatherSummary {
    private String currentWeather;

    public CustomerWeatherResearch(){

    }

    @Override
    public String currentWeatherSummary(double latitude, double longitude) {
        //todo: current weather download via coords blabla
        currentWeather = "12N, 2m/s";
        return this.currentWeather;
    }
}
