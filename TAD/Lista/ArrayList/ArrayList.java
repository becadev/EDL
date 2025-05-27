package Lista.ArrayList;


public class ArrayList implements List{
    private int n;
    private Object[] ArrayList;
    private int capacity;

    public ArrayList(int capacity) {
        this.n = 0;
        this.capacity = capacity;
        this.ArrayList = new Object[this.capacity];
    }

    public int size() {
        return this.n;
    }

    public Boolean isEmpty() {
        return this.n == 0;
    }

    public boolean isFirst(Object o) throws ArrayListException{ // verifica a primeira posição da lista é o lemento passado
        if(this.n == 0)
            throw new ArrayListException(null);
        return this.ArrayList[0] == o;
    }

    public boolean isLast(Object o) throws ArrayListException{ // verifica a ultima posição da lista é o elemeno passado
        if(this.n == 0)
            throw new ArrayListException(null);
        return this.ArrayList[size()-1] == o;
    }

    public Object Last() throws ArrayListException{ // retorna a ultima posição da lista.
        if(!isEmpty())
            return this.ArrayList[this.n-1];
        throw new ArrayListException(null);
    }

    public Object First() throws ArrayListException{ // retorna a primeira posição da lista.
        if(!isEmpty())
            return this.ArrayList[0];
        throw new ArrayListException(null);
    }

    public Object before(int p) throws ArrayListException{ // retorna a posição que vem antes da posição p
        if(!isEmpty() && p <= this.n-1)
            return this.ArrayList[p-2];
        throw new ArrayListException(null);
    }

    public Object after(int p) throws ArrayListException{ //  retorna a posição que vem depois da posição p.
        if(!isEmpty() && p <= this.n-1)
            return this.ArrayList[p];
        throw new ArrayListException(null);
    }

    public void replaceElement(int n, Object o) throws ArrayListException{ // substitui o elemento armazenado na posição n por um novo elemento o.
        if (n > this.n || n < 0 || isEmpty())
            throw new ArrayListException(null);
        this.ArrayList[n-1] = o;
    }

    public void swapElements(int n, int q) throws ArrayListException{ // troca os elementos das posições n e q.
        if (n > this.n-1 || n < 0 || isEmpty() || q > this.n-1 || q < 0)
            throw new ArrayListException(null);

        Object posicaoN = this.ArrayList[n-1];
        Object posicaoQ = this.ArrayList[q-1];

        this.ArrayList[q-1] = posicaoN;
        this.ArrayList[n-1] = posicaoQ;
    }

    public void insertBefore(int q, Object o) throws ArrayListException{ // insere o elemento o antes da posição n.
        if(q > this.n || isEmpty()) throw new ArrayListException(null);
        if (this.n + 1 == this.capacity) { // Se alcnçar a capacidade total
            Object[] newArrayList = new Object[2 * this.capacity];
            int i;
            for(i = 0 ; i < q ; i++)
                newArrayList[i] = this.ArrayList[i];

            newArrayList[i] = o;
            for(int t = i+1 ; t < this.n ; t ++) {
                newArrayList[t] = this.ArrayList[i];
            }
            this.ArrayList = newArrayList;
            this.n++;
            this.capacity*=2;
            return;
        }

        for(int t = this.n ; t > q-1 ; t--) {
            this.ArrayList[t] = this.ArrayList[t-1];
        }
        this.ArrayList[q-1] = o;
        this.n++;
    }

    public void insertAfter(int n, Object o) throws ArrayListException{ // insere o elemento o depois da posição n.

    }

    public void insertFirst(Object o) throws ArrayListException{ //  insere o elemento o no início da lista.
        if(this.n == 0)
            this.ArrayList[0] = o;
        if(this.n+1 == this.capacity) {
            Object[] newArrayList = new Object[this.capacity*2];
            for(int i = this.n + 1 ; i > 0 ; i -- )
                newArrayList[i] = this.ArrayList[i-1];
            newArrayList[0] = o;
            this.ArrayList = newArrayList;
            this.n++;
            this.capacity*=2;
            return;
        }
        for(int i = this.n+1 ; i > 0 ; i--)
            this.ArrayList[i] = this.ArrayList[i-1];
        this.ArrayList[0] = o;
        this.n++;
    }

    public void insertLast(Object o) throws ArrayListException{ // insere o elemento o no fim da lista.
        if(this.n + 1 == capacity) {
            Object[] newArrayList = new Object[this.capacity*2];
            for(int i = 0 ; i < this.n ; i++){
                newArrayList[i] = this.ArrayList[i];
            }
            this.capacity*=2;
            this.ArrayList = newArrayList;
        }
        this.ArrayList[n] = o;
        this.n++;
    }

    public void remove(int n) throws ArrayListException{ // remove o elemento que está na posição n.
        if(n > this.n-1 || isEmpty())
            throw new ArrayListException(null);
        for(int i = n-1 ; i < this.n ; i ++) {
            this.ArrayList[i] = this.ArrayList[i+1];
        }
        this.n--;
    }
    public void status() {
        for (int i = 0 ; i < this.n ; i ++) {
            System.out.print(this.ArrayList[i] + " ");
        }
        System.out.println();
    }

}
