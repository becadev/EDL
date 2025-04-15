package Q7;


public class PilhaArray implements Pilha {
    private int topo;
    private int capacity;
    private Object[] p1;
    private Object[] p2;

    PilhaArray(int tam, int topo){
        this.topo = topo;
        this.p1 = new Object[tam];
        this.capacity = tam;
    }

    public int size(){ // qunatidade de elementos na p1;
        return this.topo;
    }    
    public boolean isEmpty(){ // se a p1 está vazia
        if(this.topo == 0) {
            return true;
        }
        return false;
    }
    public Object top() throws PilhaVaziaExcecao { // retorna o último elemento inserido sem removê-lo
        if(!isEmpty())
            return this.p1[this.topo - 1];
        else 
            throw new PilhaVaziaExcecao(null);
    }

    public void push(Object o){ // insere um elemento
        if(this.topo == this.capacity) {
            Object[] newPilha = new Object[this.capacity+10];
            for(int i = 0 ; i < this.topo; i++) {
                newPilha[i] = this.p1[i];
            }
            this.p1 = newPilha;
            this.capacity += 10;
        }
        this.p1[this.topo] = o;
        this.topo ++;
    }


    public void pushP1(Object o){ // insere um elemento
        if(this.topo == this.capacity) {
            Object[] newPilha = new Object[this.capacity+10];
            for(int i = 0 ; i < this.topo; i++) {
                newPilha[i] = this.p1[i];
            }
            this.p1 = newPilha;
            this.capacity += 10;
        }
        this.p1[this.topo] = o;
        this.topo ++;
    }


    public void addPilha(Pilha p2) {
        PilhaArray pilhaAux = new PilhaArray(p2.size(), 0);
        while(!p2.isEmpty()){ // vai inverter a ordem do array para quando for botar em p1, ele não esteja invertido
            try{
                pilhaAux.push(p2.pop());
            }catch(PilhaVaziaExcecao e) {}
        }

        while(!pilhaAux.isEmpty()){
            try{
                Object p = pilhaAux.pop();
                this.pushP1(p);
                p2.push(p); // recolocando na pilha p2 dnv
            }catch(PilhaVaziaExcecao e){}
        }
    }

    public void pushP2(Object o){ // insere um elemento
        if(this.topo == this.capacity) {
            Object[] newPilha = new Object[this.capacity+10];
            for(int i = 0 ; i < this.topo; i++) {
                newPilha[i] = this.p2[i];
            }
            this.p2 = newPilha;
            this.capacity += 10;
        }
        this.p2[this.topo] = o;
        this.topo ++;
    }

    public Object pop() throws PilhaVaziaExcecao{ //remove e returna o último elemento inserido
        if (isEmpty()) {   
            throw new PilhaVaziaExcecao(null);
        }
        Object lastElement = this.p1[this.topo-1];
        this.topo--;
        return lastElement;
    }
    
    public void status() {// O(n)
        for(int i = 0 ; i < this.topo ; i++) {
            System.out.println(this.p1[i]);
        }
    }

    public boolean Empty() throws PilhaVaziaExcecao { // O(n)
        for(int i = 0 ; i < this.topo ; i ++) {
            this.p1[i] = null;
        }
        this.topo = 0;
        return true;
    }
}