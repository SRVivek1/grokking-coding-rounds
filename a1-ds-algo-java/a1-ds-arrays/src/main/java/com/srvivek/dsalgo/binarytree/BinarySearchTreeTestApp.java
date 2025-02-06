package com.srvivek.dsalgo.binarytree;

public class BinarySearchTreeTestApp {

    public static void main(String[] args) {

        int[] input = new int[]{1, 4, 6, 2, 100, 70, 9, 44, 66, 23, 35};

        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50); // root node
        for(int i: input) {
            bst.add(i);
        }

        bst.print();
    }
}
