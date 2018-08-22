package DictionaryUsingBST;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class TestBSTToImplementDictionary{
	private Dictionary<String, String> dictionary;
	private JSONObject jsonObject;

	@Before
	public void setUp() throws ParseException, DuplicateElementInsertionException{
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse("{\"1\":\"one\", \"2\":\"two\", \"3\":\"three\", \"4\":\"four\", \"5\":\"five\"}");
		dictionary = new BSTToImplementDictionary<String, String>(jsonObject);
		((BSTToImplementDictionary<String, String>) dictionary).insertData(jsonObject);
	}

	@Test
	public void insert_HappyFlow(){
		assertEquals("two", dictionary.search("2"));
		assertEquals("five", dictionary.search("5"));
	}

	@Test
	public void insert_Exception_WhenDuplicateElementisInserted(){
		try{
			dictionary.insert("2", "two");
		}catch(DuplicateElementInsertionException exception){
			assertEquals("Invalid Input : Dictionary cannot have duplicate value.", exception.getMessage());
		}
	}

	@Test
	public void insert_Exception_WhenEitherorBothKeyValueAreNull() throws DuplicateElementInsertionException{
		try {
			dictionary.insert(null, "two");
		}catch(TheKeyValuePairIsNullException exception){
			assertEquals("Invalid Input : The key value pair is null.", exception.getMessage());
		}
	}

	@Test
	public void delete_HappyFlow() throws InvalidKeyException{
		assertEquals("two", dictionary.search("2"));
		dictionary.delete("2");
		assertEquals(null, dictionary.search("2"));
	}

	@Test
	public void delete_Exception_WhenTheKeyEnteredIsNull(){
		try{
			dictionary.delete(null);
		}catch(InvalidKeyException exception){
			assertEquals("Invalid Input : There is no such key.", exception.getMessage());
		}
	}

	@Test
	public void search_HappyFlow(){
		assertEquals("three", dictionary.search("3"));
	}

	@Test
	public void search_ReturnNull_WhenTheKeyIsNotInTheTree(){
		assertEquals(null, dictionary.search("6"));
	}

	@Test
	public void getSortedDictionary_HappyFlow(){
		List<BSTNode<String, String>> actualSortedDictionary = dictionary.getSortedDictionary();
		List<BSTNode<String, String>> expectedSortedDictionary = new ArrayList<BSTNode<String, String>>(
				Arrays.asList(new BSTNode<String, String>("1", "one"), 
						new BSTNode<String, String>("2", "two"),
						new BSTNode<String, String>("3", "three"),
						new BSTNode<String, String>("4", "four"),
						new BSTNode<String, String>("5", "five")));

		for(int i = 0; i < actualSortedDictionary.size(); i++){
			assertEquals(expectedSortedDictionary.get(i).getKey(), actualSortedDictionary.get(i).getKey());
			assertEquals(expectedSortedDictionary.get(i).getValue(), actualSortedDictionary.get(i).getValue());
		}
	}

	@Test
	public void getSortedDictionaryBetweenARange_HappyFlow() throws InvalidKeyException{
		List<BSTNode<String, String>> actualSortedDictionary = dictionary.getSortedDictionaryBetweenARange("3", "5");
		List<BSTNode<String, String>> expectedSortedDictionary = new ArrayList<BSTNode<String, String>>(
				Arrays.asList(new BSTNode<String, String>("3", "three"),
						new BSTNode<String, String>("4", "four"),
						new BSTNode<String, String>("5", "five")));

		for(int i = 0; i < actualSortedDictionary.size(); i++){
			assertEquals(expectedSortedDictionary.get(i).getKey(), actualSortedDictionary.get(i).getKey());
			assertEquals(expectedSortedDictionary.get(i).getValue(), actualSortedDictionary.get(i).getValue());
		}
	}

	@Test
	public void getSortedDictionaryBetweenARange_Exception_WhenEitherKeyIsNull(){
		try{
			dictionary.getSortedDictionaryBetweenARange(null, "5");
		}catch(InvalidKeyException exception){
			assertEquals("Invalid Input : The key is not in the Dictionary.", exception.getMessage());
		}
	}
}
