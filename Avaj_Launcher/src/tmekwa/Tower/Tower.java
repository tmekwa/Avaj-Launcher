package tmekwa.Tower;

import tmekwa.Interface.Flyable;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Tower {

    //Attributes

    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unregistered = new ArrayList<>();
    private File                file;
    private FileWriter          writer;
    /*
    * Operators and Behaviours
    * */

    public void register(Flyable flyable)
    {
        if (observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {

        if (unregistered.contains(flyable))
            return ;
        unregistered.add(flyable);
    }

    public void conditionsChanged()
    {
        for (Flyable flyable: observers)
        {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }

    public void writeToFile(String _state, String _text) {
        try {
            this.file = new File("simulation.txt");
            this.writer = new FileWriter(file, true);
            this.file.createNewFile();

            switch (_state)
            {
                case "write":
                    try {
                        writer.write(_text);
                        writer.flush();
                    } catch (Exception exception) { System.out.println("Error could not write to file");}
                    break;
            }
        }catch (Exception e)
        {}
    }
}
