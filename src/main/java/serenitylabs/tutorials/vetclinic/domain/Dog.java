package serenitylabs.tutorials.vetclinic.domain;

public class Dog {
    private final String name;
    private final String breed;

    private Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
    }



    public static class DogBreeder {
        private String name;
        private String breed;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog build() {
            return new Dog(name,breed);
        }
    }
}
