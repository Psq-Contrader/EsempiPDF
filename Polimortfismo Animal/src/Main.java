public class Main {
    public static void main(String[] args) {
        AnimalCare animalCare = new AnimalCare();

        Dog dog = new Dog();
        Cat cat = new Cat();

        animalCare.checkSound(dog); //il cane abbaia
        animalCare.checkSound(cat); //il gatto miagola
    }
}
