package part1.lesson04.task03;

public class TestMain {
    public static void main(String[] args) throws Exception {
        String str = "qwr sdf";
        int i = 123;

        System.out.println("---ObjectBox---");
        ObjectBox<Object> box = new ObjectBox<>();
        box.addObject(str);
        box.addObject(i);
        System.out.println(box.dump());
        box.deleteObject(i);
        System.out.println(box.dump());

        System.out.println("---MathBox---");
        MathBox<Number> mathBox = new MathBox<>(new Number[]{1, 34, 33.5});
        mathBox.addObject(i);
        System.out.println(mathBox.toString());
        System.out.print("Сумма чисел: ");
        System.out.println(mathBox.summator());
        System.out.print("Удаление элемента из коллекции: ");
        mathBox.removeElement(1);
        System.out.println(mathBox.toString());
        System.out.print("Деление элементов коллекции: ");
        mathBox.splitter(3);
    }
}
