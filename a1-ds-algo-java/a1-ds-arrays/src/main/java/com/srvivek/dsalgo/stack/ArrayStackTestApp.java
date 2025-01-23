package com.srvivek.dsalgo.stack;

public class ArrayStackTestApp {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack data : " + stack.toString());

        int t = stack.peek();
        System.out.println("stack.peek() : " + t);

        stack.push(3);
        System.out.println("Stack data : " + stack.toString());

        t = stack.peek();
        System.out.println("stack.peek() : " + t);

        t = stack.pop();
        System.out.println("stack.pop() : " + t);
        System.out.println("Stack data : " + stack.toString());
        System.out.println("Stack size : " + stack.size());

        stack = new ArrayStack<>(4);
        System.out.println("Stack data : " + stack.toString());
        System.out.println("Stack size : " + stack.size());

        stack.push(20);
        System.out.println("Stack data : " + stack.toString());
        System.out.println("Stack size : " + stack.size());
    }
}
