import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MyListTest {


    private MyList<String> myList = new MyList<>();


    @Test
    public void add() {
        myList.add("one");
        String[] expected = new String[]{"one"};
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void size() {
        myList.add("one");
        int expected = 1;
        int actual = myList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void IsEmpty() {
        int expected = 0;
        int actual = 0;
        try {
            Field field = myList.getClass().getDeclaredField("size");
            field.setAccessible(true);
            actual = (int) field.get(myList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.set(1, "for");
        String[] expected = new String[]{"one", "for", "three"};
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void clear() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.clear();
        String[] expected = new String[0];
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void get() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        String expected = "two";
        String actual = myList.get(1);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void set() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.set(0, "zero");
        String[] expected = new String[]{"zero", "two", "three"};
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void remove() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.remove(1);
        String[] expected = new String[]{"two", "three"};
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void contains() {
        myList.add("one");
        myList.add("two");
        Assert.assertTrue(myList.contains("one"));
    }

    @Test
    public void testRemove() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.remove("one");
        String[] expected = new String[]{"two", "three"};
        String[] actual = new String[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            actual[i] = String.valueOf(myList.get(i));
        }
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}