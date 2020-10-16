package part1.lesson02.task03;


public class Person implements Comparable<Person> {
    private Integer age;
    private String name;
    private Sex sex;

    public Person(int age, String name, Sex sex) {
//        Проверка на возраст. Возраст не может быть меньше 0 и больше 100
        if (age >= 0 && age <= 100) {
            this.age = age;
        }
        this.name = name;
        this.sex = sex;
    }

    public int compareTo(Person o) {
        int a = age.compareTo(o.getAge());
        if (a != 0) {
            return a;
        }
        a = name.compareTo(o.getName());
        if (a <= 0) {
            return a;
        }
        return sex.compareTo(o.getSex());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 100) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return getName() + " " + getAge() + " " + getSex();
    }

}
