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
	public void testenqueue() {
		for(int i = 0; i < 22; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.enqueue(temp);
			assertEquals(temp, queueTest.getFront());
		}
	}

	@Test
	public void testRemove() {
		Integer[] testData = new Integer[20];
		for(int i = 0; i < 20; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.enqueue(temp);
			testData[i] = temp;
		}
		
		for(int i = 0; i < testData.length; i++){
			assertEquals(testData[i], queueTest.dequeue());
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testdequeueError() {
		queueTest.dequeue();
	}

	@Test
	public void testGetFront() {
        queueTest.enqueue(5);
        assertEquals((Integer) 5, queueTest.getFront());
	}
	
	@Test
	public void testSize(){
		assertEquals(0, queueTest.size());
		for(int i = 0; i < 10; i++){
			queueTest.enqueue((int) Math.random() * 100);
		}
		assertEquals(10, queueTest.size());
		queueTest.dequeue();
		assertEquals(9, queueTest.size());
	}
}
