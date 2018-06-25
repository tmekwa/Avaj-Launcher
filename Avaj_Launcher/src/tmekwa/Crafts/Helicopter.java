package tmekwa.Crafts;

import tmekwa.Interface.Flyable;
import tmekwa.Weather.WeatherTower;
import tmekwa.Tower.Tower;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower _weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void     updateConditions()
    {
        String temp = "Helicopter#" + this._name + "(" + this._id + ") :";
        String writerToFile = "";
        String writerToFileUnregister = "";
        String weatherTemp = _weatherTower.getWeather(this._coordinates);

        switch (weatherTemp) {
            case "RAIN":
                _coordinates = new Coordinates((_coordinates.getLongitude() + 5), _coordinates.getLatitude(), _coordinates.getHeight());
                writerToFile =  temp + " It's raining. Better watch out for lightings. (Long +5)\n";
                break;
            case "SUN":
                _coordinates = new Coordinates((_coordinates.getLongitude() + 10), _coordinates.getLatitude(), _coordinates.getHeight() + 2);
                writerToFile = temp + "Some sun light, lets take some pictures. (Long +10 H +2)\n";
                break;
            case "FOG":
                _coordinates = new Coordinates((_coordinates.getLongitude() + 1), _coordinates.getLatitude(), _coordinates.getHeight());
                writerToFile = temp + " I cant see anything! (Long +1)\n";
                break;
            case "SNOW":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), (_coordinates.getHeight() - 12));
                writerToFile =  temp + " Its snowing out here, going down . (H -12)\n";
                break;
        }

        _weatherTower.writeToFile("write", writerToFile);

        if (this._coordinates.getHeight() <= 0)
        {
            writerToFileUnregister = "Tower says: Helicopter#" + this._name + "(" + this._id + ") unregistered from weather tower.\n";
            _weatherTower.writeToFile("write", writerToFileUnregister);
            _weatherTower.unregister(this);
        }
    }
    public void     registerTower(WeatherTower weatherTower)
    {
        weatherTower.register(this);
        String writeTo = "Tower says: Helicopter#" + this._name + "(" + this._id + ") registered to weather tower.\n";
        this._weatherTower = weatherTower;
        _weatherTower.writeToFile("write", writeTo);

    }
}
