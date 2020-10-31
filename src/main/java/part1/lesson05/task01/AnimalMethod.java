package part1.lesson05.task01;

import java.util.*;

public class AnimalMethod {
    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) throws Exception {
        if (!animals.contains(animal)) {
            animals.add(animal);
        } else {
            throw new Exception("Дубликат!");
        }
    }

    public void searchForAnimalByName(String name) {
        List<Animal> list = new ArrayList<>(animals);
        for (Animal animals : list) {
            if (animals.getAnimalName().equals(name)) {
                System.out.println("Результат поиска: " + animals.toString());
            }
        }
    }

    public void changeDataByIndex(String animal, String newName, int weight) {
        for (Animal value : animals) {
            if (value.getAnimalName().equals(animal)) {
                value.setAnimalName(newName);
                value.setWeight(weight);
                break;
            }
        }
    }

    public void getShow() {
        List<Animal> list = new ArrayList<>(animals);
        for (Animal an : list) {
            System.out.println(an);
        }

    }

    public void sortedListOfAnimal() {
        List<Animal> list = new ArrayList<>(animals);
        Collections.sort(list);
        for (Animal animal : list) {
            System.out.println("Owner: " + animal.getPerson().getName() + " Animal name: "
                    + animal.getAnimalName() + " weight: " + animal.getWeight());
        }
    }
}
