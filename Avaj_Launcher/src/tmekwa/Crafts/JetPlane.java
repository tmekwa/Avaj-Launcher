package tmekwa.Crafts;

import tmekwa.Interface.Flyable;
import tmekwa.Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void     updateConditions()
    {
        String temp = "JetPlane#" + this._name + "(" + this._id + ") :";
        String writerToFile = "";
        String writerToFileUnregister = "";
        String weatherTemp = _weatherTower.getWeather(this._coordinates);


        switch (weatherTemp) {
            case "RAIN":
                _coordinates = new Coordinates(_coordinates.getLongitude(), (_coordinates.getLatitude() + 5), _coordinates.getHeight());
                writerToFile = temp + " It's raining. Better watch out for lightings.\n";
                break;
            case "SUN":
                _coordinates = new Coordinates(_coordinates.getLongitude(), (_coordinates.getLatitude() + 10), (_coordinates.getHeight() + 2));
                writerToFile = temp + "Some sun light, lets take some pictures\n";
                break;
            case "FOG":
                _coordinates = new Coordinates(_coordinates.getLongitude(), (_coordinates.getLatitude() + 1), _coordinates.getHeight());
                writerToFile = temp + " I cant see anything!\n";
                break;
            case "SNOW":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), (_coordinates.getHeight() - 7));
                writerToFile = temp + " Its snowing out here.\n";
                break;
        }

        _weatherTower.writeToFile("write", writerToFile);

        if (this._coordinates.getHeight() <= 0)
        {
            writerToFileUnregister = "Tower says: JetPlane#" + this._name + "(" + this._id + ") unregistered from weather tower.\n";
            _weatherTower.writeToFile("write", writerToFileUnregister);
            _weatherTower.unregister(this);
        }
//
    }
    public void     registerTower(WeatherTower weatherTower) {

        weatherTower.register(this);
        String writeTo = "Tower says: JetPlane#" + this._name + "(" + this._id + ") registered to weather tower.\n";
        this._weatherTower = weatherTower;
        _weatherTower.writeToFile("write", writeTo);

    }
}
