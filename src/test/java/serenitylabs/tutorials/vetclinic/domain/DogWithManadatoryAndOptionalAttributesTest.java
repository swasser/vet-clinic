package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

public class DogWithManadatoryAndOptionalAttributesTest {

    @Test
    public void can_create_a_dog_with_a_name_and_a_breed() throws Exception {

        Dog doggy = Dog.called("snoopy").ofBreed("dachshund").ofColor("brown").build();

        Assert.assertEquals("snoopy", doggy.getName());
        Assert.assertEquals("dachshund", doggy.getBreed());
        Assert.assertEquals("brown", doggy.getColor());

        System.out.println("Hello, my name is: "+doggy.getName());
        System.out.println("Hello, my breed is: "+doggy.getBreed());
        System.out.println("Hello, my color is: "+doggy.getColor());
    }


    @Test
    public void a_dog_must_have_a_breed_and_a_color() throws Exception {

        Dog doggy = Dog.called("snoopy").ofBreed("german shepard").ofColor("black").build();

        Assert.assertEquals("snoopy", doggy.getName());
        Assert.assertEquals("german shepard", doggy.getBreed());
        Assert.assertEquals("black", doggy.getColor());

        System.out.println("Hello, my name is: "+doggy.getName());
        System.out.println("Hello, my breed is: "+doggy.getBreed());
        System.out.println("Hello, my color is: "+doggy.getColor());
    }

    @Test
    public void a_dog_can_have_a_favoritefood_and_an_assigneddoctor() throws Exception {

        Dog doggy = Dog.called("snoopy")
                .ofBreed("german shepard")
                .ofColor("black")
                .withFavoriteFood("pizza")
                .withAssignedDoctor("jenkins")
                .build();

        Assert.assertEquals("snoopy", doggy.getName());
        Assert.assertEquals("german shepard", doggy.getBreed());
        Assert.assertEquals("black", doggy.getColor());
        Assert.assertEquals("pizza", doggy.getFavoriteFood());
        Assert.assertEquals("jenkins", doggy.getAssignedDoctor());

        System.out.println("Hello, my name is: "+doggy.getName());
        System.out.println("Hello, my breed is: "+doggy.getBreed());
        System.out.println("Hello, my color is: "+doggy.getColor());
        System.out.println("Hello, my favorite food is: "+doggy.getFavoriteFood());
        System.out.println("Hello, my doctor is: "+doggy.getAssignedDoctor());

    }
}
