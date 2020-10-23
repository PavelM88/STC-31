package part1.lesson04.task03;

import java.util.ArrayList;
import java.util.List;


public class ObjectBox<T> {
    private List<T> objects = new ArrayList<>();


    public void addObject(T obj) throws Exception {
        objects.add(obj);
    }


    public void deleteObject(T delObj) {
        objects.remove(delObj);
    }

    public String dump() {
        return objects.toString();
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "objects=" + objects +
                '}';
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

}
