package part1.lesson04.task03;

public class TestMain {
    public static void main(String[] args) throws Exception {
        String str = "qwr sdf";
        int i = 123;

        System.out.println("---ObjectBox---");
        ObjectBox box = new ObjectBox();
        box.addObject(str);
        box.addObject(i);
        System.out.println(box.dump());
        box.deleteObject(i);
        System.out.println(box.dump());

        System.out.println("---MathBox---");
        MathBox mathBox = new MathBox(new Number[]{1, 34, 33.5});
        mathBox.addObject(i);
        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
        mathBox.removeElement(1);
        mathBox.splitter(2);
        System.out.println(mathBox.toString());
        mathBox.addObject(str);
        System.out.println(mathBox.toString());
    }
}
