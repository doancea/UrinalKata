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

    @Test
    public void determineOptimalUrinal_WhenThereAreTwoUrinalsAndBothUrinalsAreNotOccupied_ReturnsPositionTwo() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal2);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(2));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreTwoUrinalsAndTheSecondUrinalIsOccupied_ReturnsPositionOne() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(true);
        bathroom.add(urinal2);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(1));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreTwoUrinalsAndBothUrinalsAreOccupied_ReturnsPositionZero() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(true);
        bathroom.add(urinal2);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(0));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreThreeUrinalsAndNoUrinalsAreOccupied_ReturnsPositionThree() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(false);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(false);
        bathroom.add(urinal3);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(3));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreThreeUrinalsAndTheThirdUrinalIsOccupied_ReturnsPositionOne() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(false);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(true);
        bathroom.add(urinal3);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(1));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreThreeUrinalsAndTheFirstAndThirdUrinalsAreOccupied_ReturnsPositionTwo() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(false);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(true);
        bathroom.add(urinal3);
        assertThat(bathroom.determineOptimalUrinal(), equalTo(2));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreFourUrinalsAndTheSecondAndFourthUrinalsAreOccupied_ReturnsPositionOne() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(false);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(true);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(false);
        bathroom.add(urinal3);

        Urinal urinal4 = new Urinal();
        urinal4.setIsOccupied(true);
        bathroom.add(urinal4);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(1));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreFourUrinalsAndOnlyTheThirdUrinalIsUnoccupied_ReturnsPositionThree() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(true);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(false);
        bathroom.add(urinal3);

        Urinal urinal4 = new Urinal();
        urinal4.setIsOccupied(true);
        bathroom.add(urinal4);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(3));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreFiveUrinalsAndOnlyTheSecondAndFourthUrinalsAreUnoccupied_ReturnsPositionFour() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(false);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(true);
        bathroom.add(urinal3);

        Urinal urinal4 = new Urinal();
        urinal4.setIsOccupied(false);
        bathroom.add(urinal4);

        Urinal urinal5 = new Urinal();
        urinal5.setIsOccupied(true);
        bathroom.add(urinal5);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(4));
    }

    @Test
    public void determineOptimalUrinal_WhenThereAreSixUrinalsAndOnlyTheThirdAndFifthUrinalsAreUnoccupied_ReturnsPositionFive() {
        Bathroom bathroom = new Bathroom();

        Urinal urinal = new Urinal();
        urinal.setIsOccupied(true);
        bathroom.add(urinal);

        Urinal urinal2 = new Urinal();
        urinal2.setIsOccupied(true);
        bathroom.add(urinal2);

        Urinal urinal3 = new Urinal();
        urinal3.setIsOccupied(false);
        bathroom.add(urinal3);

        Urinal urinal4 = new Urinal();
        urinal4.setIsOccupied(true);
        bathroom.add(urinal4);

        Urinal urinal5 = new Urinal();
        urinal5.setIsOccupied(false);
        bathroom.add(urinal5);

        Urinal urinal6 = new Urinal();
        urinal6.setIsOccupied(true);
        bathroom.add(urinal6);

        assertThat(bathroom.determineOptimalUrinal(), equalTo(5));
    }
}