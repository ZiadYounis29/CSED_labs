package Lab4;

public class SingleLinkedList implements ILinkedList {

    private class Node{
        Object data;
        Node next;
        public Node(Object data){
            this.data=data;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public SingleLinkedList(){
    }
    @Override

    public void add(int index, Object element){
        if(index>size || index<0)
            throw new IndexOutOfBoundsException();

        if(index == size){
            add(element);
            return;
        }
        Node node = new Node(element);

        if(index == 0){
            node.next=head;
            head=node;
        }

        else{
            Node prev=getNode(index -1);
            node.next=prev.next;
            prev.next=node;

        }
        size++;
    }

    @Override
    public void add(Object element){
        Node node = new Node(element);
        if (size==0){
            head=node;
        }
        else
            tail.next=node;
        tail=node;
        size++;
    }

    @Override
    public Object get(int index){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();

        return getNode(index).data;
    }

    @Override
    public void set(int index, Object element){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();

        Node current=getNode(index);
        current.data=element;
    }
    private Node getNode(int index){
        Node node = head;

        for(int i = 0 ;i<index;i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public boolean isEmpty(){
        return(size == 0);
    }

    @Override
    public void remove(int index){
        if(index>=size || index<0)
            throw new IndexOutOfBoundsException();
        if(index==0) {
            head=head.next;
            size--;
            if(size == 0)
                tail=null;
            return;
        }
        Node prev = getNode(index-1);
        if(index==size-1)
            tail=prev;

        prev.next = prev.next.next;
        size--;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex){
        if(fromIndex>toIndex || fromIndex<0 || toIndex>=size){
            throw new IndexOutOfBoundsException();
        }
        SingleLinkedList list = new SingleLinkedList();
        Node node = getNode(fromIndex);
        for(int i =fromIndex ; i<=toIndex ;i++){
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
            tail = node;
        }
        size++;
    }
    @Override
    public boolean contains(Object o){
        Node node=head;
        for(int i=0 ; i<size ; i++){
            if(o==null? node.data==null :o.equals(node.data))
                return true;
            node=node.next;
        }
        return false;
    }









}
