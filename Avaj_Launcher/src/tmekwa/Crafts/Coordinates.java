package tmekwa.Crafts;

public class Coordinates
{
    private int     _longitude;
    private int     _latitude;
    private int     _height;

    Coordinates(int longitude, int latitude, int height)
    {
        if (height > 100)
            this._height = 100;
        else if (height < 0)
            this._height = 0;
        else
            this._height = height;

        if (latitude < 0)
            latitude = 0;

        if (longitude < 0)
            longitude = 0;

        this._longitude = longitude;
        this._latitude = latitude;
        return;
    }

    /*________ Getters________*/

    public int      getLongitude()
    {
        return this._longitude;
    }

    public int     getLatitude()
    {
        return this._latitude;
    }

    public int     getHeight()
    {
        return this._height;
    }
}
