package Vetor.VetorLinkedList;

public class LinkedVetor implements Vetor {
    private no primeiro;
    private int n = 0;

    public Object elemeaAtRank(int r) throws LinkedListVetorException{  //retornar elemento na colocação r sem remover
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
        
        No element = primeiro;
        for(int i = 1 ; i <= this.n ; i++) {
            if(i == r) return element;
            element = element.next;
        }
        return element;
    }

    public Object replaceAtRank(int r, Object o) { // // substituir elemento do indice r por o e retornar o elemento que estava em r
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
        No newNo = new No(o);
        No element = primeiro;
        for (int i = 1 ; i <= r ; i++) { // percorre até a colocação r
            element = element.next;
        }
        No oldNo = element;
        newNo.next = element.next;
        newNo.prev = element.prev;
        return oldNo;
    }

    public void insertAtRank(int r, Object o) { // insere um novo elemento o na colocação r
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);

        No newNo = new No(o);
        No element = primeiro;

        for(int i = 1 ; i <= r ; i ++) {
            element = element.next;
        }
        newNo.next = element;
        newNo.prev = element.prev;
    }

    public Object removeAtRank(int r) { // remove e retorna o elemento na colocação r
        if(isEmpty() && r > this.n)
            throw new LinkedListVetorException(null);
        No element = primeiro;
        for(int i = 1 ; i <= r ; i ++) {
            element = element.next;
        }
        No oldNo = element;
        No nextAoRemovido =  element.next;
        No prevAoRemovido =  element.next;

        prevAoRemovido.next = nextAoRemovido;
        return oldNo;
    }

    public int size() {
        return this.n;
    }

    public Boolean isEmpty() {
        return this.n == 0;
    }
}