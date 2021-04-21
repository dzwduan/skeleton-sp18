public class LinkedListDeque<T> {
    private int size;
    public Node<T> sentinel;

    private  class Node<T>{
        public T val;
        public Node prev;
        public Node next;

        public Node(T i, Node p,Node n){
            val = i;
            prev= p;
            next= n;
        }
    }

    public LinkedListDeque(){
        size = 0;
        sentinel = new Node<T>(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item){
        sentinel.next = new Node(item,sentinel,sentinel.next);
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new Node(item,sentinel.prev,sentinel);
        size += 1;
    }

    public boolean isEmpty(){
        if(sentinel.prev==sentinel.next && size == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node<T> p = sentinel;
        while(p.next!=sentinel){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T res = (T) sentinel.next.val;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return res;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T res = (T) sentinel.prev.val;
        sentinel.prev = sentinel.prev.prev;
        size -=1;
        return res;
    }

    public T get(int index){
        if(isEmpty()){
            return null;
        }
        Node<T> cur = sentinel.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public T getRecursive(int index){
        if(index==0){
            return (T)sentinel.next.val;
        }
        else
            return getRecursive(index-1);
    }


}
