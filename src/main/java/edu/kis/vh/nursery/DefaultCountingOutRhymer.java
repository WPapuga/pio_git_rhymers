package edu.kis.vh.nursery;
//ctrl + -> przełącza pomiędzy otwartymi oknami w IDE
public class DefaultCountingOutRhymer {

	public static final int CHECK = -1;
	public static final int CAPACITY = 12;
	public static final int FULL = 11;

	private final int[] numbers = new int[CAPACITY];
	public int total = -1;


	public void countIn(int in) {
		if (!isFull())
			numbers[++total] = in;
	}

	public boolean callCheck() {
		return total == CHECK;
	}

	public boolean isFull() {
		return total == FULL;
	}

	protected int peekaboo() {
		if (callCheck())
			return CHECK;
		return numbers[total];
	}

	public int countOut() {
		if (callCheck())
			return CHECK;
		return numbers[total--];
	}

}
