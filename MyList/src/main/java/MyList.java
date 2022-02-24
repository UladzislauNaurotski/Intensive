import java.util.*;

public class MyList<T> implements DefaultList<T> {

    /**
     * Default initial capacity.
     */
    private final int CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     */
    private Object[] arrays;

    /**
     * The size of the MyList (the number of elements it contains).
     *
     * @serial
     */
    private int size = 0;

    /**
     * Maximum capacity value
     */
    private final double MAX_VALUE = 0.7;

    /**
     * Expansion capacity
     */
    private final double EXPANSION = 1.5;

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public MyList() {
        this.arrays = new Object[CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initial the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public MyList(int initial) {
        this.arrays = new Object[initial];
    }

    /**
     * The method checked limits this list.
     * @param index the value checked
     * @throws IndexOutOfBoundsException if the index outside this list
     */
    private void checkInterval(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * The method checked capacity this list.
     * @param size the count elements in the list
     */
    private void checkCapacity(int size) {
        if (size + 1 > MAX_VALUE * arrays.length) {
            Object[] newArrays = new Object[(int) (size * EXPANSION)];
            System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
            arrays = newArrays;
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param t element to be appended to this list
     * @return {@code true} the element appended
     */
    @Override
    public boolean add(T t) {
        checkCapacity(size);
        arrays[size] = t.toString();
        ++size;
        return true;
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        arrays = new Object[CAPACITY];
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index) {
        checkInterval(index);
        return (T) arrays[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T set(int index, T element) {
        checkInterval(index);
        T oldElement = (T) arrays[index];
        arrays[index] = element;
        return oldElement;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        checkInterval(index);
        checkCapacity(size);
        System.arraycopy(arrays, index, arrays, index + 1, arrays.length - 1 - index);
        arrays[index] = element;
        ++size;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T remove(int index) {
        checkInterval(index);
        T removeElement = (T) arrays[index];
        System.arraycopy(arrays, index, arrays, index - 1, size - index);
        --size;
        return removeElement;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(o))
                return true;
        }
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
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
}
