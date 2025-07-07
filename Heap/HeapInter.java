package Heap;

public interface HeapInter {
    public void insert(int o);
    public int size();
    public void removeMin();
    public boolean isEmpty();
    public int min(int o);
}

// Implementar uma Fila de Prioridade usando um HEAP implementado através de um array 
// - implementar os métodos da Fila de Prioridade:
// - Insert, removeMin, size, isEmpty, e min. Métodos vistos em sala de aula