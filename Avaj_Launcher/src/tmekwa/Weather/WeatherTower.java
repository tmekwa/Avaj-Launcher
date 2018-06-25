package tmekwa.Weather;

import tmekwa.Crafts.Coordinates;
import tmekwa.Tower.Tower;

public class WeatherTower extends Tower
{
    //WeatherProvider weatherProvider = new WeatherProvider();
    public String getWeather(Coordinates coordinates)
    {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}
