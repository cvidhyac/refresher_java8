package org.example.generics;

public class SinglyLinkedNode<T> {


    final T data;

    final SinglyLinkedNode<T> next;

    SinglyLinkedNode(T data, SinglyLinkedNode<T> nextNode) {
        this.data = data;
        this.next = nextNode;
    }

    public T getData() {
        return data;
    }

    public SinglyLinkedNode<T> getNext() {
        return next;
    }
}
