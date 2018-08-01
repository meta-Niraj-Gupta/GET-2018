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
	public void testAdd() {
		try{
			for(int i = 0; i < 22; i++){
				Integer temp = (int) Math.random() * 100;
				queueTest.add(temp);
				assertEquals(temp, queueTest.getFront());
			}
		}catch(IllegalArgumentException exception){
			assertEquals("OverFlow : No space to store more elements", exception.getMessage());
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
	
	@Test(expected = NoSuchElementException.class)
	public void testGetFrontError() {
		queueTest.getFront();
	}
}
