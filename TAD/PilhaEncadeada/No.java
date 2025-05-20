package PilhaEncadeada;

public class No {
    private Object elemento;
    private No proximo;

    public No(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object o) {
        elemento = o;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
