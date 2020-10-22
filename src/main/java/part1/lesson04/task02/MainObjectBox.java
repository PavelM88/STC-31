package part1.lesson04.task02;

public class MainObjectBox {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        String line = "str";
        objectBox.addObject(line);
        int num = 24;
        objectBox.addObject(num);
        objectBox.dump();
        objectBox.deleteObject(24);
        objectBox.dump();
    }
}
