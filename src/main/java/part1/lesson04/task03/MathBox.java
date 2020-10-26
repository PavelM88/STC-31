package part1.lesson04.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathBox extends ObjectBox {


    public MathBox(Number[] number) throws Exception {
        for (Number num : number) {
            addObject(num);
        }
    }

    public Number summator() {
        double sum = 0.0;
        for (Object number : getObjects()) {
            if (number != null) {
                sum +=((Number) number).doubleValue();
            }
        }
        return sum;
    }

    public void splitter(Integer divide) {
        if (divide == 0) throw new ArithmeticException("Делить на ноль нельзя!");
        List<Object> result = new ArrayList<>();
        for (Object o : getObjects()) {
            result.addAll(Collections.singleton(((Number) o).doubleValue() / divide));
        }
        System.out.println(result.toString());
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
