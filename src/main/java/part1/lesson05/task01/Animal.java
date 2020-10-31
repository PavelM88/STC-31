package part1.lesson05.task01;

import java.util.Objects;
import java.util.UUID;

public class Animal implements Comparable<Animal> {
    private UUID id;
    private String animalName;
    private AnimalOwner person;
    private Integer weight;

    public Animal(String animalName, AnimalOwner person, int weight) {
        this.id = UUID.randomUUID();
        this.animalName = animalName;
        this.person = person;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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


    @Override
    public int compareTo(Animal o) {
        int compare = getPerson().compareTo(o.getPerson());
        if (compare == 0) {
            compare = getAnimalName().compareTo(o.getAnimalName());
        }
        if (compare == 0) {
            compare = getWeight().compareTo(o.getWeight());
        }
        return compare;
    }
}
