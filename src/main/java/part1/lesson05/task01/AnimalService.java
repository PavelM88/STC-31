package part1.lesson05.task01;

import java.util.*;

public class AnimalService implements Comparator<Map.Entry<String, Animal>> {
    Map<String, Animal> animalMap = new HashMap<>();

    /**
     * Метод добавления животных
     *
     * @param animal объект класса Animal.
     * @throws Exception выкидывает исключение, если есть дубликат добавляемого животного
     */
    public void addAnimal(Animal animal) throws Exception {
        Map<String, Animal> map = new HashMap<>();
        map.put(animal.getId(), animal);
        Set<String> animals = new HashSet<>();
        for (Animal an : map.values()) {
            animals.add(an.toString());
        }
        if (map.size() > animals.size()) {
            throw new Exception("Дубликат");
        } else if (map.size() == animals.size()) {
            animalMap.putAll(map);
        }

    }

    /**
     * Метод поиска животного по его кличке
     *
     * @param name входной праметр для поиска животного
     */
    public void searchForAnimalByName(String name) {
        Set<Map.Entry<String, Animal>> entrySet = animalMap.entrySet();
        for (Map.Entry<String, Animal> entry : entrySet) {
            if (name.equals(entry.getValue().getAnimalName())) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    /**
     * Метод изменения животного
     *
     * @param newName-новая    кличка животного
     * @param weight-изменение веса животного
     */
    public void changeDataByIndex(String id, String newName, int weight) {
        if (animalMap.containsKey(id)) {
            animalMap.get(id).setAnimalName(newName);
            animalMap.get(id).setWeight(weight);
        } else {
            System.out.println(id + " не действительный Id!");
        }
    }

    /**
     * вывод на экран списка животных в отсортированном порядке
     */
    public void sortedListOfAnimal() {
        Map<String, Animal> mapAnimal = new HashMap<>(animalMap);
        List<Map.Entry<String, Animal>> list = new LinkedList<>(mapAnimal.entrySet());
        list.sort(this);
        Map<String, Animal> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Animal> animalEntry : list) {
            sortedMap.put(animalEntry.getKey(), animalEntry.getValue());
        }
        for (Map.Entry<String, Animal> display : sortedMap.entrySet()) {
            System.out.println(display.getValue().getPerson() + " " + display.getValue().getAnimalName()
                    + " " + display.getValue().getWeight());
        }
    }

    /**
     * Метод сравнения - хозяин, кличка животного, вес.
     *
     * @param o1 первый объкт сравнения
     * @param o2 второй объект сравнения
     * @return возвращает отрицательное целое число, ноль или положительное целое
     * число если первый аргумент меньше, равен или больше.
     */
    @Override
    public int compare(Map.Entry<String, Animal> o1, Map.Entry<String, Animal> o2) {
        String owner1 = o1.getValue().getPerson().getName();
        String owner2 = o2.getValue().getPerson().getName();
        int comp = owner1.compareTo(owner2);
        if (comp == 0) {
            String animalName1 = o1.getValue().getAnimalName();
            String animalName2 = o2.getValue().getAnimalName();
            comp = animalName1.compareTo(animalName2);
        }
        if (comp == 0) {
            Integer weightAnimal1 = o1.getValue().getWeight();
            Integer weightAnimal2 = o2.getValue().getWeight();
            comp = weightAnimal1.compareTo(weightAnimal2);
        }
        return comp;
    }
}
