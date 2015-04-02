package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doancea on 4/1/15.
 */
public class Person {

    public int chooseUrinal(ArrayList<Urinal> urinals) {
        HashMap<Integer, Urinal> availableUrinals = getAvailableUrinals(urinals);

        HashMap<Integer, Urinal> availableUrinalsWithBothNeighborsAvailable = getUrinalsWithBothNeighborsAvailable(urinals, availableUrinals);

        if(!availableUrinalsWithBothNeighborsAvailable.isEmpty()) {
            availableUrinals = availableUrinalsWithBothNeighborsAvailable;
        } else {
            HashMap<Integer, Urinal> availableUrinalsWithOneNeighborAvailable = getUrinalsWithOneNeighborAvailable(urinals, availableUrinals);

            if(!availableUrinalsWithOneNeighborAvailable.isEmpty()) {
                availableUrinals = availableUrinalsWithOneNeighborAvailable;
            }
        }

        int highestIndex = selectFurthestUrinal(availableUrinals);

        return highestIndex;
    }

    private int selectFurthestUrinal(HashMap<Integer, Urinal> availableUrinals) {
        int highestIndex = -1;
        if(!availableUrinals.isEmpty()) {
            for(Integer index : availableUrinals.keySet()) {
                highestIndex = index > highestIndex ? index : highestIndex;
            }
        }
        return highestIndex;
    }

    private HashMap<Integer, Urinal> getUrinalsWithBothNeighborsAvailable(ArrayList<Urinal> urinals, HashMap<Integer, Urinal> availableUrinals) {
        HashMap<Integer, Urinal> nonAdjacentUnavailableUrinals = new HashMap<Integer, Urinal>();

        for(Map.Entry<Integer, Urinal > urinalPosition : availableUrinals.entrySet()) {
            int index = urinalPosition.getKey();

            if(isFurtherNeighborAvailable(urinals, index) && isCloserNeighborAvailable(urinals, index)) {
                nonAdjacentUnavailableUrinals.put(index, urinalPosition.getValue());
            }
        }
        return nonAdjacentUnavailableUrinals;
    }

    private HashMap<Integer, Urinal> getUrinalsWithOneNeighborAvailable(ArrayList<Urinal> urinals, HashMap<Integer, Urinal> availableUrinals) {
        HashMap<Integer, Urinal> nonAdjacentUnavailableUrinals = new HashMap<Integer, Urinal>();

        for(Map.Entry<Integer, Urinal > urinalPosition : availableUrinals.entrySet()) {
            int index = urinalPosition.getKey();

            if(isFurtherNeighborAvailable(urinals, index) || isCloserNeighborAvailable(urinals, index)) {
                nonAdjacentUnavailableUrinals.put(index, urinalPosition.getValue());
            }
        }
        return nonAdjacentUnavailableUrinals;
    }

    private boolean isFurtherNeighborAvailable(ArrayList<Urinal> urinals, int index) {
        return (index == urinals.size() - 1) || (urinals.get(index + 1).isAvailable());
    }

    private boolean isCloserNeighborAvailable(ArrayList<Urinal> urinals, int index) {
        return (index == 0) || (urinals.get(index - 1).isAvailable());
    }

    private HashMap<Integer, Urinal> getAvailableUrinals(ArrayList<Urinal> urinals) {
        HashMap<Integer, Urinal> availableUrinals = new HashMap<Integer, Urinal>();

        for(int i = 0; i < urinals.size(); i++) {
            Urinal urinal = urinals.get(i);
            if(urinal.isAvailable()) {
                availableUrinals.put(i, urinal);
            }
        }
        return availableUrinals;
    }
}
