package Lab6;

import Lab4.SingleLinkedList;

import java.util.EmptyStackException;

public class LinkedQueue implements IQueue,ILinkedBased {
    private SingleLinkedList list;
    private int size;
    public LinkedQueue(){
        list = new SingleLinkedList();
    }
    @Override
    public void enqueue(Object item){
        list.add(item);
        size++;
    }
    @Override
    public Object dequeue(){
        if(size == 0)
            throw new EmptyStackException();
        Object item = list.get(0);
        list.remove(0);
        size--;
        return item;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
}
