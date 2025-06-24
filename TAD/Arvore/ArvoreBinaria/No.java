package Arvore.ArvoreBinaria;

public class No {
    public Object chave;
    public No pai;
    public No[] filhos;

    No(Object chave){
        this.chave = chave;
        this.filhos = new No[2];
        this.filhos[0] = null;
        this.filhos[1] = null;
    }

    public Object getChave() {
        return chave;
    }

    public No getPai() {
        return pai;
    }

    public No[] getFilhos() {
        return filhos;
    }

    public No getFilhoLeft() {
        return filhos[0];
    }

    public No getFilhoRight() {
        return filhos[1];
    }

    public void setChave(Object chave) {
        this.chave = chave;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public void setFilhoRight(No filho) {
        this.filhos[1] = filho;
    }

    public void setFilhoLeft(No filho) {
        this.filhos[0] = filho;
    }

    public int qtdFilhos() {
        int cont = 0;
        for (No filho : filhos) {
            if (filho != null)
                cont++;
        }
        return cont;
    }
}
