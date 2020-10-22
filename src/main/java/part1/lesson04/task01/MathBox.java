package part1.lesson04.task01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class MathBox {
    /**
     * @param numbers коллекция для хранения чисел без дубликатов
     */
    private Set<Number> numbers = new HashSet<>();

    /**
     * Конструктор на вход получает массив Number
     *
     * @param number массив чисел для формирования новой внутренней коллекции
     */
    public MathBox(Number[] number) {
        this.numbers.addAll(new HashSet<>(Arrays.asList(number)));
    }

    /**
     * @return метод возращающий сумму всех элементов коллекции
     */
    public Number summator() {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += Double.parseDouble(String.valueOf(number));
        }
        return sum;
    }

    /**
     * @param divide делитель, входной параметр выполняющий поочередное деление
     *               всех хранящихся элементов в коллекции
     * @return Хранящиеся в объекте данные полностью заменяются результатами деления
     */
    public Set<Number> splitter(Integer divide) {
        if (divide == 0) throw new ArithmeticException("Делить на ноль нельзя!");
        Set<Number> result = new HashSet<>();
        for (Number i : numbers) {
            result.add(i.doubleValue() / divide);
        }
        return result;
    }

    /**
     * @param delete входное число, если такое число есть в коллекции, удаляет его
     */
    public boolean removeElement(Integer delete) {
        return this.numbers.remove(delete);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numbers, mathBox.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
