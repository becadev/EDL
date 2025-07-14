package Heap.PontoExtra.MinHeap;
// Nó para fila de prioridade

public class No {
    public int chave;
    public Object elemento;

    No(int chave, Object o) {
        this.chave = chave;
        this.elemento = o;
    }

    public int getChave() {
        return chave;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
