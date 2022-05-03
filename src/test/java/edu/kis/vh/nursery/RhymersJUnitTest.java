package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

	final int TEST_VALUE_FIRST = 4;
	final int TEST_VALUE_SECOND = 888;
	final int TEST_VALUE_THIRD = 2;
	final int STACK_CAPACITY = 12;
	final int EMPTY_STACK_VALUE = -1;



	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		rhymer.countIn(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.peekaboo());
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		Assert.assertTrue(rhymer.callCheck());
		rhymer.countIn(TEST_VALUE_SECOND);
		Assert.assertFalse(rhymer.callCheck());
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		for (int i = 0; i < STACK_CAPACITY; i++) {
			Assert.assertFalse(rhymer.isFull());
			rhymer.countIn(TEST_VALUE_SECOND);
		}

		Assert.assertTrue(rhymer.isFull());
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());
		rhymer.countIn(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.peekaboo());
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.peekaboo());
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
		rhymer.countIn(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.countOut());
		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
	}

	@Test
	public void testFIFOCountOut() {
		FIFORhymer rhymer = new FIFORhymer();

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
		rhymer.countIn(TEST_VALUE_FIRST);
		rhymer.countIn(TEST_VALUE_SECOND);
		Assert.assertEquals(TEST_VALUE_FIRST,rhymer.countOut());
		Assert.assertEquals(TEST_VALUE_SECOND,rhymer.countOut());
		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
	}

	@Test
	public void testHanoiCountIn() {
		HanoiRhymer rhymer = new HanoiRhymer();

		rhymer.countIn(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.peekaboo());

		rhymer.countIn(TEST_VALUE_SECOND);
		Assert.assertEquals(TEST_VALUE_FIRST, rhymer.peekaboo());

		rhymer.countIn(TEST_VALUE_THIRD);
		Assert.assertEquals(TEST_VALUE_THIRD, rhymer.peekaboo());
	}

	@Test
	public void testHanoiReportRejected() {
		HanoiRhymer rhymer = new HanoiRhymer();

		Assert.assertEquals(0,rhymer.reportRejected());

		rhymer.countIn(TEST_VALUE_FIRST);
		Assert.assertEquals(0,rhymer.reportRejected());

		rhymer.countIn(TEST_VALUE_SECOND);
		Assert.assertEquals(1, rhymer.reportRejected());

		rhymer.countIn(TEST_VALUE_THIRD);
		Assert.assertEquals(1, rhymer.reportRejected());
	}

	@Test
	public void testIntLinkedListPush() {
		IntLinkedList list = new IntLinkedList();

		list.push(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, list.top());

		list.push(TEST_VALUE_SECOND);
		Assert.assertEquals(TEST_VALUE_SECOND, list.top());
	}

	@Test
	public void testIntLinkedListIsEmpty() {
		IntLinkedList list = new IntLinkedList();

		Assert.assertTrue(list.isEmpty());

		list.push(TEST_VALUE_FIRST);
		Assert.assertFalse(list.isEmpty());

		list.pop();
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testIntLinkedListIsFull() {
		IntLinkedList list = new IntLinkedList();
		Assert.assertFalse(list.isFull());
	}

	@Test
	public void testIntLinkedListTop() {
		IntLinkedList list = new IntLinkedList();

		list.push(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, list.top());

		list.pop();
		Assert.assertEquals(EMPTY_STACK_VALUE, list.top());
	}

	@Test
	public void testIntLinkedListPop() {
		IntLinkedList list = new IntLinkedList();

		Assert.assertEquals(EMPTY_STACK_VALUE, list.pop());
		list.push(TEST_VALUE_FIRST);
		Assert.assertEquals(TEST_VALUE_FIRST, list.pop());
		Assert.assertEquals(EMPTY_STACK_VALUE, list.pop());
	}


}