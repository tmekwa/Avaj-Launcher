package tmekwa.Interface;

import tmekwa.Weather.WeatherTower;

public interface Flyable
{
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}
