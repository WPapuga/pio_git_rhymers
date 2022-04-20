package edu.kis.vh.nursery;
//ctrl + -> przełącza pomiędzy otwartymi oknami w IDE
public class DefaultCountingOutRhymer {

	private static final int CHECK = -1;
	private static final int CAPACITY = 12;
	private static final int FULL = 11;

	private final int[] numbers = new int[CAPACITY];

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private int total = -1;


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
