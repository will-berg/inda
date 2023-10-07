import java.util.ArrayList;

/**
 * Class for a binary search tree.
 *
 * @author William Berg
 * @version 2020-02-09
 */
public class Tree<T extends Comparable<T>>  {
    private Node<T> root;
    private int size;
    private ArrayList list;

    /**
     * Creates an empty tree.
     */
    public Tree() {
        root = null;
        size = 0;
    }

    /**
     * A node in the tree.
     * @param <T> generic type.
     */
    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Searches for a value in the binary search tree.
     *
     * elem.compareTo(root.value) returns
     * -1 if elem < root.value
     * 1 if elem > root.value
     * 0 if elem == root.value
     *
     * @param elem value to search for.
     * @return true if value is in the tree, false if it is not.
     */
    public boolean search(T elem) {
        Node<T> currentNode = root;
        while (currentNode != null) {
            if (elem.compareTo(currentNode.value) == 0) {
                return true;
            }
            if (elem.compareTo(currentNode.value) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    /**
     * Adds a value to the tree; duplicates are not allowed.
     *
     * @param elem value to be added to the tree.
     * @return true, if the element is not already in the tree (and is therefore inserted)
     *         false, if the element is already in the tree.
     */
    public boolean insert(T elem) {
        Node<T> elemNode = new Node<T>(elem);
        if (isEmpty()) {
            root = elemNode;
            size++;
            return true;
        }
        Node<T> temp = null;
        Node<T> currentNode = root;
        while (currentNode != null) {
            temp = currentNode;
            if (elem.compareTo(currentNode.value) == 0) {
                return false;
            }
            if (elem.compareTo(currentNode.value) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        if (elem.compareTo(temp.value) == 0) {
            return false;
        }
        if (elem.compareTo(temp.value) < 0) {
            temp.left = elemNode;
            size++;
            return true;
        } else {
            temp.right = elemNode;
            size++;
            return true;
        }
    }

    /**
     *
     * @return the size of the tree (number of elements in the tree)
     */
    public int size() {
        return size;
    }

    /**
     *
     * @return the height of the tree.
     */
    public int height() {
        return height(root);
    }

    // Private helper method for public int height()
    private int height(Node node) {
        if (node == null || isLeaf(node)) {
            return 0;
        }
        int leftTreeHeight = height(node.left);
        int rightTreeHeight = height(node.right);
        if (leftTreeHeight < rightTreeHeight) {
            return rightTreeHeight + 1;
        } else {
            return leftTreeHeight + 1;
        }
    }

    /**
     *
     * @return the number of leaves in the tree.
     */
    public int leaves() {
        return leaves(root);
    }

    // Private helper method for public int leaves()
    public int leaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        else return leaves(node.left) + leaves(node.right);
    }

    // Determine if the node is a leaf node
    private boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        } else {
            return node.left == null && node.right == null;
        }
    }

    /**
     *
     * @return a string describing the tree.
     */
    public String toString() {
        list = new ArrayList<>();
        return toString(root);
    }

    // Private helper method for public String toString()
    private String toString(Node node) {
        if (node == null) {
            return "[]";
        }
        // Inorder traversal
        toString(node.left);
        list.add(node.value);
        toString(node.right);
        return list.toString();
    }

    /**
     *
     * @return the number of leaves in the tree.
     */
    private boolean isEmpty() {
        return root == null;
    }
}
