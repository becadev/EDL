package PilhaEncadeada;

public class PilhaEncadeada implements Pilha{
    private No topo;
    private int n;

    public PilhaEncadeada() {
        this.topo = null;
        this.n = 0;
    }

    public int size() {
        return this.n;
    }

    public boolean isEmpty() { // pilha está vaiza?
        return this.topo == null;
    }

    public Object top() throws PilhaVaziaExcecao {
        return this.topo.getElemento();
    }

    public void push(Object o) {
        if(this.topo == null) {
            this.topo = new No(o);
            this.n++;
            return;
        }
        No novoNo = new No(o);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
        this.n++;
    }

    public Object pop() throws PilhaVaziaExcecao {
        if(isEmpty())
            return new PilhaVaziaExcecao(null);
        Object OldTopo = this.topo.getElemento(); // antigo topo
        this.topo = this.topo.getProximo(); // o topo agora será o elemento anterior da pilha
        this.n--; // diminui o tamanho da pilha
        return OldTopo;
    }

    public void statusPilhaEncadeada() {
        No atual = this.topo;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual  = atual.getProximo();
        }
        System.out.print('\n');
    }
}
