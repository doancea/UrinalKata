package main;

import java.util.ArrayList;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        if(!urinals.isEmpty()) {
            return 0;
        }

        return -1;
    }
}
