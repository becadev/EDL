public class PilhaArray extends Pilha {
    private int tamanho;
    private int topo;
    private int capacity;
    private Object[] array;

    PilhaArray(int tam, int topo){
        this.tamanho = tam;
        this.topo = topo;
        this.array = new Object[tam];
        this.capacity = 1;
    }

    public int size(){ // qunatidade de elementos na pilha;
        return this.tamanho;
    }    
    public boolean isEmpty(){ // se a pilha está vazia
        if(this.topo == 0) {
            return true;
        }
        return false;
    }
    public Object top() throws PilhaVaziaExcecao{
        if(!isEmpty())
            return this.pilha[this.topo - 1];
        else return "Não há elementos na pilha";
    }
    public void push(Object o){
        if(this.topo == this.tamanho) {
            Object[] newPilha = new Object[this.capacity*2];
            for(int i = 0 ; i < this.tam ; i++) {
                newPilha[i] = this.pilha[i];
            }
        }
        this.pilha = newPilha;
        this.pilha[this.topo] = o;
        this.topo ++;
        this.tam ++;
    }
    public Object pop() throws PilhaVaziaExcecao{

    }
}