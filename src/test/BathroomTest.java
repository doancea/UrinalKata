package test;

import main.Bathroom;
import main.Urinal;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BathroomTest {

    @Test
    public void determineOptimalUrinal_WhenThereIsNoAvailableUrinal_ReturnsPositionZero() {
        Bathroom bathroom = new Bathroom();
        assertThat(bathroom.determineOptimalUrinal(), equalTo(0));
    }

    @Test
    public void determineOptimalUrinal_WhenThereIsOneUrinalAndTheUrinalIsNotOccupied_ReturnsPositionOne() {
        Bathroom bathroom = new Bathroom();
        Urinal urinal = new Urinal();
        bathroom.add(urinal);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(1));
    }

    @Test
    public void determineOptimalUrinal_WhenThereIsOneUrinalAndTheUrinalIsOccupied_ReturnsPositionZero() {
        Bathroom bathroom = new Bathroom();
        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(0));
    }
}