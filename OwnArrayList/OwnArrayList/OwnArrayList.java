package OwnArrayList;

import java.util.Arrays;

/**
 * Created by admin on 27.03.2017.
 */
public class OwnArrayList<T> {
    private static final int DEFAULT_CAPACITY = 16; // значение размера массива по умолчанию
    private static final Object[] EMPTY_LIST = {}; // пустой массив, который будем возвращать при создании пустого листа
    private int size;
    private Object[] ListData; // массив, в котором будем хранить элементы

    /*Конструктор по умолчанию(пустой лист)*/
    public OwnArrayList() {
        this.ListData = EMPTY_LIST;
    }

    /*Конструктор с определенным значением размера листа*/
    public OwnArrayList(int Capacity) {
        if (Capacity < 0) throw new IllegalArgumentException("Cannot create ArrayList");
        else this.ListData = new Object[Capacity];
    }

    /*void add() - добавление элемента в конец листа*/
    public void add(T element) {
        if (size == ListData.length) increaseCapacity();
        ListData[size++] = element;
    }

    /*void add(index) - добавление элемента по индексу*/
    public void add(T element, int index) {
        if (size == ListData.length) increaseCapacity();
        if((size - index) > 0) System.arraycopy(ListData, index, ListData, index + 1, size - index);
        ListData[index] = element;
        size++;
    }

    /*void clear() - очистка всех элементов*/
    public void clear() {
        for (int i = 0; i < size; i++) {
            ListData[i] = null;
        }
        size = 0;
    }

    /*T get(index) - получение элемент по индексу*/
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("invalid index");
        }
        return (T) ListData[index];
    }

    /*T remove(index) - удаляет элемент из массива по индексу и возвращает его*/
    public T remove(int index) {
        T removedElement = (T) ListData[index];
        if ((size - index - 1) > 0) System.arraycopy(ListData, index + 1, ListData, index, size - index - 1);
        ListData[size] = null;
        size--;
        return removedElement;
    }

    /*Возвращает размер листа*/
    public int size() {
        return size;
    }

    /*Вывести лист на экран*/
    public void printlist() {
        for (int i = 0; i < size; i++) {
            System.out.print(ListData[i] + " ");
        }
    }

    /*Вспомогательный метод, увеличивает размер ListData*/
    private void increaseCapacity() {
        int newCapacity = ListData.length * 2 + 1;
        ListData = Arrays.copyOf(ListData, newCapacity);
    }
}
