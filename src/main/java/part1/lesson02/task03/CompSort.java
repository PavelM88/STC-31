package part1.lesson02.task03;

import java.util.Arrays;
import java.util.Comparator;

public class CompSort implements Sorting, Comparator<Person> {
    public void sort(Person[] people) {
        Arrays.sort(people, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                Person.Sex p1 = o1.getSex();
                Person.Sex p2 = o2.getSex();
                int sortComp = p1.compareTo(p2);
                if (sortComp != 0) {
                    return sortComp;
                } else {
                    Integer i1 = o1.getAge();
                    Integer i2 = o2.getAge();
                    return i2.compareTo(i1);
                }
            }
        });
    }

    public int compare(Person o1, Person o2) {
        return 0;
    }
}

