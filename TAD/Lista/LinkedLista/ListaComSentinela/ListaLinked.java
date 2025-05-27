package Lista.LinkedLista.ListaComSentinela;

public class ListaLinked implements Lista{
    private No inicio;
    private No fim;
    private int n;

    ListaLinked() {
        this.n = 0;
        this.inicio = new No(null);
        this.fim = new No(null);
    }

    public int size() {
        return this.n;
    }

    public Boolean isEmpty() {
        return this.n == 0;
    }

    public boolean isFirst(Object o) {
        if (this.n == 0)
            throw new EListaComSentinelaException(null);
        No primeiro = this.inicio.next;
        Object first = primeiro.chave;
        return first == o;
    }

    public boolean isLast(Object o) {
        if (this.n == 0)
            throw new EListaComSentinelaException(null);
        No ultimo = this.fim.prev;
        Object last = ultimo.chave;
        return last == o;
    }

    public Object Last() {
        return null;
    }

    public Object First() {
        return null;
    }

    public Object before(int p) {
        return null;
    }

    public Object after(int p) {
        return null;
    }

    public void replaceElement(int n, Object o) {

    }

    public void swapElements(int n, int q) {

    }

    public void insertBefore(int n, Object o) {

    }

    public void insertAfter(int n, Object o) {

    }

    public void insertFirst(Object o) {

    }

    public void insertLast(Object o) {

    }

    public void remove(int n) {

    }
}

