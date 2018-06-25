package tmekwa.Weather;

import tmekwa.Crafts.Coordinates;

import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider _weatherProvider = null;
    private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        if (_weatherProvider == null)
            _weatherProvider = new WeatherProvider();
        return _weatherProvider;
    }

    //______________Getters_____________//

    public String getCurrentWeather(Coordinates coordinates)
    {
        int randomGenerator = new Random().nextInt(weather.length);
        String randomWeather = (weather[randomGenerator]);

        return randomWeather;
    }
}
