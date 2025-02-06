package com.srvivek.dsalgo.binarytree;

import java.util.Iterator;

/**
 * Alert: This implementation is not fully functional yet.
 * <p>
 * A Binary search tree implementation.
 * Ref: https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/datastructures/binarysearchtree/BinarySearchTree.java
 *
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> {


    /*
     * Tracks the number of nodes in the BST
     */
    private int nodeCount = 0;

    /*
     * This BST is a rooted tree, so maintaining a reference to root node.
     */
    private Node root = null;

    /**
     * Internal Node containing node references and actual data.
     */
    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.left = left;
            this.right = right;
            this.data = elem;
        }
    }

    /**
     * Get the number of nodes present in this BST.
     *
     * @return nodes count
     */
    public int size() {
        return nodeCount;
    }

    /**
     * Returns true is no nodes are present in tree.
     *
     * @return true / false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if object/data exists in tree.
     *
     * @param elem data to be searched
     * @return true if found
     */
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    /**
     * Find element in tree O(log n)
     *
     * @param root root node
     * @param elem data to be searched
     * @return true if found
     */
    private boolean contains(Node root, T elem) {
        if (root == null || elem == null) return false;

        int cmp = elem.compareTo(root.data);

        if (cmp < 0) {
            // elem is smaller than data -- check in left subtree
            return contains(root.left, elem);
        } else if (cmp > 0) {
            // elem is greater than data -- check in left subtree
            return contains(root.right, elem);
        } else {
            return true;
        }
    }

    /**
     * Add elem to BT returns true on successful insertion.
     * No duplicates are allowed.
     *
     * @param elem data to be added
     * @return true if data is added
     */
    public boolean add(T elem) {
        // if data is present in tree don't add it
        if (root != null && contains(elem)) {
            return false;
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    /**
     * Add the new element in BT.
     *
     * @param root root element
     * @param elem data to be added
     * @return root node
     */
    private Node add(Node root, T elem) {
        // Base case: found leaf node
        if (root == null) {
            root = new Node(null, null, elem);
        } else {
            int cmp = elem.compareTo(root.data);
            // place lower element value in left subtree.
            if (cmp < 0) {
                root.left = add(root.left, elem);
            } else if (cmp > 0) {
                root.right = add(root.right, elem);
            }
        }
        return root;
    }

    /**
     * Remove the value from BT if it exists.
     *
     * @param elem data to be removed
     * @return true if found and removed
     */
    public boolean remove(T elem) {

        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove element.
     *
     * @param node root node
     * @param elem data to be removed
     * @return parent node.
     */
    private Node remove(Node node, T elem) {
        if (node == null) {
            return null;
        }

        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            // The value we are looking for is found

            if (node.left == null) {
                // when there is only right child

                // swap current node with it's right child node
                final Node rightChild = node.right;

                // destroy the data
                node.data = null;
                node = null;

                return rightChild;

            } else if (node.right == null) {
                // when there is only left child

                // replace current node with it's left child node
                final Node leftChild = node.left;

                // destroy the data
                node.data = null;
                node = null;

                return leftChild;
            } else {

                // Find successor: Smallest (left most) node in right subtree
                final Node tmp = findMin(node.right);

                // swap the data of current node
                node.data = tmp.data;

                // remove the successor node as that data is swapped with current node
                node.right = remove(node.right, tmp.data);

                // If instead we wanted to find the largest node in the left
                // subtree as opposed to the smallest node in the right subtree
                // here is what we would do:
                // Node tmp = findMax(node.left);
                // node.data = tmp.data;
                // node.left = remove(node.left, tmp.data);
            }
        }
        return node;
    }

    /**
     * Helper method to find the node with minimum value in the node's subtree.
     *
     * @param node subtree root
     * @return node
     */
    private Node findMin(Node node) {
        if (node == null) return null;

        // find the leftmost node in the tree/subtree
        while (node.left != null) node = node.left;

        return node;
    }

    /**
     * Helper method to find the node with maximum value in the node's subtree.
     *
     * @param node subtree root
     * @return node
     */
    private Node findMax(Node node) {
        if (node == null) return null;

        // Find the rightmost node in the tree/subtree
        while (node.right != null) node = node.right;

        return node;
    }

    /**
     * Computes the height of the tree
     * T.C - O(n)
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * Recursive helper method to find the height of the tree.
     *
     * @param node root node
     * @return length of the longest path from the root to a leaf node.
     */
    private int height(Node node) {

        // If there's no nodes including root
        if (node == null) return 0;

        // Adding 1 to count current node.
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }

    private Iterator<T> preOrderTraversal() {
        throw new UnsupportedOperationException("Method not supported yet.");
    }

    private Iterator<T> inOrderTraversal() {
        throw new UnsupportedOperationException("Method not supported yet.");
    }

    private Iterator<T> postOrderTraversal() {
        throw new UnsupportedOperationException("Method not supported yet.");
    }

    private Iterator<T> levelOrderTraversal() {
        throw new UnsupportedOperationException("Method not supported yet.");
    }


    /**
     * Print tree from given node
     *
     * @param node
     * @param space
     */
    private void printTree(Node node, int space) {
        // Number of spaces between levels
        int space_count = 5;

        if (node == null) return;

        // Increase distance between levels
        space += space_count;

        // Print right child first (so it appears on the right)
        printTree(node.right, space);

        // Print current node after spaces
        System.out.println();
        for (int i = space_count; i < space; i++) System.out.print(" ");
        System.out.println(node.data);

        // Print left child
        printTree(node.left, space);
    }

    /**
     * Print the tree.
     */
    public void print() {
        printTree(root, 0);
    }
}
