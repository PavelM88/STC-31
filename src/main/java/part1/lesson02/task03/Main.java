package part1.lesson02.task03;



public class Main {
    public static void main(String[] args) {
        Person[] arraysPerson = new Person[10];
        arraysPerson[0] = new Person(23, "Nik", Person.Sex.MAN);
        arraysPerson[1] = new Person(35, "Vika", Person.Sex.WOMAN);
        arraysPerson[2] = new Person(28, "Viktor", Person.Sex.MAN);
        arraysPerson[3] = new Person(22, "Olga", Person.Sex.WOMAN);
        arraysPerson[4] = new Person(37, "Mark", Person.Sex.MAN);
        arraysPerson[5] = new Person(18, "Niki", Person.Sex.WOMAN);
        arraysPerson[6] = new Person(31, "Petr", Person.Sex.MAN);
        arraysPerson[7] = new Person(40, "Anna", Person.Sex.WOMAN);
        arraysPerson[8] = new Person(47, "Alex", Person.Sex.MAN);
        arraysPerson[9] = new Person(30, "Dasha", Person.Sex.WOMAN);
        CompSort compSort = new CompSort();
        long startTime = System.currentTimeMillis();
        compSort.sort(arraysPerson);
        System.out.println("Время работы: " + (System.currentTimeMillis() - startTime));
        for (Person person : arraysPerson) {
            System.out.println(person);
        }
    }
}
