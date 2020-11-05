package part1.lesson05.task01;

import java.util.Objects;
import java.util.UUID;

/**
 * Класс Животные
 */
public class Animal {
    private String id = UUID.randomUUID().toString();
    private String animalName;
    private AnimalOwner person;
    private Integer weight;

    /**
     * Конструктор класса
     *
     * @param animalName-кличка животного
     * @param person-хозяин
     * @param weight-вес
     */
    public Animal(String animalName, AnimalOwner person, int weight) {
        this.animalName = animalName;
        this.person = person;
        this.weight = weight;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public AnimalOwner getPerson() {
        return person;
    }

    public void setPerson(AnimalOwner person) {
        this.person = person;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animals = (Animal) o;
        return weight.equals(animals.weight) &&
                Objects.equals(animalName, animals.animalName) &&
                Objects.equals(person, animals.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalName, person, weight);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", animalName='" + animalName + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }
}
