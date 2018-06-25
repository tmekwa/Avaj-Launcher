package tmekwa.Crafts;


public class Aircraft
{
        protected long _id = 0L;
        protected String _name;
        protected Coordinates _coordinates;
        private static long _id_Counter = 0L;

        protected Aircraft(String name, Coordinates coordinates)
        {
            this._id = nextId();
            this._name = name;
            this._coordinates = coordinates;
        }

        protected Aircraft()
        {
            return;
        }
        private long nextId()
        {
            return (++this._id_Counter);
        }
}
