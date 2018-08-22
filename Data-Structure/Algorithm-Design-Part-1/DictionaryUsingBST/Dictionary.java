package DictionaryUsingBST;

import java.util.List;

/**
 * @author Niraj Gupta
 * Interface to represent the Dictionary which contains key and value pair.
 * 
 * @param <K> : The Data Type assigned to the key of the node.
 * @param <V> : The Data Type assigned to the value of the node.
 */
public interface Dictionary<K extends Comparable<K>, V>{

	/**
	 * Method to insert a key - value in the dictionary.
	 * @param key : The key is used to uniquely identify the element in the tree.
	 * @param value : The value stored defines the meaning of the key.
	 * @throws DuplicateElementInsertionException : When the duplicate element is inserted.
	 */
	void insert(K key, V value) throws DuplicateElementInsertionException;

	/**
	 * Method to delete a node if present in the tree.
	 * @param key : The key which is to be deleted from the tree if available.
	 * @throws InvalidKeyException : When the given key is not present in the tree.
	 */
	void delete(K key) throws InvalidKeyException;

	/**
	 * Method to search a value in from the dictionary if the given key is present in the tree.
	 * @param key : The key which is to be searched from the tree if available.
	 * @return : The value corresponding to the given key if it is present in the tree, null otherwise.
	 */
	V search(K key);

	/**
	 * Method to sort the dictionary based on the key.
	 * @return : The List of node sorted in ascending order. 
	 */
	List<BSTNode<K, V>> getSortedDictionary();

	/**
	 * Method to get the key-value pair from a given range of keys.
	 * @param key1 : The starting key(inclusive). 
	 * @param key2 : The ending key(inclusive).
	 * @return : The list of nodes from the starting key to an ending key.
	 * @throws InvalidKeyException : When the key provided is null.
	 */
	List<BSTNode<K, V>> getSortedDictionaryBetweenARange(K key1, K key2) throws InvalidKeyException;
}
