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


    @Override
    public int compareTo(Person o) {
        // Сравненние по полу поле sex
        if (this.sex.compareTo(o.getSex()) > 0) {
            return 1;
        }
        // Если поле sex равны, то сравниваем по возрасту
        if (this.sex.compareTo(o.getSex()) == 0) {
            if (this.age.compareTo(o.getAge()) < 0) {
                return 1;
            }
        }
        // Если пол, возраст равны, то сортируем по алфавиту
        if (this.age.compareTo(o.getAge()) == 0) {
            if (this.name.compareTo(o.getName()) > 0) {
                return 1;
            }
        }
        return 0;
    }
}