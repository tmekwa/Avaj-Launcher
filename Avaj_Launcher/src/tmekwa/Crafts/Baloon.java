package tmekwa.Crafts;

import tmekwa.Interface.Flyable;
import tmekwa.Weather.WeatherTower;
import java.util.Random;

public class Baloon extends Aircraft implements Flyable
{
        private WeatherTower _weatherTower;

        Baloon(String name, Coordinates coordinates)
        {
            super(name, coordinates);
        }

        public void     updateConditions()
        {
            String weatherTemp = _weatherTower.getWeather(this._coordinates);
            String writerToFile = "";
            String writerToFileUnregister = "";
            String temp = "Baloon#" + this._name + "(" + this._id + ") :";

            switch (weatherTemp) {
                case "RAIN":
                    _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), (_coordinates.getHeight() - 5));
                    writerToFile = temp + " It's raining. Better watch out for lightings. (H -5)\n";
                    break;
                case "SUN":
                    _coordinates = new Coordinates((_coordinates.getLongitude() + 2), _coordinates.getLatitude(), (_coordinates.getHeight() + 4));
                    writerToFile = temp + "Some sun light, lets take some pictures. (Long +2 H +4)\n";
                    break;
                case "FOG":
                    _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), (_coordinates.getHeight() - 3));
                    writerToFile = temp + " I cant see anything! (H -3)\n";
                    break;
                case "SNOW":
                    _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), (_coordinates.getHeight() - 15));
                    writerToFile = temp + " Its snowing out here. (H -15)\n";
                    break;
            }
            _weatherTower.writeToFile("write", writerToFile);

            if (this._coordinates.getHeight() <= 0)
            {
                writerToFileUnregister =  "Tower says: Baloon#" + this._name + "(" + this._id + ") unregistered from weather tower.\n";
                _weatherTower.writeToFile("write", writerToFileUnregister);
                _weatherTower.unregister(this);
            }
        }
    public void     registerTower(WeatherTower weatherTower)
    {
        this._weatherTower = weatherTower;
        weatherTower.register(this);
        String writeTo = "Tower says: Baloon#" + this._name + "(" + this._id + ") registered to weather tower.\n";
        _weatherTower.writeToFile("write", writeTo);

    }
}
