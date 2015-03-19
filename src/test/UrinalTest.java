package test;

import main.Urinal;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UrinalTest {

    @Test
    public void isOccupied_IsFalseByDefault() {
        Urinal urinal = new Urinal();
        assertThat(urinal.isOccupied(), is(false));
    }

    @Test
    public void isOccupied_WhenTheUrinalIsOccupiedIsTrue() {
        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        assertThat(urinal.isOccupied(), is(true));
    }

    @Test
    public void isOccupied_WhenTheUrinalIsNoLongerOccupiedIsFalse() {
        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        urinal.setIsOccupied(false);

        assertThat(urinal.isOccupied(), is(false));
    }
}