package QueueDataStructure;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

public class TestQueueUsingArray{
	Queue<Integer> queueTest;

	@Before
	public void setUp() throws Exception{
		queueTest = new QueueUsingArray<Integer>(20);
	}

	@Test
	public void testEnqueue() {
		try{
			for(int i = 0; i < 22; i++){
				Integer temp = (int) Math.random() * 100;
				queueTest.enqueue(temp);
				assertEquals(temp, queueTest.getFront());
			}
		}catch(IllegalArgumentException exception){
			assertEquals("OverFlow : No space to store more elements", exception.getMessage());
		}
	}

	@Test
	public void testDequeue() {
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
	public void testDequeueError() {
		queueTest.dequeue();
	}

	@Test
	public void testGetFront() {
        queueTest.enqueue(5);
        assertEquals((Integer) 5, queueTest.getFront());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetFrontError() {
		queueTest.getFront();
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
