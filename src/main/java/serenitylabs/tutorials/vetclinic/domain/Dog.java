package serenitylabs.tutorials.vetclinic.domain;

public class Dog {
    private final String name;
    private final String breed;
    private final String color;
    private final String favoriteFood;
    private final String assignedDoctor;

    private Dog(String name, String breed, String color, String favoriteFood, String assignedDoctor) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.favoriteFood = favoriteFood;
        this.assignedDoctor = assignedDoctor;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    interface WithBreed {
        WithColor ofBreed(String breed);
    }

    interface WithColor{
        DogBreeder ofColor(String color);
    }

    public static class DogBreeder implements WithBreed, WithColor{
        private String name;
        private String breed;
        private String color;
        private String favoriteFood;
        private String assignedDoctor;

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

        public Dog build() {
            return new Dog(name,breed,color,favoriteFood,assignedDoctor);
        }


        public DogBreeder withFavoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
            return this;
        }

        public DogBreeder withAssignedDoctor(String assignedDoctor) {
            this.assignedDoctor = assignedDoctor;
            return this;
        }
    }
}
