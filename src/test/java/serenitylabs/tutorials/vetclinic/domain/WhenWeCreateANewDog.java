package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

    @Test
    public void a_new_dog_should_have_a_readable_name() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(), is(equalTo("Fido the black labrador")));
        assertThat(fido.toString(), is(equalToIgnoringCase("Fido the BLACK Labrador")));
        assertThat(fido.toString(), is(containsString("labrador")));
        assertThat(fido.toString(), is(containsString("black")));
        assertThat(fido.toString(), is(startsWith("Fido")));
    }

    @Test
    public void a_dog_can_have_several_colors() throws Exception {

        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black","White");

        assertThat(fido.getColour(), contains("Black", "White"));
        assertThat(fido.getColour(), hasItems("White"));
        assertThat(fido.getColour(), not(hasItems("Red")));



    }
}
