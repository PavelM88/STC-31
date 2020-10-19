package part1.lesson02.task03;


/**
 * Сортировка массива пузырьком по полу, возрасту, алфавиту.
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 */

public class BubbleSort implements Sorting {

    public void sort(final Person[] person) {
        Person p1;

        for (int i = 0; i < person.length - 1; i++) {
            for (int j = person.length - 1; j > i; j--) {
//                Сравненние по полу поле sex;
                if (person[j - 1].getSex().compareTo(person[j].getSex()) > 0) {
                    p1 = person[j - 1];
                    person[j - 1] = person[j];
                    person[j] = p1;
                }
//                Если поле sex равны, то сравниваем по возрасту
                if (person[j - 1].getSex().compareTo(person[j].getSex()) == 0) {
                    if (person[j - 1].getAge() < person[j].getAge()) {
                        p1 = person[j - 1];
                        person[j - 1] = person[j];
                        person[j] = p1;
                    }
                }
//                Если пол, возраст равны, то сортируем по алфавиту
                if (person[j - 1].getSex().compareTo(person[j].getSex()) == 0) {
                    if (person[j - 1].getAge() == person[j].getAge()) {
                        if (person[j - 1].getName().compareTo(person[j].getName()) > 0) {
                            p1 = person[j - 1];
                            person[j - 1] = person[j];
                            person[j] = p1;
                        }
                    }
                }
            }
        }
    }
}
    



