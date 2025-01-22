package com.srvivek.dsalgo.linkedlist;

public class DublyLinkedListTestApp {

    public static void main(String[] args) {
        final DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println("DLL : " + ll.toString());

        ll.addFirst(10);
        System.out.println("DLL : " + ll.toString());

        ll.addLast(99);
        System.out.println("DLL : " + ll.toString());

        int index = ll.indexOf(2);
        System.out.println("Index of 2 : " + index);

        ll.addAt(index, 22);
        System.out.println("DLL : " + ll.toString());

        ll.add(26);
        System.out.println("DLL : " + ll.toString());

        ll.remove(3);
        System.out.println("DLL : " + ll.toString());

        ll.removeFirst();
        System.out.println("DLL : " + ll.toString());

        ll.removeLast();
        System.out.println("DLL : " + ll.toString());

        System.out.println("DLL size : " + ll.size());

        ll.clear();
        System.out.println("DLL cleared.\nSize: : " + ll.size());

    }
}
