package Trabalho_pílha;

public class PilhaColorida implements Pilha {
    private int topoVermelho;
    private int topoPreto;
    private Object[] pilhaColorida;
    private int n;

    PilhaColorida(int nv, int np){  // nv = tamanho pilha vermelha, np = tamanho pilha preta
        this.n = nv+np+2;
        this.topoVermelho = -1;
        this.topoPreto = this.n-1;
        this.pilhaColorida = new Object[this.n];
    }
    public int sizeColorida(){ // qunatidade de elementos na pilha colorida e pilha preta;
        return sizePreto() + sizeVermelha();
    }

    public int sizePreto(){ // quantidade de elementos pilha preta;
        return this.n - this.topoPreto;
    }

    public int sizeVermelha(){ // qunatidade de elementos na pilha vermelha;
        return this.topoVermelho+1;
    }

    public void pushVermelha(Object o) {
        if(this.topoVermelho + 1 == this.topoPreto) {
            increase_capcity();
        }
        this.pilhaColorida[++this.topoVermelho] = o;
    }

    private void increase_capcity() {
        Object[] newPilha = new Object[this.n*2];
        for(int i = 0 ; i < this.topoVermelho; i++) { // Salva a pilha preta
            newPilha[i] = this.pilhaColorida[i];
        }
        int newTopoPreto = this.n-this.topoPreto;
        for(int i = this.n*2 ; i > ((this.n*2)-newTopoPreto); i--) { // Salva a pilha preta
            newPilha[i] = this.pilhaColorida[i];
        }
        this.pilhaColorida = newPilha;
        this.n *= 2;
    }

    public void pushPreta(Object o) {
        if(this.topoVermelho + 1 == this.topoPreto) {
            increase_capcity();
        }
        this.topoPreto--;
        this.pilhaColorida[this.topoPreto] = o;
    }

    public Object topVermelho() throws PilhaVaziaExcecao { // retorna o último elemento inserido na pilha vermelha sem removê-lo
        if(!isEmptyVermelha())
            return this.pilhaColorida[this.topoVermelho - 1];
        else
            throw new PilhaVaziaExcecao(null);
    }

    public Object topPreto() throws PilhaVaziaExcecao { // retorna o último elemento inserido na pilha preta sem removê-lo
        if(!isEmptyPreta())
            return this.pilhaColorida[this.topoPreto];
        else
            throw new PilhaVaziaExcecao(null);
    }

    public boolean isEmptyVermelha(){ // se a pilha vermelha está vazia
        if(this.topoVermelho == -1) {
            return true;
        }
        return false;
    }

    public boolean isEmptyPreta(){ // se a pilha preta está vazia
        if(this.topoPreto == this.n) {
            return true;
        }
        return false;
    }

    public Object popVermelho() throws PilhaVaziaExcecao { //remove e returna o último elemento inserido n apilha vermelha
        if (isEmptyVermelha()) {
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.pilhaColorida[this.topoVermelho-1];
        this.topoVermelho--;
        return lastElement;
    }

    public Object popPreto() throws PilhaVaziaExcecao { //remove e returna o último elemento inserido n apilha preto
        if (isEmptyPreta()) {
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.pilhaColorida[this.topoPreto];
        this.topoPreto++;
        return lastElement;
    }

    public void status() {// O(n)
        for(int i = 0 ; i < this.n ; i++) {
            System.out.println(this.pilhaColorida[i]);
        }
    }
}