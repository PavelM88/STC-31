package part1.lesson04.task02;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Класс для хранения коллекции Object
 */
public class ObjectBox {
    private Collection<Object> objects = new ArrayList<>();

    /**
     * метод добавления объекта в коллекцию
     */
    public void addObject(Object obj) {
        objects.add(obj);
    }

    /**
     * @param delObj входной параметр, по которуму проверяется наличие объкта
     *               в коллекции и удаляется при его наличии
     */
    public void deleteObject(Object delObj) {
        objects.remove(delObj);
    }

    /**
     * выводит содержимое коллекции в строку
     */
    public void dump() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "objects=" + objects +
                '}';
    }
}
