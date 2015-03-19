package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by doancea on 3/18/15.
 */
public class Bathroom extends ArrayList<Urinal> {

    public int determineOptimalUrinal() {
        int positions = this.size();
        for(int position = positions; position > 0; position--) {
            if(!this.get(position -1).isOccupied()) {
                return position;
            }
        }
        return 0;
    }
}
