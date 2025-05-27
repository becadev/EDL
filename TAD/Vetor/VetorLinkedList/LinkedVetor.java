package Vetor.VetorLinkedList;

public class LinkedVetor implements Vetor {
    private No primeiro;
    private int n = 0;

    LinkedVetor() {
        this.n = 0;
    }
    public Object elemeaAtRank(int r) throws LinkedListVetorException {  //retornar elemento na colocação r sem remover
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
        
        No element = primeiro;
        for(int i = 1 ; i < r ; i++) {
            element = element.next;
        }
        return element.chave;
    }

    public Object replaceAtRank(int r, Object o) throws LinkedListVetorException  { // // substituir elemento do indice r por o e retornar o elemento que estava em r
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
//        No newNo = new No(o);
        No element = primeiro;
        for (int i = 1 ; i < r ; i++) { // percorre até a colocação r
            element = element.next;
        }
        Object oldNo = element.chave;
        element.chave = o;
        return oldNo;
    }

    public void insertAtRank(int r, Object o)  throws LinkedListVetorException { // insere um Novo elemento o na colocação r
        if (r < 0 )
            throw new LinkedListVetorException(null);

        No newNo = new No(o);
        if (isEmpty()) { // primeiro elemento
            this.primeiro =  newNo;
            this.n++ ;
            return;
        }

        if(r == 1) {
            newNo.next = primeiro;
            primeiro.prev = newNo;
            primeiro = newNo;
            this.n++;
            return;
        }
        No element = primeiro;
        for (int i = 1; i <= r; i++) {
            if(element.next == null){
                element.next = newNo;
                newNo.prev = element;
                break;
            }
            element = element.next;
        }
        this.n++ ;
    }


    public Object removeAtRank(int r){ // remove e retorna o elemento na colocação r
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
        No element = primeiro;

        if(r == 1) {
            Object oldNo = primeiro.chave;
            primeiro = primeiro.next;
            primeiro.prev = null;
            this.n--;
            return oldNo;
        }

        for(int i = 1 ; i < r ; i ++) {
            element = element.next;
        }
        Object oldNo = element.chave;

        No nextAoRemovido =  element.next;
        No prevAoRemovido =  element.prev;

        prevAoRemovido.next = nextAoRemovido;
        nextAoRemovido.prev =  prevAoRemovido;

        this.n--;
        return oldNo;
    }

    public int size() {
        return this.n;
    }

    public Boolean isEmpty() {
        return this.n == 0;
    }

    public void status() {
        No elemento = this.primeiro;
        for (int i = 0 ; i < this.n ; i ++){
            System.out.print(elemento.chave + " ");
            elemento = elemento.next;
        }
        System.out.print('\n');
    }
}