package com.srvivek.dsalgo.stack.problems;

import java.util.Stack;

/**
 * Not working - algo needs to be fixed
 */
public class TowerOfHanoiWithStack {

    public static void main(String[] args) {

        final Stack<Integer> source = new Stack<>();
        final Stack<Integer> auxiliary = new Stack<>();
        final Stack<Integer> destination = new Stack<>();

        int disks = 4;
        for (int i = disks; i > 1; i--) {
            source.push(i);
        }

        solveTowerOfHanoi(disks, source, auxiliary, destination);

        System.out.println("Destination Tower : " + destination);
    }

    public static void solveTowerOfHanoi(int disks, Stack<Integer> source,
                                         Stack<Integer> auxiliary, Stack<Integer> destination) {

        System.out.println("disks " + disks);
        System.out.printf("Source: %s%nDestination: %s%n, Auxiiary: %s%n", source, destination, auxiliary);
        if (disks == 1) {
            destination.push(source.pop());
            System.out.println("Move disk 1 from source to destination.");
            return;
        }


        //Step-1: Move n-1 disks from source to auxiliary using destination as temporary tower
        solveTowerOfHanoi(disks - 1, source, destination, auxiliary);


        // Step-2: Move the largest nth disk from source to destination
        destination.push(source.pop());
        System.out.println("Moved disk " + disks + " from source to destination.");


        //Step-3: Move n-1 disks from auxiliary to destination using source as temporary tower
        solveTowerOfHanoi(disks - 1, auxiliary, source, destination);
    }
}
