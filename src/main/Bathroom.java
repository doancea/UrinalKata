package main;

import java.util.ArrayList;

/**
 * Created by doancea on 3/18/15.
 */
public class Bathroom extends ArrayList<Urinal> {

    public int determineOptimalUrinal() {
        for(Urinal urinal : this) {
            if(!urinal.isOccupied()) {
                return this.indexOf(urinal) + 1;
            }
        }
        return 0;
    }
}
