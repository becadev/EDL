package FilaEncadeada;

public class FilaEncadeada implements Fila{
    private No i;
    private No f;
    private int n; // tamanho da lista

    FilaEncadeada() {
        this.n = 0;
        this.i = null;
        this.f = null;
    }

    public int size() {
        return this.n;
    }

    public boolean isEmpty() { // ta vazia?
        return this.i == this.f;
    }

    public Object first() throws EFilaVazia {
        if(isEmpty())
            return new EFilaVazia(null);
        return this.i.getElemento();
    }

    public void enqueue(Object o) { // insere  o elemento no fim da fila
        No novoNo = new No();
        novoNo.setElemento(o);
        novoNo.proximo = null;

        if (null == this.i) {
            this.i = novoNo;
            this.f = novoNo;
            this.i.proximo = this.f;
        }
        this.f.proximo = novoNo;
        No oldF = this.f;
        this.f = novoNo;
        this.n++;
    }

    public Object dequeue() throws EFilaVazia { // remove e retorna o elemento do incio da fila
        if(isEmpty())
            return new EFilaVazia(null);
        No oldNo = this.i;
        this.i = this.i.proximo;
        this.n--;
        return oldNo.getElemento();
    }

    public void statusFilaEncadeada() {
        No atual = this.i;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual  = atual.proximo;
        }
        System.out.print('\n');
    }

}
