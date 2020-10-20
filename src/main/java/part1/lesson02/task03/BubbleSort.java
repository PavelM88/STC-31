package part1.lesson02.task03;


/**
 * Сортировка массива пузырьком по полу, возрасту, алфавиту.
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 */

public class BubbleSort implements Sorting {

    public void sort(final Person[] person) {
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = person.length - 1; j > i; j--) {
                if (person[j - 1].compareTo(person[j]) > 0) {
                    swap(person, j);
                }
            }
        }
    }

    private void swap(Person[] person, int j) {
        Person p1;
        p1 = person[j - 1];
        person[j - 1] = person[j];
        person[j] = p1;
    }
}
    



