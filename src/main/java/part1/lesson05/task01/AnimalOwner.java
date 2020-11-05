package part1.lesson05.task01;

import java.util.Objects;

/**
 * класс Хозяин.
 */
public class AnimalOwner {
    private String name;
    private Integer age;
    private SexPerson sex;

    /**
     * Конструктор
     *
     * @param name-имя
     * @param age-возраст
     * @param sex-пол
     */
    public AnimalOwner(String name, int age, SexPerson sex) {
        this.name = name;
        if (age >= 0 && age <= 100) {
            this.age = age;
        }
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SexPerson getSex() {
        return sex;
    }

    public void setSex(SexPerson sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalOwner that = (AnimalOwner) o;
        return age.equals(that.age) &&
                Objects.equals(name, that.name) &&
                sex == that.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "AnimalOwner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
