package com.test.zx.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taylor
 * @version 1.0
 */
public class LinkedStack<T> {

    public <Y> List<Y> add() {
        return new ArrayList<Y>();
    }

    public String toString(List<String> strings) {
        return "111";
    }

    private static class Node<U> {

        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> node = new Node<T>();

    public T pop() {
        if (node.item == null && node.next == null)
            return null;

        T item = node.item;

        node = node.next;


        return item;
    }

    public void push(T item) {
        node = new Node(item, node);

    }

    public  void main(String[] args) {
/*        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        for (String s : "ss dd aa".split(" "))
            stringLinkedStack.push(s);
        String s;
        while((s = stringLinkedStack.pop()) != null)
            System.out.println(s);*/
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();

        stringLinkedStack.toString(this.<String>add());
    }
}
