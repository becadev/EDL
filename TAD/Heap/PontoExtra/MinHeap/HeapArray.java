package Heap.PontoExtra.MinHeap;

import java.util.AbstractMap;

public class HeapArray implements Heap{
    private No[] arrayHeap;
    private int tamanho;
    private int capacidade;

    HeapArray(int size) {
        this.arrayHeap = new No[size+1];
        this.tamanho = 1; // um porque o heap não pode começar do zero
        this.capacidade = size;
    }

    @Override
    public void Insert(int chave, Object o) {
        if (this.capacidade == this.tamanho + 1) {
            increase_capacity();
        }
        this.arrayHeap[this.tamanho] = new No(chave,o);
        this.tamanho++;
        upHeap(); // recuperar a heap-order
    }

    public void increase_capacity() {
        No[] newHeap = new No[this.capacidade * 2];
        for (int i = 1 ; i < this.tamanho ; i++ ) {
            newHeap[i] = this.arrayHeap[i];
        }
        this.arrayHeap = newHeap;
        this.capacidade*=2;
    }

    // Filho esquerdo = 2 * i
    // Filho direito = 2i + 1

    public void upHeap() { // toda vez que houver uma inserção deve ser chamada um upheap para ajeitar a heap-order
        Object lastNo = this.arrayHeap[this.tamanho];
        // ultimo item inserido na heap

       // while

    }

    public void downHeap() { // chamado toda vez que houver uma remoção

    }

    public void heapsort() {

    }


    @Override
    public Object removeMin() {
        No min = this.arrayHeap[1];



        return new AbstractMap.SimpleEntry<>(min.getChave(),min.getElemento()); // vai retornar um par
    }

    @Override
    public int size() {
        return this.tamanho-1; // menos um porque o heap não começa do zero
    }

    @Override
    public boolean isEmpty() {
        return this.arrayHeap[1] == null;
    }

    @Override
    public Object min() {
        return this.arrayHeap[1];
    }
}
