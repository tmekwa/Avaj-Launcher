package tmekwa.Crafts;

import tmekwa.Interface.Flyable;

public class AircraftFactory
{
    public static Flyable  newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates _coordinates = new Coordinates(longitude, latitude, height);
        Helicopter  _helicopter;
        JetPlane    _jetPlane;
        Baloon      _baloon;

        switch (type)
        {
            case "Helicopter":
                _helicopter = new Helicopter(name, _coordinates);
                return _helicopter ;
            case "Baloon":
                _baloon = new Baloon(name, _coordinates);
                return _baloon ;
            case "JetPlane":
                _jetPlane = new JetPlane(name, _coordinates);
                return _jetPlane ;
            case "Jetplane":
                _jetPlane = new JetPlane(name, _coordinates);
                return _jetPlane ;
            default:
                return null;
        }
    }
}
