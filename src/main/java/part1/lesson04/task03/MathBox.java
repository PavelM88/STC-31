package part1.lesson04.task03;

import java.util.ArrayList;
import java.util.List;

public class MathBox<T extends Number> extends ObjectBox<T> {


    public MathBox(T[] number) throws Exception {
        for (T num : number) {
            addObject(num);
        }
    }

    public Number summator() {
        double sum = 0.0;
        for (Object number : getObjects()) {
            if (number != null) {
                sum += ((Number) number).doubleValue();
            }
        }
        return sum;
    }

    public void splitter(T divide) {
        if (divide.intValue() == 0) throw new ArithmeticException("Делить на ноль нельзя!");
        List<Double> result = new ArrayList<>();
        for (T o : getObjects()) {
            result.add(o.doubleValue() / divide.doubleValue());
        }
        System.out.println(result.toString());
    }

    public void removeElement(T delete) {
        super.deleteObject(delete);
    }


    @Override
    public void addObject(T obj) throws Exception {
        if (obj != null) {
            super.addObject(obj);
        } else throw new Exception("-Объект не является экземпляром класса Number!");
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
