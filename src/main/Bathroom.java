package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by doancea on 3/18/15.
 */
public class Bathroom extends ArrayList<Urinal> {

    public int determineOptimalUrinal() {
        int positions = this.size();

        boolean isEvenNumberUrinals = (positions % 2 == 0);
        int firstLoopMinimum = isEvenNumberUrinals ? 2 : 1;


        for(int position = positions; position > 0; position--) {
            if(!isUrinalOccupied(position - 1)) {
                return position;
            }
            if(position > 2) {
                position--;
            } else if(position == firstLoopMinimum) {
                if(isEvenNumberUrinals && !isUrinalOccupied(0)) {
                    return 1;
                }
                position = positions;
            } else {
                return 0;
            }
        }
        return 0;
    }

    private boolean isUrinalOccupied(int index) {
        return this.get(index).isOccupied();
    }
}
