package Fila;
import java.lang.Object;

public class FilaArray implements Fila{
    private int i; // primeiro da fila
    private int f; // ultimo da fila;
    private Object[] fila;
    private int n; // tamanho da fila

    public FilaArray(int tam) {
        this.n = tam;
        this.i = 0;
        this.f = 0;
        this.fila = new Object[this.n];
    }

    public int size() {
        return (this.n - this.i + this.f) % this.n;
    }

    public boolean isEmpty() {
        return this.i == this.f;
    }

    public Object first() throws EFilaVazia { // retorna o elemento do inicio da fila sem remover
        return this.fila[this.i];
    }

    public void enqueue(Object o) {
        if(size() == this.n-1)
            increaseCapacity();
        this.fila[this.f] = o;
        this.f = (this.f+1)%this.n;
    }

    private void increaseCapacity() {
        Object[] newFila = new Object[this.n*2];
        int i2 = this.i;

        for (int i = 0; i <= size(); i++) {
            newFila[i] = this.fila[i2];
            i2 = (i2 + 1) % this.n;
        }
        this.fila = newFila;
        this.f = size();
        this.n *= 2;
        this.i = 0;
    }

    public Object dequeue() throws EFilaVazia {
        if(isEmpty())
            throw new EFilaVazia(null);
        Object o = this.fila[this.i];
        this.fila[this.i] = null;
        this.i = (this.i + 1)%this.n;
        return o;
    }

    public void status() {// O(n)
        for(int i = 0 ; i < this.n ; i++) {
            System.out.print(this.fila[i] + " ");
        }
        System.out.println("\n");
    }
}
