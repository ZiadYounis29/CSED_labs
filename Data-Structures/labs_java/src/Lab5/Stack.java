package Lab5;

import Lab4.SingleLinkedList;

import java.time.chrono.IsoChronology;
import java.util.EmptyStackException;

public class Stack implements IStack {
    SingleLinkedList list;
    private int size;
    public Stack(){
        list = new SingleLinkedList();
    }
    @Override
    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object item = list.get(0);
        list.remove(0);
        size--;
        return item;
    }
    @Override
    public Object peek(){
        if(size == 0)
            throw new EmptyStackException();
        return list.get(0);
    }
    @Override
    public void push(Object element){
        list.add(0,element);
        size++;
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
