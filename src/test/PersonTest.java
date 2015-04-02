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


}