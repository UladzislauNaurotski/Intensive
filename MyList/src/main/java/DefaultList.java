public interface DefaultList<T>  {

    int size();
    boolean isEmpty();
    boolean add(T t);
    void clear();
    T get(int index);
    T set(int index, T element);
    void add(int index, T element);
    T remove(int index);
    boolean contains(Object o);
    boolean remove(Object o);
}
