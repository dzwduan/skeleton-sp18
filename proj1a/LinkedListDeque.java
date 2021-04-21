public class LinkedListDeque<T> {
    private int size;
    private Node<T> sentinel;

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
        Node<T> first = new Node<T>(item,sentinel,sentinel.next);
        first.prev = sentinel;
        first.next = sentinel.next;
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    public void addLast(T item){
        Node<T> last = new Node<T>(item,sentinel.prev,sentinel);
        last.next = sentinel;
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    public boolean isEmpty(){
        if(size == 0)
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
        Node<T> mov_next = sentinel.next.next;
        sentinel.next = null;
        mov_next.prev = sentinel;
        sentinel.next =mov_next;
        size -= 1;
        return res;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T res = (T) sentinel.prev.val;
        Node<T> mov_prev = sentinel.prev.prev;
        sentinel.prev = null;
        sentinel.prev = mov_prev;
        mov_prev.next = sentinel;
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
