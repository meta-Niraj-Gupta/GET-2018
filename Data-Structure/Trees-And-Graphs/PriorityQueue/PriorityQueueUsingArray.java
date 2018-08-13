package PriorityQueue;

/**
 * @author Niraj Gupta
 * Class to represent the priority queue which is implemented using array data structure
 * and the class implements the priority queue interface.
 *
 */
public class PriorityQueueUsingArray implements PriorityQueueInterface{
	private Job[] queue;
	private int rear, front, maxSize;

	public PriorityQueueUsingArray(int maxSize){
		this.maxSize = maxSize;
		queue = new Job[maxSize];
		rear = -1;
		front = -1;
	}

	public boolean enqueue(Job job) throws QueueOverFlowException{
		if(!isFull()){
			if(rear == -1){
				front++;
				rear++;
			}else{
				rear = (rear + 1) % maxSize;
			}
			int pos = -1;
			for(int i = front; i <= (rear - 1) % maxSize; i++){
				if(job.getPriority() > queue[i].getPriority()){
					pos = i;
					break;
				}
			}
			if(pos != -1){
				for(int i = (rear - 1) % maxSize; i >= pos; i--){
					queue[(i + 1) % maxSize] = queue[i];
				}
				queue[pos] = job;
			}else{
				queue[rear] = job;
			}
		}else{
			throw new QueueOverFlowException("The queue is full!");
		}
		return true;
	}

	public Job dequeue() throws QueueUnderFlowException{
		Job job = null;
		if(!isEmpty()){
			if(front == rear){
				job = queue[front];
				front = -1;
				rear = -1;
			}else{
				job = queue[front];
				front = (front + 1) % maxSize;
			}
		}else{
			throw new QueueUnderFlowException("The queue is empty!");
		}
		return job;
	}

	public boolean isEmpty(){
		return rear == -1 && front == -1;
	}

	public boolean isFull(){
		return front == 0 && rear == maxSize-1;
	}

	public int getSize(){
		return maxSize;
	}
}
