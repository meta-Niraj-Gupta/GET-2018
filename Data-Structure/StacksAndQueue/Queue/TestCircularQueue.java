package Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCircularQueue{
	CircularQueue<Integer> queueTest;

	@Before
	public void setUp(){
		queueTest = new CircularQueue<Integer>(20);
	}

	@Test
	public void enqueue_HappyFlow(){
		for(int i = 0; i < 20; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.enqueue(temp);
			assertEquals(temp, queueTest.getRear());
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void enqueue_Exception(){
		for(int i = 0; i < 22; i++){
			Integer temp = (int) Math.random() * 100;
			queueTest.enqueue(temp);
		}
	}
	
	@Test
	public void Dequeue_HappyFlow(){
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

	@Test(expected = IndexOutOfBoundsException.class)
	public void Dequeue_Exception(){
		queueTest.dequeue();
	}

	@Test
	public void getFront_HappyFlow(){
        queueTest.enqueue(5);
        assertEquals((Integer) 5, queueTest.getFront());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getFront_Exception(){
		queueTest.getFront();
	}
	
	@Test
	public void size_WhenQueueIsEmpty(){
		assertEquals(0, queueTest.size());
	}
	
	@Test
	public void size_WhenQueueHasElement(){
		for(int i = 0; i < 10; i++){
			queueTest.enqueue((int) Math.random() * 100);
		}
		assertEquals(10, queueTest.size());
	}
}
