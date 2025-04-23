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
        return (this.n - this.i + this.f)%this.n;
    }

    public boolean isEmpty() {
        if(this.i == this.f)
            return true;
        return false;
    }

    public Object first() throws EFilaVazia { // retorna o elemento do inicio da fila sem remover
        return this.fila[this.i];
    }

    public void enqueue(Object o) {
        if(this.f+1 == this.i)
            increaseCapacity();
        this.fila[this.f] = o;
        this.f = (this.f+1)%this.n;
    }

    private void increaseCapacity() {
        Object[] newFila = new Object[this.n*2];

        for (int i = this.i; i < this.n - 1; i++)
                newFila[i] = this.fila[i];

        // caso a fila seja configuração quebrada
        if(this.f < this.i) {
            for (int i = this.f; i < this.i - 1; i++)
                newFila[i] = this.fila[i];
        }

        this.fila = newFila;
        this.n*=2;
        this.f = this.i;
        this.i = 0;

    }

    public Object dequeue() throws EFilaVazia {
        if(isEmpty())
            throw new EFilaVazia(null);
        Object o = this.fila[this.i];
        this.i = (this.i + 1)%this.n;
        return o;
    }
}
