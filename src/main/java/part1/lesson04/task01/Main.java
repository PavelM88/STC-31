package part1.lesson04.task01;


public class Main {
    public static void main(String[] args) {
        Number[] numbers = new Number[10];
        numbers[0] = 0.5;
        numbers[1] = 25.0;
        numbers[2] = 0.5f;
        numbers[3] = 1;
        numbers[4] = 10;
        numbers[5] = 0.25;
        numbers[6] = 25.1;
        numbers[7] = 1.5f;
        numbers[8] = 12;
        numbers[9] = 15;

        MathBox mathBox = new MathBox(numbers);
        System.out.println(mathBox.removeElement(12));
        System.out.println(mathBox.toString());
        System.out.println(mathBox.splitter(1));
        mathBox.splitter(2);
        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
    }
}
