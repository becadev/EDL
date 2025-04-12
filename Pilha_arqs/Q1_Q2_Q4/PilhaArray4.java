package Q1_Q2_Q4;
public class PilhaArray4 implements Pilha {
    private int topo;
    private int capacity;
    private Object[] pilha;

    PilhaArray4(int tam, int topo){ 
        this.topo = topo;
        this.pilha = new Object[tam];
        this.capacity = tam;
    }

    public int size(){ // qunatidade de elementos na pilha;
        return this.topo;
    }    
    public boolean isEmpty(){ // se a pilha está vazia
        if(this.topo == 0) {
            return true;
        }
        return false;
    }
    public Object top() throws PilhaVaziaExcecao{ // retorna o último elemento inserido sem removê-lo
        if(!isEmpty())
            return this.pilha[this.topo - 1];
        else 
            throw new PilhaVaziaExcecao(null);
    }
    public void push(Object o){ // insere um elemento
        if(this.topo == this.capacity) {
            Object[] newPilha = new Object[this.capacity*2];
            for(int i = 0 ; i < this.topo; i++) {
                newPilha[i] = this.pilha[i];
            }
            this.pilha = newPilha;
            this.capacity *= 2;
        }
        this.pilha[this.topo] = o;
        this.topo ++;
    }
    public Object pop() throws PilhaVaziaExcecao{ //remove e returna o último elemento inserido
        if (isEmpty()) {   
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.pilha[this.topo-1];
        this.topo--;
        return lastElement;
    }
    
    public void status() {
        for(int i = 0 ; i < this.topo ; i++) {
            System.out.println(this.pilha[i]);
        }
    }
    public boolean Empty() throws PilhaVaziaExcecao { // O(n)
        for(int i = 0 ; i < this.topo ; i ++) {
            this.pilha[i] = null;
        }
        this.topo = 0;
        return true;
    }
}