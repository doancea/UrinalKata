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
            if(position > 2) {
                position--;
            } else if(position == 1 + (positions % 2)) {
                return 0;
            } else {
                position = positions;
            }
        }
        return 0;
    }
}
