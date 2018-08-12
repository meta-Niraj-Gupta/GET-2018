package PriorityQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPriorityQueue{
	PriorityQueueUsingArray queue;

	@Before
	public void setUp(){
		queue = new PriorityQueueUsingArray(5);
	}

	@Test
	public void enqueue_HappyFlow() throws QueueOverFlowException{
		for(int i = 0; i < queue.getSize(); i++){
			assertTrue(queue.enqueue(new Job(i+1, i)));
		}
	}

	@Test
	public void enqueue_Exception_QueueOverFlow(){
		try{
			for(int i = 0; i < queue.getSize()+1; i++){
				assertTrue(queue.enqueue(new Job(i+1, i)));
			}
		}catch(QueueOverFlowException exception){
			assertEquals("The queue is full!", exception.getMessage());
		}
	}

	@Test
	public void dequeue_HappyFlow() throws QueueOverFlowException, QueueUnderFlowException{
		for(int i = 0; i < queue.getSize(); i++){
			queue.enqueue(new Job(i+1, i));
		}
		for(int i = queue.getSize()-1; i >= 0; i--){
			assertEquals(i+1, queue.dequeue().getValue());
		}
	}

	public void dequeue_Exception_QueueUnderFlow(){
		try{
			queue.dequeue();
		}catch(QueueUnderFlowException exception){
			assertEquals("The queue is empty!", exception.getMessage());
		}
	}

	@Test
	public void isEmpty_WhenQueueIsEmpty(){
		assertTrue(queue.isEmpty());
	}

	@Test
	public void isEmpty_WhenQueueIsNotEmpty() throws QueueOverFlowException{
		for(int i = 0; i < queue.getSize(); i++){
			queue.enqueue(new Job(i+1, i));
		}
		assertFalse(queue.isEmpty());
	}

	@Test
	public void isFull_WhenQueueIsFull() throws QueueOverFlowException {
		for(int i = 0; i < queue.getSize(); i++){
			queue.enqueue(new Job(i+1, i));
		}
		assertTrue(queue.isFull());
	}

	@Test
	public void isFull_WhenQueueIsNotFull() throws QueueOverFlowException {

		for(int i = 0; i < queue.getSize()-1; i++){
			queue.enqueue(new Job(i+1, i));
		}
		assertFalse(queue.isFull());
	}
}
