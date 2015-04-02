package main;

import java.util.ArrayList;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        ArrayList<Urinal> availableUrinals = getAvailableUrinals(urinals);

        ArrayList<Urinal> nonAdjacentUnavailableUrinals = getUrinalsWithAvailableNeighbor(urinals, availableUrinals);

        if(!nonAdjacentUnavailableUrinals.isEmpty()) {
            availableUrinals = nonAdjacentUnavailableUrinals;
        }

        if(!availableUrinals.isEmpty()) {
            return availableUrinals.size() - 1;
        }

        return -1;
    }

    private ArrayList<Urinal> getUrinalsWithAvailableNeighbor(ArrayList<Urinal> urinals, ArrayList<Urinal> availableUrinals) {
        ArrayList<Urinal> nonAdjacentUnavailableUrinals = new ArrayList<Urinal>();

        for(Urinal urinal : availableUrinals) {
            int index = urinals.indexOf(urinal);

            if(isFurtherNeighborOccupied(urinals, index)) {
                nonAdjacentUnavailableUrinals.add(urinal);
            }
        }
        return nonAdjacentUnavailableUrinals;
    }

    private boolean isFurtherNeighborOccupied(ArrayList<Urinal> urinals, int index) {
        return (index == urinals.size() - 1) || (urinals.get(index + 1).isAvailable());
    }

    private ArrayList<Urinal> getAvailableUrinals(ArrayList<Urinal> urinals) {
        ArrayList<Urinal> availableUrinals = new ArrayList<Urinal>();

        for(int i = 0; i < urinals.size(); i++) {
            Urinal urinal = urinals.get(i);
            if(urinal.isAvailable()) {
                availableUrinals.add(i, urinal);
            }
        }
        return availableUrinals;
    }
}
