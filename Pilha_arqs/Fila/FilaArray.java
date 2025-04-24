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
        if(this.f == this.i)
            return this.n-this.i+(this.f);
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
//        if(this.f+1 == this.i )
//          increaseCapacity();
//        if((this.f+1)%this.n+1 == this.i) // isso aq ta errado mas ta quase certo
//            increaseCapacity();
//        else if(this.f == this.n){
//            this.f = (this.f+1)%this.n;
//        }
        if(this.f == this.n){
            this.f = (this.f+1)%this.n;
        }
        this.fila[this.f] = o;
        this.f = (this.f+1)%this.n;
    }

    private void increaseCapacity() {
        Object[] newFila = new Object[this.n*2];

        int i2 = this.i;
        for (int i = 0; i2 < this.n; i++) {
            newFila[i] = this.fila[i2];
            i2++;
        }
        // caso a fila seja configuração quebrada
        if(this.f < this.i) {
            int tamf = this.f+1;
            for (int i = i2+1; i < i2+1+tamf; i++)
                newFila[i2] = this.fila[this.f];
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
