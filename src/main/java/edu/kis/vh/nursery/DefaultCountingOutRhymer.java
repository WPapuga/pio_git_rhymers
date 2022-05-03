package edu.kis.vh.nursery;


//ctrl + -> przełącza pomiędzy otwartymi oknami w IDE
/**
 * DefaultCountingOutRhymer is a class which works like a stack and can be generated with DefaultRhymersFactory class
 *
 * @see edu.kis.vh.nursery.factory.DefaultRhymersFactory
 */
public class DefaultCountingOutRhymer {

	/**
	 * private constant used in callCheck() function
	 */
	private static final int CHECK = -1;
	/**
	 * private constant that represents maximum capacity of numbers
	 */
	private static final int CAPACITY = 12;
	/**
	 * private constant used in isFull() function
	 */
	private static final int FULL = 11;

	/**
	 * private array of ints with maximum Capacity set with CAPACITY constant, used to store numbers
	 */
	private final int[] numbers = new int[CAPACITY];

	/**
	 * this is getter Function for total parameter
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * private int used to index numbers array, it points to last number in numbers array
	 * when numbers array is empty, total equals -1
	 */
	private int total = -1;

	/**
	 * this method adds its argument to numbers array when this array is not full
	 *
	 * @param in stores the int that is going to be added to numbers array
	 */
	public void countIn(int in) {
		if (!isFull())
			numbers[++total] = in;
	}

	//TODO: function callCheck could be changed to isEmpty. It will be easier to understand what this function does
	/**
	 * this method checks if the numbers array is empty
	 *
	 * @return true if numbers is empty, false otherwise
	 */
	public boolean callCheck() {
		return total == CHECK;
	}

	/**
	 * this method checks if the numbers array is full
	 *
	 * @return true if numbers is full, false otherwise
	 */
	public boolean isFull() {
		return total == FULL;
	}

	/**
	 * this method returns last added element to numbers array without deleting it
	 *
	 * @return last added element to numbers, -1 if numbers is empty
	 */
	protected int peekaboo() {
		if (callCheck())
			return CHECK;
		return numbers[total];
	}

	/**
	 * this method returns last added element to numbers arrary and deletes it by decrementing total
	 *
	 * @return last added element to numbers, -1 if numbers is empty
	 */
	public int countOut() {
		if (callCheck())
			return CHECK;
		return numbers[total--];
	}

}
