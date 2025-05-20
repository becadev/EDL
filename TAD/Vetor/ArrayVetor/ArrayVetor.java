package Vetor.ArrayVetor;

public class ArrayVetor implements Vetor{
    private int n;
    private Object[] vetor;
    private int capacity;

    public ArrayVetor(int n) {
        this.n = 0;
        this.capacity = n-1;
        this.vetor = new Object[this.capacity];
    }

    public Object elemeaAtRank(int r) { //retornar elemento na colocação r sem remover
        return this.vetor[r]; // é colocação de tipo "terceira posição"
    } // O(1)

    public Object replaceAtRank(int r, Object o) throws ArrayVetorException{ // substituir elemento do indice r por o e retornar o elemento que estava em r
        if(isEmpty())
            throw new ArrayVetorException(null);
        Object oldElement = this.vetor[r];
        this.vetor[r] = o;
        return oldElement;
    } // O(1)

    public void insertAtRank(int r, Object o) throws ArrayVetorException{ // insere um novo elemento o na colocação r
        if(r > this.capacity)
            throw new ArrayVetorException(null);
        if(this.capacity < this.n +1) resize();
        for(int i = this.n ; i > r ; i--) {
            this.vetor[i] = this.vetor[i-1];
        }
//        for(int i = 0 ; i > n ; i++){
//            System.out.println(this.vetor[i]);
//        } // Pra testar
        this.vetor[r]= o;
        this.n++;
    }

    public Object removeAtRank(int r) { // remove e retorna o elemento na colocação r
        if(r > n)
            throw new ArrayVetorException(null);
        Object oldElement = this.vetor[r];
        if (r == n-1) this.n--; // se r fo igual ao indice do ultimo elemento, então nao precisa fazer deslocações
        for(int i = r ; i < this.n ; i ++ ) {
            this.vetor[i] = this.vetor[i+1];
        }
        this.n--;
        return oldElement;
    }

    public int size() {
        return this.n;
    }

    public Boolean isEmpty() {
        return this.n == 0;
    }
    public void resize() {
        Object [] newVetor = new Object[this.capacity*2];
        for(int i = 0 ; i < this.n ; i ++)
            newVetor[i] = this.vetor[i];
        this.vetor = newVetor;
        this.capacity = this.capacity*2;
    }

    public void Status() {
        System.out.println("Status Atual do Vetor:");
        for (int i = 0 ; i < this.n ; i ++){
            System.out.print(this.vetor[i] + " ");
        }
        System.out.print('\n');
    }
}
