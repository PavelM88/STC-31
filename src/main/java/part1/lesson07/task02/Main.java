package part1.lesson07.task02;

public class Main {
    public static void main(String[] args) {
        TextGenerator tg = new TextGenerator();
        String path = "D:\\stc-31\\src\\main\\java\\part1\\lesson07\\task02";
        tg.getFiles(path,2,4,tg.arrayWords(),3);
        System.out.println(tg.textGenerate(2,tg.arrayWords()));
    }
}
