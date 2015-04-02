package main;

import java.util.ArrayList;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        for(Urinal urinal : urinals) {
            if(!urinal.isOccupied()) {
                return urinals.indexOf(urinal);
            }
        }

        return -1;
    }
}
