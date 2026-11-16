package Lab4;

public class DoubleLinkedList implements ILinkedList {
    private class Node{
        Object data;
        Node next;
        Node prev;
        public Node(Object data){
            this.data=data;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public DoubleLinkedList(){
    }
    public void add(int index, Object element){
        if(index>size || index<0)
            throw new IndexOutOfBoundsException();
        if(index == size){
            add(element);
            return;
        }
        Node node = new Node(element);
        Node current = getNode(index);
        if(index == 0){
            head = node;
            node.next = current;
            current.prev = node;
        }
        else{
            current.prev.next = node;
            node.prev = current.prev;
            current.prev = node;
            node.next = current;
        }
        size++;
    }
    @Override
    public void add(Object element){
        Node node = new Node(element);
        if(size == 0){
            head = node;
            tail = node;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }
    private Node getNode(int index){
        Node node = head;
        for(int i = 0; i<index ;i++){
            node=node.next;
        }
        return node;
    }
    @Override
    public Object get(int index) {
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i<index ;i++){
            node=node.next;
        }
        return node.data;
    }
    @Override
    public void set(int index, Object element){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();
        Node node = getNode(index);
        node.data = element;
    }
    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public void remove(int index){
        if(index >=size || index <0)
            throw new IndexOutOfBoundsException();

        if(index == 0){
            head = head.next;
            if(size != 1){
                head.prev = null;
                }
            else{
                tail =null;
            }


        }
        else if(index ==size-1){
            tail.prev.next = null;
            tail = tail.prev;
        }
        else{
            Node current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if( fromIndex > toIndex || fromIndex<0 || toIndex>=size)
            throw new IndexOutOfBoundsException();
        DoubleLinkedList list = new DoubleLinkedList();
        Node node = getNode(fromIndex);
        for(int i=fromIndex ; i <= toIndex ;i++){
            list.addNode(node);
            node=node.next;
        }
        return list;
    }

    private void addNode(Node node){
        if(size == 0){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public boolean contains(Object o){
        Node node = head;
        for(int i=0 ; i<size ; i++){
            if(o == null ? node.data == null : o.equals(node.data))
                return true;
            node = node.next;
        }
        return false;
    }
}
