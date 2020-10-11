package part1.lesson02.task03;


public class BubbleSort implements Sorting {

    public void sort(final Person[] person) {
        boolean isSorted = false;
        Person p1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < person.length - 1; i++) {
                p1 = person[i];
                int age = person[i].getAge();
                int ageNext = person[i + 1].getAge();
                if (age < ageNext) {
                    isSorted = false;

                    person[i] = person[i + 1];
                    person[i + 1] = p1;
                }

            }
        }
        for (Person item : person) {
            if (item.getSex() == Person.Sex.MAN) {
                System.out.println(item);
            }
        }
        for (Person value : person) {
            if (value.getSex() == Person.Sex.WOMAN) {
                System.out.println(value);
            }
        }
    }
}

