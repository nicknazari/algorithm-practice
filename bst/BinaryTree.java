import java.util.Stack;

import javax.lang.model.util.ElementScanner14;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

  public static void main(String[] args) {
    BinaryTree<Integer> x = new BinaryTree<Integer>();
    x.buildTree(5);
    x.buildTree(5);
    x.inorderTraverse();
  }
  private BinaryNode<T> root;

  protected void setRoot(BinaryNode<T> root){
    this.root = root;
  }

  public void clear(){
    root = null;
  }

  public BinaryTree(){
    root = null;
  }

  public BinaryTree(T rootData){
    privateBuildTree(rootData, null, null);
  }

  public BinaryTree(T rootData, BinaryTree<T> leftTree,
                    BinaryTree<T> rightTree){
    privateBuildTree(rootData, leftTree, rightTree);
  }

  public void buildTree(T rootData) {
    privateBuildTree(rootData, null, null);
  }

  public void buildTree(T rootData,
                        BinaryTreeInterface<T> left,
                        BinaryTreeInterface<T> right) {
    privateBuildTree(rootData, (BinaryTree<T>)left, (BinaryTree<T>)right);
  }

  private void privateBuildTree(T rootData, BinaryTree<T> leftTree,
                                BinaryTree<T> rightTree){
      root = new BinaryNode<>(rootData);
      if((leftTree != null) && (!leftTree.isEmpty())){
        root.setLeftChild(leftTree.getRoot());
      }
      if((rightTree != null)&&(!rightTree.isEmpty())){
        if(leftTree == rightTree) {
          root.setRightChild(rightTree.getRoot().copy());
        } else {
          root.setRightChild(rightTree.getRoot());
        }
      }

      if((leftTree!=null)&&(leftTree != this)){
        leftTree.clear();
      }
      if((rightTree != null)&&(rightTree != this)){
        rightTree.clear();
      }
  }

  public T getRootData() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getData();
  }

  protected BinaryNode<T> getRoot(){
    return root;
  }
  public int getHeight() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getHeight();
  }
  public int getNumberOfNodes() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getNumberOfNodes();
  }

  public boolean isEmpty(){
    return root == null;
  }
  public void levelOrderTraverse(){

  }


  public void preorderTraverse(){
    //preorderTraverse(root);
    iterativePreOrder();
  }

  public void inorderTraverse(){
    //inorderTraverse(root);
    iterativeInOrder();
  }
  public void postorderTraverse(){
    //postorderTraverse(root);
    iterativePostOrder();
  }

  private void preorderTraverse(BinaryNode<T> root){
    if(root != null){
      //visit the root
      System.out.println(root.getData());
      //left
      preorderTraverse(root.getLeftChild());
      //right
      preorderTraverse(root.getRightChild());
    }
  }

  private void inorderTraverse(BinaryNode<T> root){
    if(root != null){
      //left
      inorderTraverse(root.getLeftChild());
      //visit the root
      System.out.println(root.getData());
      //right
      inorderTraverse(root.getRightChild());
      //have you seen about time?
    }
  }

  private void postorderTraverse(BinaryNode<T> root){
    if(root != null){
      //left
      postorderTraverse(root.getLeftChild());
      //right
      postorderTraverse(root.getRightChild());
      //visit the root
      System.out.println(root.getData());
    }
  }

  private void iterativeInOrder(){
    Stack<BinaryNode<T>> nodeStack =
      new Stack<>();
    BinaryNode<T> currentNode = root;

    while (!nodeStack.isEmpty()
          || (currentNode != null)){
       // Find leftmost node with no left child
       while (currentNode != null)
       {
          nodeStack.push(currentNode);
          currentNode = currentNode.getLeftChild();
       } // end while

       // Visit leftmost node, then traverse its right subtree
       if (!nodeStack.isEmpty())
       {
          BinaryNode<T> nextNode = nodeStack.pop();
          System.out.print(nextNode.getData() + " ");
          currentNode = nextNode.getRightChild();
       } // end if
    } // end while
  }

  private void iterativePreOrder(){
    Stack<BinaryNode<T>> nodeStack =
      new Stack<>();
    if (root != null)
       nodeStack.push(root);
    BinaryNode<T> nextNode;
    while (!nodeStack.isEmpty()){
      nextNode = nodeStack.pop();
      System.out.print(nextNode.getData() + " ");
      BinaryNode<T> leftChild = nextNode.getLeftChild();
      BinaryNode<T> rightChild = nextNode.getRightChild();

      // Push into stack in reverse order of recursive calls
      if (rightChild != null)
        nodeStack.push(rightChild);

      if (leftChild != null)
        nodeStack.push(leftChild);
    } // end while
  }

  private void iterativePostOrder(){
    Stack<BinaryNode<T>> nodeStack = new Stack<>();
    BinaryNode<T> currentNode;
    BinaryNode<T> leftChild, rightChild, nextNode = null;

    currentNode = root;
    while(!nodeStack.isEmpty()
          || (currentNode != null)){
       // Find leftmost leaf
       while (currentNode != null){
          nodeStack.push(currentNode);
          leftChild = currentNode.getLeftChild();
          if (leftChild == null)
             currentNode = currentNode.getRightChild();
          else
             currentNode = leftChild;
       } // end while

       // Stack is not empty either because we just pushed a node, or
       // it wasn't empty to begin with.
       if (!nodeStack.isEmpty())
       {
          nextNode = nodeStack.pop();
          System.out.print(nextNode.getData() + " ");
          BinaryNode<T> parent = null;
          if (!nodeStack.isEmpty())
          {
             parent = nodeStack.peek();
             if (nextNode == parent.getLeftChild())
                currentNode = parent.getRightChild();
             else
                currentNode = null;
          }
          else
             currentNode = null;
       }
     }
    }
  
    private Boolean isFull(BinaryNode<T> root) {
      Boolean result = false;
      if (root == null) {
          result = true;
      } else {
          result = isFull(root.getLeftChild()) 
          && isFull(root.getRightChild()) 
          && root.getLeftChild().getHeight() == root.getRightChild().getHeight();
      }
      return result;
  }

  private Boolean isComplete(BinaryNode<T> root) {
      Boolean result = false;
      if (root == null) result = true;
      else {
          if (isFull(root)) {
            result = true;
          } else if (root.getLeftChild() != null) {
            if (isComplete(root.getLeftChild()) && root.getLeftChild().getHeight() >= 1) {
              if (root.getRightChild() != null) {
                if (isFull(root.getRightChild()) && root.getRightChild().getHeight() == root.getHeight() - 1) {
                  result = true;
                }
              }
            }
          } else {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
              result = true;
            }
          }
      }
      return result;
  }

  private int countInRange(BinaryNode<T> root, T low, T high) {
      int result = 0;
      if (root != null) {
          int cmpLow = root.getData().compareTo(low);
          int cmpHigh = root.getData().compareTo(high);
          // root.compareTo(number)
          // returns < 0 if root is less than number
          // returns 0 if equal
          // returns > 0 if root is greater than number

          // if root.data < low, recur on right subtree only
          // cmplow < 0
          // cmp.low is finding root.compareto low
          // if root.data > high, recur on left subtree only
          // cmphigh > 0
          // root is higher than high
          // otherwise, recur on both subtrees and add 1
          if (cmpLow < 0) {
            return countInRange(root.right, low, high);
          } else if (cmpHigh > 0) {
            return countInRange(root.left, low, high);
          } else {
            result += 1;
            result += countInRange(root.right, low, high);
            result += countInRange(root.left, low, high);
          }

      }
      return result;
  }

}