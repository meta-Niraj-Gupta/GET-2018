package QueueDataStructure;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TestQueueUsingLinkList {
	Queue<Integer> queueTest;

	@Before
	public void setUp() throws Exception{
		queueTest = new QueueUsingLinkList<Integer>();
	}

	@Test
	public void testAdd() {
		for(int i = 0; i < 22; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.add(temp);
			assertEquals(temp, queueTest.getFront());
		}
	}

	@Test
	public void testRemove() {
		Integer[] testData = new Integer[20];
		for(int i = 0; i < 20; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.add(temp);
			testData[i] = temp;
		}
		
		for(int i = 0; i < testData.length; i++){
			assertEquals(testData[i], queueTest.poll());
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testPollError() {
		queueTest.poll();
	}

	@Test
	public void testGetFront() {
        queueTest.add(5);
        assertEquals((Integer) 5, queueTest.getFront());
	}
}
