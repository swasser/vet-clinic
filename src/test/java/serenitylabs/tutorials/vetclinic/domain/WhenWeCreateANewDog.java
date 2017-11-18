package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.LocalDate.now;


public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name_and_a_color() throws Exception {

        LocalDate birthday = LocalDate.of(1991,7,4);

        Dog fido = Dog.called("fido")
                .ofBreed("poodle")
                .ofColor("black")
                .bornOn(birthday);

        Assert.assertEquals("fido", fido.getName());
        Assert.assertEquals("poodle", fido.getBreed());
        Assert.assertEquals("black", fido.getColor());
        Assert.assertEquals(birthday, fido.getDateOfBirth());

    }

    @Test
    public void a_dog_can_have_an_optional_favourite_food() throws Exception {

        LocalDate birthday = now();
        Dog snoopy = Dog.called("snoopy")
                .ofBreed("spaniel")
                .ofColor("white")
                .favoriteFood("pizza")
                .bornOn(birthday);

        Assert.assertEquals("snoopy", snoopy.getName());
        Assert.assertEquals("spaniel", snoopy.getBreed());
        Assert.assertEquals("white", snoopy.getColor());
        Assert.assertEquals(birthday, snoopy.getDateOfBirth());

    }

    @Test
    public void a_dog_can_have_an_optional_favourite_toy() throws Exception {

        LocalDate birthday = now();
        Dog dart = Dog.called("dart")
                .ofBreed("shepard")
                .ofColor("black")
                .favoriteToy("rubber ducky")
                .bornOn(birthday);

        Assert.assertEquals("dart", dart.getName());
        Assert.assertEquals("shepard", dart.getBreed());
        Assert.assertEquals("black", dart.getColor());
        Assert.assertEquals("rubber ducky", dart.getFavoriteToy());


    }
}
