package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;


public class Dog {

    private final String name;
    private final String breed;
    private final String color;
    private final String food;
    private final String toy;
    private final LocalDate birthDay;
    private String favoriteToy;

    public Dog(String name, String breed, String color, String food, String toy, LocalDate birthDay) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.food = food;
        this.toy = toy;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getBreed() { return breed; }

    public String getColor() {
        return color;
    }

    public LocalDate getDateOfBirth() {
        return birthDay;
    }

    public String getFavoriteToy() {
        return toy;
    }

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }




    interface WithBreed {
        WithColor ofBreed(String breed);
    }

    interface WithColor {
        DogBreeder ofColor(String color);

    }

    public static class DogBreeder implements WithColor, WithBreed{
        private String name;
        private String breed;
        private String color;
        private String food;
        private String toy;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBreeder ofColor(String color) {
            this.color = color;
            return this;
        }

        public DogBreeder favoriteFood(String food) {
            this.food = food;
            return this;
        }

        public DogBreeder favoriteToy(String toy) {
            this.toy = toy;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name,breed,color,food,toy,birthday);
        }


    }
}
