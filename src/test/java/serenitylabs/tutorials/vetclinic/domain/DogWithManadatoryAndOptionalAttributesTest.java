package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

public class DogWithManadatoryAndOptionalAttributesTest {

    @Test
    public void can_create_a_dog_with_a_name_and_a_breed() throws Exception {

        Dog doggy = Dog.called("snoopy").ofBreed("dachshund").build();

        Assert.assertEquals("snoopy", doggy.getName());
        Assert.assertEquals("dachshund", doggy.getBreed());

        System.out.println("Hello, my name is: "+doggy.getName());
        System.out.println("Hello, my breed is: "+doggy.getBreed());
    }


    @Test
    public void can_create_a_dog_witout_a_breed() throws Exception {

        Dog doggy = Dog.called("snoopy").build();

        Assert.assertEquals("snoopy", doggy.getName());
        Assert.assertEquals(null, doggy.getBreed());

        System.out.println("Hello, my name is: "+doggy.getName());
        System.out.println("Hello, my breed is: "+doggy.getBreed());
    }
}
