package com.srvivek.dsalgo.hashtable;

public class SeperateChainingHashTableApp {

    public static void main(String[] args) {
        SeperateChainingHashTableImp<Integer, Integer> htable = new SeperateChainingHashTableImp<>();

        htable.add(1, 10);
        htable.add(2, 20);
        htable.add(3, 20);
        htable.add(4, 20);
        htable.add(5, 20);

        System.out.println(htable.keys());
        System.out.println(htable.values());

        htable.add(2, 200);
        System.out.println(htable);

        htable.add(6, 60);
        System.out.println(htable);

        htable.remove(3);
        System.out.println(htable);

        System.out.println(htable.size());
        System.out.println(htable.isEmpty());
    }
}
