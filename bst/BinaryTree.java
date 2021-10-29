// code adapted from CS1501 midterm with Dr. Khattab
public class BinaryTree<T> {
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
            if (isFull(root)) result = true;
            if (isComplete(root.getLeftChild()) && root.getLeftChild().getHeight() >= 1) {
                if (isFull(root.getRightChild()) && root.getRightChild().getHeight() == root.getHeight() - 1) {
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
            
        }
    }
}