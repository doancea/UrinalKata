package main;

import java.util.ArrayList;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        ArrayList<Urinal> availableUrinals = new ArrayList<Urinal>();

        for(Urinal urinal : urinals) {
            if(urinal.isAvailable()) {
                availableUrinals.add(urinals.indexOf(urinal), urinal);
            }
        }

        if(!availableUrinals.isEmpty()) {
            return availableUrinals.size() - 1;
        }

        return -1;
    }
}
