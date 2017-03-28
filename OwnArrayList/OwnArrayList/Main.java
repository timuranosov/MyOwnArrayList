package OwnArrayList;

import java.util.ArrayList;

/**
 * Created by admin on 29.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        /*OwnArrayList object = new OwnArrayList();
        object.add(1);
        object.add(2);
        System.out.println(object.size());*/

        /*Создание миллиона конструкторов*/
        long timeOwnConstructorStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            OwnArrayList object = new OwnArrayList();
        }
        long timeOwnConstructorEnd = System.nanoTime();
        System.out.println("Конструктор OwnArrayList " + (double)(timeOwnConstructorEnd - timeOwnConstructorStart)/100000 + " мс");
        long timeConstructorStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            ArrayList object = new ArrayList();
        }
        long timeConstructorEnd = System.nanoTime();
        System.out.println("Конструктор ArrayList " + (double)(timeConstructorEnd - timeConstructorStart)/100000 + " мс");

        /*Вставка миллиона значений*/
        OwnArrayList ownObject = new OwnArrayList();
        long timeOwnAddStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            ownObject.add(i);
        }
        long timeOwnAddEnd = System.nanoTime();
        System.out.println("Вставка в конец для OwnArrayList " + (double)(timeOwnAddEnd - timeOwnAddStart)/100000 + " мс");
        ArrayList object = new ArrayList();
        long timeAddStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            object.add(i);
        }
        long timeAddEnd = System.nanoTime();
        System.out.println("Вставка в конец для ArrayList " + (double)(timeAddEnd - timeAddStart)/100000 + " мс");

        /*Вставка милллиона значений по индексу*/
        OwnArrayList newObject  = new OwnArrayList();
        long timeOwnAddIndexStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            newObject.add(i, (int)Math.random()*100);
        }
        long timeOwnAddIndexEnd = System.nanoTime();
        System.out.println("Вставка по индексу для OwnArrayList " + (double)(timeOwnAddIndexEnd - timeOwnAddIndexStart)/100000 + " мс");
        ArrayList newArrayListObject = new ArrayList();
        long timeAddIndexStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            newArrayListObject.add(i, Math.random()*100);
        }
        long timeAddIndexEnd = System.nanoTime();
        System.out.println("Вставка по индексу для ArrayList " + (double)(timeAddIndexEnd - timeAddIndexStart)/100000 + " мс");

        /*Очистка миллиона значений*/
        OwnArrayList newObj  = new OwnArrayList();
        for (int i = 0; i < 1000000; i++) {
            newObject.add(i);
        }
        long timeOwnClearStart = System.nanoTime();
        newObj.clear();
        long timeOwnClearEnd = System.nanoTime();
        System.out.println("Очистка для OwnArrayList " + (double)(timeOwnClearEnd - timeOwnClearStart)/100000 + " мс");
        ArrayList newArrayListObj = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            newArrayListObject.add(i);
        }
        long timeClearStart = System.nanoTime();
        newArrayListObj.clear();
        long timeClearEnd = System.nanoTime();
        System.out.println("Очистка для ArrayList " + (double)(timeClearEnd - timeClearStart)/100000 + " мс");
    }
}
