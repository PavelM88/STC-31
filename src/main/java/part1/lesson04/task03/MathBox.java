package part1.lesson04.task03;

import java.util.ListIterator;

public class MathBox<T extends Number> extends ObjectBox {


    public MathBox(Number[] number) throws Exception {
        for (Number num : number) {
            addObject(num);
        }
    }

    public Number summator() {
        double sum = 0.0;
        for (Number number : (Iterable<Number>) getObjects()) {
            if (number != null) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }

    public void splitter(Integer divide) {
        ListIterator iterator = getObjects().listIterator();
        while (iterator.hasNext()) {
            Number number = (Number) iterator.next();
            if (number != null) {
                iterator.set(number.doubleValue() / divide);
            }
        }
    }

    public void removeElement(Integer delete) {
        deleteObject(delete);
    }


    @Override
    public void addObject(Object obj) throws Exception {
        if (obj instanceof Number) {
            super.addObject(obj);
        } else throw new Exception(obj + "-Объект не является экземпляром класса Number!");
    }

    @Override
    public String toString() {
        return super.dump();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
