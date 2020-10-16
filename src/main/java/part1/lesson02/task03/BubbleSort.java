package part1.lesson02.task03;


/**Сортировка массива пузырьком по полу, возрасту, алфавиту.
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 */

public class BubbleSort implements Sorting {

    public void sort(final Person[] person) {
        Person p1;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = person.length - 1; j > i; j--) {
                if (person[j].compareTo(person[j-1]) > 0) {
                    p1 = person[j - 1];
                    person[j - 1] = person[j];
                    person[j] = p1;
                }
            }
        }
        for (Person persMan : person) {
            if (persMan.getSex().equals(Sex.MAN)) {
                System.out.println(persMan);
            }
        }
        for (Person persWoman : person) {
            if (persWoman.getSex().equals(Sex.WOMAN)) {
                System.out.println(persWoman);
            }
        }
    }
}
    



