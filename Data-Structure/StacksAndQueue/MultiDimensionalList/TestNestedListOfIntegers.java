package MultiDimensionalList;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Niraj Gupta
 * Test class to test the methods implemented in the class NestedListOfIntegers.
 *
 */
public class TestNestedListOfIntegers{
	private NestedListOfIntegers nestedListOfInteger;

	@Before
	public void setUp() throws FileNotFoundException, IOException, ParseException{
		nestedListOfInteger = new NestedListOfIntegers();
		Object object = new JSONParser().parse(new FileReader("C:\\Users\\Brothers\\workspace\\GET2018\\src\\MultiDimensionalList\\jsonInput.json"));
		JSONObject inputJsonObject = (JSONObject) object;
		JSONArray jsonArrayOfInputList = (JSONArray) inputJsonObject.get("inputData");
		nestedListOfInteger.listOfIntegers = nestedListOfInteger.createNestedList(nestedListOfInteger.listOfIntegers, jsonArrayOfInputList);
	}

	@Test
	public void calculateSumOfIntegersFromList_HappyFlow(){
		assertEquals(95, nestedListOfInteger.calculateSumOfIntegersFromList(nestedListOfInteger.listOfIntegers));
	}

	@Test
	public void getTheLargestIntegerFromList_HappyFlow(){
		assertEquals(14, nestedListOfInteger.getTheLargestIntegerFromList(nestedListOfInteger.listOfIntegers));
	}

	@Test
	public void findIntegerInList_WhenTheElementIsPresentInTheList(){
		assertTrue(nestedListOfInteger.findIntegerInList(nestedListOfInteger.listOfIntegers, 1));
	}

	@Test
	public void findIntegerInList_WhenTheElementIsNotPresentInTheList(){
		assertFalse(nestedListOfInteger.findIntegerInList(nestedListOfInteger.listOfIntegers, 15));
	}
}
