package test;

import main.Person;
import main.Urinal;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PersonTest {

    @Test
    public void chooseUrinal_whenThereAreNoUrinals_ReturnsNoUrinal() {
        Person person = new Person();

        int urinalPosition = person.chooseUrinal(new ArrayList<Urinal>());
        assertThat(urinalPosition, equalTo(-1));
    }

    @Test
    public void chooseUrinal_whenThereIsOneUrinalAndItIsNotOccupied_ReturnsTheUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(true));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(0));
    }

    @Test
    public void chooseUrinal_whenThereIsOneUrinalAndItIsOccupied_ReturnsNoUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(false));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(-1));
    }

    @Test
    public void chooseUrinal_whenThereAreMultipleUrinalsAndAllAreAvailable_ReturnsTheFurthestUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(true));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(1));
    }

    @Test
    public void chooseUrinal_WhenThereAreTwoUrinalsAndOnlyTheFirstIsAvailable_ReturnsTheFirstUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(false));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(0));
    }

    @Test
    public void chooseUrinal_WhenThereAreThreeUrinalsAndTheFurthestIsNotAvailable_ReturnsTheFirstUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(false));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(0));
    }

    @Test
    public void chooseUrinal_WhenThereAreFourUrinalsAndTheFourthAndSecondAreOccupied_ReturnsTheFirstUrinal() {
        Person person = new Person();

        ArrayList<Urinal> urinals = new ArrayList<Urinal>();
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(true));
        urinals.add(new Urinal(false));

        int urinalPosition = person.chooseUrinal(urinals);
        assertThat(urinalPosition, equalTo(0));
    }
}