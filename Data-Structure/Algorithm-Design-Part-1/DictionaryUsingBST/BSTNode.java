package DictionaryUsingBST;

/**
 * @author Niraj Gupta
 * Class to create a node which is inserted in the Tree. Each node has key and value and reference to their 
 * left and right child node.
 * 
 * @param <K> : The Data Type assigned to the key of the node.
 * @param <V> : The Data Type assigned to the value of the node.
 */
public class BSTNode<K extends Comparable<K>, V>{
	protected K key;
	protected V value;
	protected BSTNode<K, V> leftChild, rightChild;

	/**
	 * Parameterized Constructor : To create a node of the tree.
	 * @param key : The key which is used to represent the value in the node.
	 * @param value : The value which is stored in the node corresponding to a key.
	 */
	public BSTNode(K key, V value){
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	public K getKey(){
		return key;
	}

	public V getValue(){
		return value;
	}

	public BSTNode<K, V> getLeftChild(){
		return leftChild;
	}

	public BSTNode<K, V> getRightChild(){
		return rightChild;
	}

	public void setValue(V value){
		this.value = value;
	}

	public void setLeftChild(BSTNode<K, V> node){
		leftChild = node;
	}

	public void setRightChild(BSTNode<K, V> node){
		rightChild = node;
	}
}
