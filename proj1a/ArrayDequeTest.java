/** Performs some basic linked list tests. */
import org.junit.Assert;
import org.junit.Test;
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct, 
     * finally printing the results. 
     *
     * && is the "and" operation. */
    @Test
    public void addIsEmptySizeTest() {

        ArrayDeque<String> arr1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, arr1.isEmpty());

        arr1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, arr1.size()) && passed;
        passed = checkEmpty(false, arr1.isEmpty()) && passed;

        arr1.addLast("middle");
        passed = checkSize(2, arr1.size()) && passed;

        arr1.addLast("back");
        passed = checkSize(3, arr1.size()) && passed;

        System.out.println("Printing out deque: ");
        arr1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<Integer>();
        // should be empty 
        boolean passed = checkEmpty(true, arr1.isEmpty());

        arr1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, arr1.isEmpty()) && passed;

        arr1.removeFirst();
        // should be empty
        passed = checkEmpty(true, arr1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(4);
        arr.addFirst(3);
        arr.addFirst(2);
        arr.addFirst(1);
        int expectedSize = 4;
        Assert.assertEquals(expectedSize, arr.size());
        Assert.assertEquals((long) 1, (long) arr.get(0));
    }

    @Test
    public void addFirstRemoveTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(0);
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);

        arr.isEmpty();
        arr.addFirst(9);
        int actual = arr.removeLast();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(0);
        arr.addLast(1);
        arr.addLast(2);
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.addLast(6);
        arr.addLast(10);
        arr.addFirst(11);
        arr.addLast(12);
        arr.removeLast();
        int actual = arr.removeFirst();
        int expected = 11;
        Assert.assertEquals((long) expected, (long) actual);
    }



    public static void main(String[] args) {
        System.out.println("Running tests.\n");
    }
} 
