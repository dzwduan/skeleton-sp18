import org.junit.Assert;
import org.junit.Test;
public class LinkedListDequeTest {
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
	public static void addIsEmptySizeTest() {
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	@Test
	public void addRemoveTest() {


		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	@Test
	public void addFirstTest() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addFirst(4);
		lld.addFirst(3);
		lld.addFirst(2);
		lld.addFirst(1);
		int expectedSize = 4;
		Assert.assertEquals(expectedSize, lld.size());
		Assert.assertEquals((long) 1, (long) lld.get(0));
	}

	@Test
	public void removeFirstTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		lld1.addLast(0);
		lld1.addLast(1);
		lld1.addLast(2);
		lld1.addLast(3);
		int actual = lld1.removeFirst();

		int expectedSize = 3;
		Assert.assertEquals(expectedSize, lld1.size());
		Assert.assertEquals((long) 0, (long) actual);
	}

	@Test
	public void getTest() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		lld.addLast(1);
		lld.removeLast();
		int actual = lld.get(0);
		int expected = 0;
		Assert.assertEquals((long) expected, (long) actual);
	}

	@Test
	public void getRecursiveTest() {
		LinkedListDeque<Integer> lld = new LinkedListDeque<>();
		lld.addLast(0);
		lld.removeFirst();
		lld.addLast(2);
		lld.removeFirst();
		lld.addFirst(4);
		lld.removeLast();
		lld.addLast(7);
		lld.addFirst(8);

		int actual = lld.getRecursive(1);
		int actual2 = lld.get(1);
		int expected = 7;
		Assert.assertEquals((long) expected, (long) actual);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		//addRemoveTest();
	}
} 