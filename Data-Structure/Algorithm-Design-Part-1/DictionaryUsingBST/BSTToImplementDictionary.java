package DictionaryUsingBST;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * @author Niraj Gupta
 * Class to implement the Dictionary interface using Binary search tree.
 * 
 * @param <K> : The Data Type assigned to the key of the node.
 * @param <V> : The Data Type assigned to the value of the node.
 */
public class BSTToImplementDictionary<K extends Comparable<K>, V> implements Dictionary<K, V>{
	BSTNode<K, V> root;
	JSONObject jsonObject;
	private List<BSTNode<K, V>> sortedList = new ArrayList<BSTNode<K, V>>();

	/**
	 * Parameterized Constructor
	 * @param jsonObject : The parsed JSONObject.
	 */
	public BSTToImplementDictionary(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}

	/**
	 * Non-Parameterized Constructor.
	 */
	public BSTToImplementDictionary(){
		this.root = null;
	}

	/**
	 * Utility Method to insert data into the tree by calling the insert method.
	 * @param jsonObject : The parsed JSONObject containing the key-value pair 
	 * 						which is to be inserted into the tree.
	 * @throws DuplicateElementInsertionException : When the node to be inserted in the tree 
	 * 												already exists with same key in the tree. 
	 */
	public void insertData(JSONObject jsonObject) throws DuplicateElementInsertionException{
		for(Object key : jsonObject.keySet()){
			insert((K) key, (V) jsonObject.get(key));
		}
	}

	public void insert(K key, V value) throws DuplicateElementInsertionException{
		if(key != null && value != null){
			if(root == null){
				root = new BSTNode<K, V>(key, value);
			}else{
				insertRecursively(root, key, value);
			}
		}else{
			throw new TheKeyValuePairIsNullException("Invalid Input : The key value pair is null.");
		}
	}

	/**
	 * Utility method to insert node into the tree recursively.
	 * @param node : The node is inserted into the tree recursively.
	 * @param key : The node which uniquely identify the value.
	 * @param value : The value which is stores in the node corresponding to a key.
	 * @throws DuplicateElementInsertionException : When the duplicate node is inserted into the tree.
	 */
	private void insertRecursively(BSTNode<K, V> node, K key, V value) throws DuplicateElementInsertionException{
		if(key.compareTo(node.getKey()) == 0){
			throw new DuplicateElementInsertionException("Invalid Input : Dictionary cannot have duplicate value.");
		}else if(key.compareTo(node.getKey()) > 0){
			if(node.getRightChild() == null){
				node.setRightChild(new BSTNode<K, V>(key, value));
			}else{
				insertRecursively(node.getRightChild(), key, value);
			}
		}else if(key.compareTo(node.getKey()) < 0){
			if(node.getLeftChild() == null){
				node.setLeftChild(new BSTNode<K, V>(key, value));
			}else{
				insertRecursively(node.getLeftChild(), key, value);
			}
		}
	}

	public void delete(K key) throws InvalidKeyException{
		if(key != null){
			this.root = deleteRecursively(root, key);
		}else{
			throw new InvalidKeyException("Invalid Input : There is no such key.");
		}
	}

	/**
	 * Method to delete the node recursively.
	 * @param node : The node is inserted into the tree recursively.
	 * @param key : The node which uniquely identify the value.
	 * @return : The node which is deleted from the tree.
	 */
	private BSTNode<K, V> deleteRecursively(BSTNode<K, V> node, K key){
		if(key.compareTo(node.getKey()) == 0){
			if((node.getLeftChild() == null) && (node.getRightChild() == null)){
				return null; 
			}else if((node.getLeftChild() == null) && (node.getRightChild() != null)){
				return node.getRightChild();
			}else if((node.getLeftChild() != null) && (node.getRightChild() == null)){
				return node.getLeftChild();
			}else if((node.getLeftChild() != null) && (node.getRightChild() != null)){
				BSTNode<K, V> replacementNode = findMin(node.getRightChild()); 
				BSTNode<K, V> backupLeft = node.getLeftChild();
				replacementNode.setRightChild(deleteNodeWithTwoChildren(node.getRightChild())); 
				replacementNode.setLeftChild(backupLeft); 
				return replacementNode; 
			}else{
				return node;
			}
		}else if(key.compareTo(node.getKey()) < 0){
			if(node.getLeftChild() != null) {
				node.leftChild = deleteRecursively(node.getLeftChild(), key);
				return node;
			}
		}else{
			if(node.getRightChild() != null){
				node.rightChild = deleteRecursively(node.getRightChild(), key);
				return node;
			}
		}
		return node;
	}

