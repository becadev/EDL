package Trabalho_pilha;

public class PilhaColorida implements Pilha {
    private int topoVermelho;
    private int topoPreto;
    private Object[] pilhaColorida;
    private int n;

    PilhaColorida(int nv, int np){  // nv = tamanho pilha vermelha, np = tamanho pilha preta
        this.n = nv+np+1;
        this.topoVermelho = -1;
        this.topoPreto = this.n;
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
        for(int i = 0 ; i <= this.topoVermelho; i++) { // Salva a pilha preta
            newPilha[i] = this.pilhaColorida[i];
        }

        int tamPreto = this.n - this.topoPreto; // tamanho da pilha preta
        this.topoPreto = ((this.n*2)- tamPreto); // novo topo preto na pilha redimensionada
        int tam = this.n-1;

        for(int i = this.n*2-1 ; i >= this.topoPreto; i--) { // Salva a pilha preta
            newPilha[i] = this.pilhaColorida[tam];
            tam--;
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
            return this.pilhaColorida[this.topoVermelho];
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
        Object lastElement = this.pilhaColorida[this.topoVermelho];
        if(sizeColorida() <= Math.abs(this.n/3)){
            reducaoPilha();
        }
        this.pilhaColorida[this.topoVermelho] = null;
        this.topoVermelho--;
        return lastElement;
    }

    private void reducaoPilha() {
        int newN = Math.abs(this.n/3)+1;
        Object[] newPilha = new Object[newN];

        for(int i = 0 ; i < this.topoVermelho ; i++){
            newPilha[i] = this.pilhaColorida[i];
        }


        int tamPreto = this.n - this.topoPreto; // tamanho da pilha preta
        this.topoPreto = newN- tamPreto; // novo topo preto na pilha redimensionada
        int tam = this.n-1;

        for(int i = this.n*2-1 ; i >= this.topoPreto; i--) { // Salva a pilha preta
            newPilha[i] = this.pilhaColorida[tam];
            tam--;
        }
        this.pilhaColorida = newPilha;
        this.n = newN;
    }

    public Object popPreto() throws PilhaVaziaExcecao { //remove e returna o último elemento inserido n apilha preto
        if (isEmptyPreta()) {
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.pilhaColorida[this.topoPreto];
        if(sizeColorida() <= Math.abs(this.n/3)){
            reducaoPilha();
        }

        this.pilhaColorida[this.topoPreto] = null;
        this.topoPreto++;
        return lastElement;
    }

    public void status() {// O(n)
        for(int i = 0 ; i < this.n ; i++) {
            System.out.print(this.pilhaColorida[i] + " ");
        }
        System.out.println("\n");
    }
}