public class ArrayDeque<T> {
    /**implemetn circur array*/
    private int size;
    private T[] items;
    private int capacity = 8;
    private int nextFirst= 0;
    private int nextLast = 1;

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        size  = 0;
    }

    private void updateFirst(){
        nextFirst = (nextFirst-1+capacity)%capacity;
    }

    private void updateLast(){
        nextLast = (nextLast+1)%capacity;
    }

    private void expand(){
        if(size<capacity) return;
        T[] a = (T[]) new Object[capacity<<=1];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    private void shrink(){
        if(size<<2 > capacity) return;
        T[] oldItems = items;
        items = (T[]) new Object[capacity>>=1];

        for(int i=0;i<nextLast;i++){
            items[i] = oldItems[i];
        }
        for(int i=nextFirst+1;i<size;i++){
            items[i] = oldItems[i];
        }
        nextFirst = nextFirst - capacity;
    }

    public void addFirst(T item){
        expand();
        items[nextFirst] = item;
        size +=1;
        updateFirst();
    }

    public void addLast(T item){
        expand();
        items[nextLast] = item;
        size +=1;
        updateLast();
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i=(nextFirst+1)%capacity;i<nextLast;i++){
            System.out.print(items[i]+" ");
        }
    }

    public T removeFirst(){
        shrink();
        if(size==0) return null;
        T res = items[nextFirst];
        nextFirst = (nextFirst+1)%capacity;
        size-=1;
        return res;
    }

    public T removeLast(){
        shrink();
        if(size==0) return null;
        T res = items[nextLast];
        nextLast = (nextLast-1)%capacity;
        size-=1;
        return res;
    }

    public T get(int index){
        return items[(nextFirst+index+1)%capacity];
    }
}
