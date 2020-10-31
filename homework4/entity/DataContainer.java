package homeworks.homework4.entity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {
    private T[] data;
    private T[] copy;
    private int elementsCounter;

    public DataContainer(Class<T> type, int elementsCounter) {
        this.elementsCounter = elementsCounter;
        this.data = (T[]) Array.newInstance(type, elementsCounter);
    }

    public int getElementsCounter() {
        return elementsCounter;
    }

    public int add(T item) {
        int index = -1; // -1 == элемент не добавлен в массив

        // Цикл добавления элемента в массив на позицию со значением null
        for (int i = 0; i < this.elementsCounter; i++) {
            if (data[i] == null) {
                data[i] = item;
                index = i;
                break;
            }
        }

        // Если index == -1, значит массив был полностью занят
        if (index == -1) {
            this.copy = Arrays.copyOf(data, this.elementsCounter + 1);
            this.copy[this.elementsCounter] = item;
            this.elementsCounter++;
            this.data = Arrays.copyOf(copy, this.elementsCounter);
            index = this.elementsCounter - 1;
        }
        return index;
    }

    public T get(int index) {
        return this.data[index];
    }

    public boolean delete(int index) {

        if (index < 0 || index >= this.elementsCounter) {
            return false;
        }

        for (int i = index; i < this.elementsCounter - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.copy = Arrays.copyOf(data, this.elementsCounter - 1);
        this.elementsCounter--;
        this.data = Arrays.copyOf(copy, this.elementsCounter);
        return true;
    }

    public boolean delete(T item) {

        for (int i = 0; i < this.elementsCounter; i++) {
            if (this.data[i].equals(item)) {
                delete(i);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) {
                continue;
            }

            builder.append(this.data[i].toString()).append(", ");
        }

        builder.append("]");

        return builder.toString().replaceAll(", ]","]");
    }

    public void sort(Comparator<T> comparator) {
        T temp;
        boolean isSorted = false;

        for (int i = 0; i < this.elementsCounter; i++) {
            if (data[i] == null) {
                delete(i);
                i--;
            }
        }

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < this.elementsCounter - 1; i++) {
                if (comparator.compare(this.data[i], this.data[i + 1]) > 0) {
                    temp = this.data[i];
                    this.data[i] = this.data[i + 1];
                    this.data[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static <L extends Comparable> void sort(DataContainer<L> container) {
        L temp;
        boolean isSorted = false;

        for (int i = 0; i < container.elementsCounter; i++) {
            if (container.data[i] == null) {
                container.delete(i);
                i--;
            }
        }

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < container.elementsCounter - 1; i++) {
                if (container.data[i].compareTo(container.data[i + 1]) > 0) {
                    temp = container.data[i];
                    container.data[i] = container.data[i + 1];
                    container.data[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static <L> void sort(DataContainer<L> container, Comparator<L> comparator) {
        L temp;
        boolean isSorted = false;

        for (int i = 0; i < container.elementsCounter; i++) {
            if (container.data[i] == null) {
                container.delete(i);
                i--;
            }
        }

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < container.elementsCounter - 1; i++) {
                if (comparator.compare(container.data[i], container.data[i + 1]) > 0) {
                    temp = container.data[i];
                    container.data[i] = container.data[i + 1];
                    container.data[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}