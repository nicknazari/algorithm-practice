class BSTNode<T extends Comparable<T>> {
	
	private T data;
	BSTNode<T> rightChild;
	BSTNode<T> leftChild;

	public BSTNode() { 
		new BSTNode();
		this.data = null;
	}

	private BSTNode(BSTNode leftChild, BSTNode rightChild, T data) { 
		new BSTNode();
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}
}
