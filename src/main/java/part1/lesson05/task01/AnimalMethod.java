package part1.lesson05.task01;

import java.util.*;

public class AnimalMethod {
    List<Animal> animals = new ArrayList<>();

    /**
     * Метод добавления животных
     *
     * @param animal
     * @throws Exception выкидывает исключение, если есть дубликат добавляемого животного
     */
    public void addAnimal(Animal animal) throws Exception {
        if (!animals.contains(animal)) {
            animals.add(animal);
        } else {
            throw new Exception("Дубликат!");
        }
    }

    /**
     * Метод поиска животного по его кличке
     *
     * @param name входной праметр для поиска животного
     */
    public void searchForAnimalByName(String name) {
        List<Animal> list = new ArrayList<>(animals);
        for (Animal animals : list) {
            if (animals.getAnimalName().equals(name)) {
                System.out.println("Результат поиска: " + animals.toString());
            }
        }
    }

    /**
     * Метод изменения животного
     *
     * @param animal-кличка    животного
     * @param newName-новая    кличка животного
     * @param weight-изменение веса животного
     */
    public void changeDataByIndex(String animal, String newName, int weight) {
        for (Animal value : animals) {
            if (value.getAnimalName().equals(animal)) {
                value.setAnimalName(newName);
                value.setWeight(weight);
                break;
            }
        }
    }

    /**
     * Метод вывода не отсортированного списка животных
     */
    public void getShow() {
        List<Animal> list = new ArrayList<>(animals);
        for (Animal an : list) {
            System.out.println(an);
        }

    }

    /**
     * вывод на экран списка животных в отсортированном порядке
     */
    public void sortedListOfAnimal() {
        List<Animal> list = new ArrayList<>(animals);
        Collections.sort(list);
        for (Animal animal : list) {
            System.out.println("Owner: " + animal.getPerson().getName() + " Animal name: "
                    + animal.getAnimalName() + " weight: " + animal.getWeight());
        }
    }
}
