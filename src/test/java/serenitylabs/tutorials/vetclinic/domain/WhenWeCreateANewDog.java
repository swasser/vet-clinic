package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

    @Test
    public void can_create_dogs_description() throws Exception {

        Dog doggy = Dog.called("Fido").ofBreed("labrador").andOfColour("black");
        Assert.assertThat(doggy.toString(), is(containsString("Fido the black labrador")));
        //Assert.assertThat(doggy.toString(), equalToIgnoringCase("Fido the black labrador"));
        System.out.println(doggy.toString());
    }

    @Test
    public void a_dog_can_have_several_colours() throws Exception {

        Dog doggy = Dog.called("Fido").ofBreed("labrador").andOfColour("black","white");

        Assert.assertThat(doggy.getColour(), is(contains("black","white")));

    }
}
