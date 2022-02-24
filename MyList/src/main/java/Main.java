import java.util.*;

public class Main {

    public static void main(String[] args) {

        DefaultComparator<String> defaultComparator = new DefaultComparator<>();
        MyList<String> m = new MyList<>();
        m.add(0, "q");
        m.add(1, "s");
        m.add(2, "c");
        m.add(3, "r");
        m.add(4, "a");
Collections.sort(m, defaultComparator);
        for (int i = 0; i < m.size(); i++) {
            System.out.println(m.get(i));
        }
    }
}
