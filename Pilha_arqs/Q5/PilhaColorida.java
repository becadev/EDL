package Q5;

public class PilhaColorida implements Pilha {
    private int topoVermelho;
    private int topoPreto;
    private Object[] pilhaColorida;
    private int n;

    PilhaColorida(int nv, int np){  // nv = tamanho pilha vermelha, np = tamanho pilha preta
        this.n = nv+np+2;
        this.topoVermelho = -1;
        this.topoPreto = this.n;
        this.pilhaColorida = new Object[this.n];

    }
    public int sizeColorida(){ // qunatidade de elementos na pilha colorida e pilha preta;
        return this.topoPreto;
    }

    public int sizeVermelha(){ // qunatidade de elementos na pilha vermelha;
        return this.topoVermelho;
    }

    public void pushVermelha(Object o) {
        if(this.topoVermelho + 1 == this.topoPreto) {
            System.out.println("Pilha já atingiu sem máximo");
            return;
        }
        this.pilhaColorida[++this.topoVermelho] = o;
    }

    public void pushPreta(Object o) {
        if(this.topoVermelho + 1 == this.topoPreto) {
            System.out.println("Pilha já atingiu sem máximo");
            return;
        }
        this.topoPreto--;
        this.pilhaColorida[this.topoPreto] = o;
    }

    public Object topVermelho() throws PilhaVaziaExcecao{ // retorna o último elemento inserido na pilha vermelha sem removê-lo
        if(!isEmptyVermelha())
            return this.pilhaColorida[this.topoVermelho - 1];
        else
            throw new PilhaVaziaExcecao(null);
    }

    public Object topPreto() throws PilhaVaziaExcecao{ // retorna o último elemento inserido na pilha preta sem removê-lo
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

    public Object popVermelho() throws PilhaVaziaExcecao{ //remove e returna o último elemento inserido n apilha vermelha
        if (isEmptyVermelha()) {
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.pilhaColorida[this.topoVermelho-1];
        this.topoVermelho--;
        return lastElement;
    }

    public Object popPreto() throws PilhaVaziaExcecao{ //remove e returna o último elemento inserido n apilha preto
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