package StackDataStructure;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TestStackUsingArray{
	StackUsingArray<Integer> stack;
	
	@Before
    public void beforeTestSetUp(){
        stack = new StackUsingArray<Integer>(20);
    }

    @Test
    public void testPush() throws Exception{
    	try{
    		for(int i = 0; i < 22; i++){
    			Integer temp = (int) Math.random() * 100;
    			stack.push((int) Math.random() * 100);
    			assertEquals(temp, stack.getTopElement());
    		}
    	}catch(IndexOutOfBoundsException exception){
    		assertEquals("OverFlow : The stack is full.", exception.getMessage());
    	}
    }

    @Test
    public void testPop(){
    		Integer[] testData = new Integer[20];

    		for(int i = 0; i < 20; i++){
    			testData[i] = (int) Math.random() * 100;
    			stack.push(testData[i]);
    		}

    		for(int i = testData.length - 1; i >= 0; i--){
    			assertEquals(testData[i], stack.pop());
    		}
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPop() {
        stack.pop();
    }
    
    @Test
    public void testGetTopElement() throws Exception{
        for(int i = 0; i < 20; i++){
            Integer temp = (int) Math.random() * 100;
            stack.push(temp);
            assertEquals(temp, stack.getTopElement());
        }
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testGetTopElementWhenStackIsEmpty() throws Exception {
        stack.getTopElement();
    }

    @Test
    public void testIsEmpty(){
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(false, stack.isEmpty());
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }
    
    @Test
    public void testIsFull(){
    	assertEquals(false, stack.isFull());
    	for(int i = 0; i < 20; i++){
			stack.push((int) Math.random() * 100);
		}
        assertEquals(true, stack.isFull());
        stack.pop();
        assertEquals(false, stack.isFull());
    }
    
    @Test
    public void testSize(){
    	assertEquals(0, stack.size());
    	for(int i = 0; i < 20; i++){
			stack.push((int) Math.random() * 100);
		}
        assertEquals(20, stack.size());
        stack.pop();
        assertEquals(19, stack.size());
    }

}
