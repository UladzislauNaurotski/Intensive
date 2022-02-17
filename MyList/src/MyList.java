import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<T> implements List<T> {

    private final int CAPACITY = 10;
    private Object[] arrays;
    private int size = 0;
    private final double MAX_VALUE = 0.7;
    private final double EXPANSION = 1.5;


    public MyList() {
        this.arrays = new Object[CAPACITY];
    }

    private void checkInterval(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkCapacity(int size) {
        if (size + 1 > MAX_VALUE * arrays.length) {
            Object[] newArrays = new Object[(int) (arrays.length * EXPANSION)];
            System.arraycopy(arrays, 0, newArrays, 0, size);
            arrays = newArrays;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        checkCapacity(size);
        arrays[size] = t;
        ++size;
        return true;
    }

    @Override
    public void clear() {
        arrays = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        checkInterval(index);
        return (T) arrays[index];
    }

    @Override
    public T set(int index, T element) {
        checkInterval(index);
        arrays[index] = element;
        return null;
    }

    @Override
    public void add(int index, T element) {
        checkInterval(index);
        checkCapacity(size);
        System.arraycopy(arrays, index, arrays, index + 1, size - index);
        arrays[index] = element;
        ++size;
    }

    @Override
    public T remove(int index) {
        checkInterval(index);
        System.arraycopy(arrays, index, arrays, index - 1, size - index);
        --size;
        return null;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(o)) {
                System.arraycopy(arrays, i + 1, arrays, i, size - i);
                --size;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

}
