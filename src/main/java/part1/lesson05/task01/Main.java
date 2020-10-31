package part1.lesson05.task01;

public class Main {
    public static void main(String[] args) throws Exception {
        AnimalMethod pet = new AnimalMethod();
        pet.addAnimal(new Animal("Myrka", new AnimalOwner("Ivan", 25, SexPerson.MAN), 4));
        pet.addAnimal(new Animal("Bobik", new AnimalOwner("Petra", 34, SexPerson.WOMAN), 8));
        pet.addAnimal(new Animal("Xatico", new AnimalOwner("Bob", 30, SexPerson.MAN), 10));
        pet.addAnimal(new Animal("Polkan", new AnimalOwner("Alice", 31, SexPerson.WOMAN), 12));

        pet.getShow();
        pet.searchForAnimalByName("Myrka");
        pet.changeDataByIndex("Myrka", "Mashka", 5);

        pet.getShow();
        pet.sortedListOfAnimal();
    }
}