	/**
	 * Method to delete the node which have two children i.e the left and right child.
	 * @param node : The root of the tree from which the node is to be deleted. 
	 * @return : The node which is removed from the tree.
	 */
	private BSTNode<K, V> deleteNodeWithTwoChildren(BSTNode<K, V> node){
		if(node.getLeftChild() == null){
			return node.getRightChild();
		}else{
			node.setLeftChild(deleteNodeWithTwoChildren(node.getLeftChild()));
		}
		return node;
	}

	/**
	 * Method to find the node with minimum key value.
	 * @param node : The root of the tree from which the minimum node is to be searched.
	 * @return : The minimum node present in the tree.
	 */
	private BSTNode<K, V> findMin(BSTNode<K, V> node){
		while(node.getLeftChild() != null){
			node = node.getLeftChild();
		}
		return node;
	}

	public V search(K key){
		BSTNode<K, V> nodeFound;
		nodeFound = searchNode(key);
		if(nodeFound == null){
			return null;
		}else{
			return searchNode(key).getValue();
		}
	}
	/**
	 * Method to select whether to search left child or right child.
	 * @param key : The key which is to be searched.
	 * @return : The node if it is present in the tree, null otherwise.
	 */
	private BSTNode<K, V> searchNode(K key){
		if(key == null){
			return null;
		}
		if(root == null){
			return null; 
		}
		if(key.compareTo(root.getKey()) == 0){
			return root;
		}else if(key.compareTo(root.getKey()) < 0){
			return searchBelow(root.getLeftChild(), key);
		}else if(key.compareTo(root.getKey()) > 0) {
			return searchBelow(root.getRightChild(), key); 
		}else{
			return null;
		}
	}

	/**
	 * Method to search the node in the tree recursively.
	 * @param node : The root node of the tree in which the element to be searched.
	 * @param key : The key which is to be searched.
	 * @return : The node is present in the tree, null otherwise.
	 */
	private BSTNode<K, V> searchBelow(BSTNode<K, V> node, K key){
		if(node == null){
			return null; 
		}
		if(key.compareTo(node.getKey()) == 0){
			return node;
		}else if (key.compareTo(node.getKey()) > 0){
			return searchBelow(node.getRightChild(), key);
		}else if(key.compareTo(node.getKey()) < 0){
			return searchBelow(node.getLeftChild(), key);
		}else{
			return null;
		}
	}

	/**
	 * Method to traverse the tree in in-order because in-order traversal gives the sorted list in BST.
	 * @param node : The root node of the tree.
	 */
	private void inorderTraversal(BSTNode<K, V> node){
		if(node != null){
			inorderTraversal(node.getLeftChild()); 
			sortedList.add(new BSTNode<K, V>(node.getKey(), node.getValue()));
			inorderTraversal(node.getRightChild());
		}
	}

	public List<BSTNode<K, V>> getSortedDictionary(){
		inorderTraversal(root);
		return sortedList;
	}

	public List<BSTNode<K, V>> getSortedDictionaryBetweenARange(K key1, K key2) throws InvalidKeyException{
		if(key1 != null && key2 != null){
			List<BSTNode<K, V>> copiedSortedList = getSortedDictionary();
			List<BSTNode<K, V>> slicedList = new ArrayList<BSTNode<K, V>>();
			int i = 0;
			while(key1.compareTo(copiedSortedList.get(i).getKey()) <= 0
					&& key2.compareTo(copiedSortedList.get(i).getKey()) >= 0){
				slicedList.add(copiedSortedList.get(i));
				i++;
			}
			return slicedList;
		}else{
			throw new InvalidKeyException("Invalid Input : The key is not in the Dictionary.");
		}
	}
}
