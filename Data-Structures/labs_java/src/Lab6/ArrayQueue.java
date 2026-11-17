package Lab6;

import java.util.EmptyStackException;

public class ArrayQueue implements IQueue,IArrayBased  {
    private int maxSize;
    private int size;
    private int front;
    private int end;
    private Object[] list;
    public ArrayQueue(int n){
        maxSize=n;
        list = new Object[n];
    }
    @Override
    public void enqueue(Object item){
        if(size == maxSize)
            throw new ArrayStoreException();
        list[end]=item;
        end = (end+1)%maxSize;
        size++;
    }
    @Override
    public Object dequeue(){
        if(size == 0)
            throw new EmptyStackException();
        Object item = list[front];
        front = (front +1)%maxSize;
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
