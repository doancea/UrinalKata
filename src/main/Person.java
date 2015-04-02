package main;

import java.util.ArrayList;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        ArrayList<Urinal> availableUrinals = new ArrayList<Urinal>();

        for(int i = 0; i < urinals.size(); i++) {
            Urinal urinal = urinals.get(i);
            if(urinal.isAvailable()) {
                availableUrinals.add(i, urinal);
            }
        }

        if(!availableUrinals.isEmpty()) {
            return availableUrinals.size() - 1;
        }

        return -1;
    }
}
