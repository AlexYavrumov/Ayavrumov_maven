package HW_to_Lesson16;

import java.util.Arrays;

public class StringCollectionImpl implements StringCollection {
    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREASING_COEFFICIENT = 2;

    private String[] data;
    private int size;

    public StringCollectionImpl() {
        this.data = new String[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public String get(int index) {
        if (checkWrongIndex(index))
            return null;
        return data[index];
    }

    @Override
    public boolean add(String str) {
        return add(size, str);
    }

    @Override
    public boolean add(int index, String str) {
        increaseArray();
        if (checkWrongIndex(index))
            return false;
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = str;
        size++;
        return true;
    }

    @Override
    public boolean delete(String str) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(str)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false;
        if (size - 1 - index >= 0)
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        size--;
        return true;

    }

    @Override
    public boolean contains(String str) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(str))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection collection) {
        if (this == collection)
            return true;
        if (size != collection.size())
            return false;
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(collection.get(i)))
                return false;
        }
        return true;
    }


    @Override
    public boolean clear() {
        data = new String[INITIAL_CAPACITY];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        if (data == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(data[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    private boolean checkWrongIndex(int index) {
        return index < 0 || index > size;
    }

    private void increaseArray() {
        if (size >= data.length)
            data = Arrays.copyOf(data, data.length * INCREASING_COEFFICIENT);
    }
}