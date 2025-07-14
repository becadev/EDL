package Heap.PontoExtra.MinHeap;

public interface Heap {
    public void Insert(int chave, Object o);
    public Object removeMin();
    public int size();
    public boolean isEmpty();
    public Object min();

}
