package FilaTwoPilha;

import PilhaEncadeada.PilhaVaziaExcecao;

public class FilaArray implements Fila{
    private int i; // primeiro da fila
    private int f; // ultimo da fila;
    private int t; // ultimo da fila;
    private Object[] pilhaEntrada;
    private Object[] pilhaSaida;
    private int n; // tamanho da fila

    public FilaArray(int n) {
        this.i = 0;
        this.f = 0;
        this.t = -1;
        this.pilhaEntrada = new Object[n];
        this.pilhaSaida = new Object[n];
        this.n = n;
    }

    public int size() {
        return this.t+1;
    }

    public boolean isEmpty() {
        return this.t == -1;
    }

    public Object first() throws EFilaVazia {
        if(isEmpty())
            return new PilhaVaziaExcecao(null);
        int ff = size() - 1;
        for(int i = 0 ; i < size() ; i++) { // colocando na pilha secundaria para inverter a ordem
           pilhaSaida[i] = pilhaEntrada[ff];
           ff--;
        }
        Object first = pilhaSaida[size()-1];
        ff = size() - 1;
        for (int i = 0 ; i < size() ; i ++) { // colocado de novo na pilha principal
            pilhaEntrada[i] = pilhaSaida[ff];
            ff --;
        }
        System.out.println(ff);
        return first;
    }
    private void increaseCapacity() {
        Object[] newPilhaEntrada = new Object[2*this.n];
        Object[] newSaida = new Object[2*this.n];
        int tt = size() - 1;
        for(int i = 0 ; i < size() - 1 ; i++) {
            newSaida[i] = this.pilhaEntrada[tt];
            tt --;
        }
        tt = size() - 1;
        for(int i = 0 ; i < size() - 1 ; i++) {
            newPilhaEntrada[i] = newSaida[tt];
            tt--;
        }
        this.pilhaEntrada = newPilhaEntrada;
        this.n*=2;
    }

    public void enqueue(Object o) {
//       if(this.t + 1 == this.n)
//            increaseCapacity();
        this.pilhaEntrada[this.t+1] = o;
        this.t ++;
    }

    public Object dequeue() throws EFilaVazia {
        Object o;
        if (this.t == 0) {// significa que só tem um elemento na fila entao nao precisa fazer paranaue
            o = this.pilhaEntrada[this.t];
            this.pilhaEntrada[this.t] = null;
            this.t = -1;
        } else {
            int f2 = this.t-1;
            for (int i = 0; i <= this.t; i++) { // vai colocar na pilha saida para poder pegar o primeiro para fazer dequeue
                this.pilhaSaida[i] = this.pilhaEntrada[f2];
                f2--;
            }
            o = pilhaEntrada[f2]; // elemento que vai ser dequeuado
            pilhaEntrada[f2] = null; // colocando como vazio
            int ii = size() - 2;
            for (int i = 0; i < size(); i++) { // vai voltar tudo pra pilha entrada
                pilhaEntrada[i] = pilhaSaida[ii];
                ii--;
            }
        }
        return o;
    }

    public void status() {
        for (int i = 0 ; i < size() ; i++) {
            System.out.println(this.pilhaEntrada[i] + " ");
        }
        System.out.print('\n');
    }
}

