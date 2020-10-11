package part1.lesson02.task03;

import java.util.Arrays;
import java.util.Comparator;

public class CompSort implements Sorting, Comparator<Person> {
    public void sort(Person[] people) {
        Arrays.sort(people, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                int sortComp = o1.getSex().compareTo(o2.getSex());
                if (sortComp != 0) {
                    return sortComp;
                } else {
                    Integer i1 = o1.getAge();
                    Integer i2 = o2.getAge();
                    if (i2.compareTo(i1) != 0) {
                        return i2.compareTo(i1);
                    }
                    return o1.getName().compareToIgnoreCase(o2.getName());
                }
            }
        });
    }

    public int compare(Person o1, Person o2) {
        return 0;
    }
}

