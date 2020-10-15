package part1.lesson02.task03;


public class Main {
    public static void main(String[] args) {
        Person[] arraysPerson = new Person[100];
        for (int i = 0; i < 100; i++) {
            arraysPerson[0] = new Person(23, "Nik", Sex.MAN);
            arraysPerson[1] = new Person(35, "Vika", Sex.WOMAN);
            arraysPerson[2] = new Person(28, "Viktor", Sex.MAN);
            arraysPerson[3] = new Person(22, "Olga", Sex.WOMAN);
            arraysPerson[4] = new Person(37, "Mark", Sex.MAN);
            arraysPerson[5] = new Person(18, "Niki", Sex.WOMAN);
            arraysPerson[6] = new Person(31, "Petr", Sex.MAN);
            arraysPerson[7] = new Person(40, "Anna", Sex.WOMAN);
            arraysPerson[8] = new Person(47, "Alex", Sex.MAN);
            arraysPerson[9] = new Person(30, "Dasha", Sex.WOMAN);
            arraysPerson[10] = new Person(47, "Bob", Sex.MAN);
            arraysPerson[11] = new Person(37, "Dandi", Sex.MAN);
            arraysPerson[12] = new Person(35,"Britni",Sex.WOMAN);
            arraysPerson[i] = new Person(60, "Linht", Sex.WOMAN);
        }

        CompSort compSort = new CompSort();
        long startTime = System.nanoTime();
        compSort.sort(arraysPerson);
        System.out.println("Время работы: " + (System.nanoTime() - startTime));

        for (Person person : arraysPerson) {
            System.out.println(person);
        }

        BubbleSort bubbleSort = new BubbleSort();
        long startTime1 = System.nanoTime();
        bubbleSort.sort(arraysPerson);
        for (Person p : arraysPerson) {
            System.out.println(p);
        }
        System.out.println("Время работы: " + (System.nanoTime() - startTime1));

    }
}
