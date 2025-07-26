package com.srvivek.dsalgo.disjointset;

public class UnionFindTestApp {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);

        System.out.println(unionFind.componentSize(1));

        unionFind.unify(1, 2);
        System.out.println(unionFind.componentSize(1));

        System.out.println(unionFind.isConnected(1, 2));

        System.out.println(unionFind.isConnected(1, 3));
    }
}
