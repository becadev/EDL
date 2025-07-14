package Heap.PontoExtra;

/*
Para o nó na colocação i
 o filho esquerdo está em 2i
 o filho direito está em 2i + 1

*/

public class Heap implements HeapInter {
    protected Integer root;
    protected int[] heapArray;
    protected int tamanho;
    protected int capacidade;

    Heap(int n) {
        this.root = null;
        this.heapArray = new int[n+1];
        this.tamanho = 0;
        this.capacidade = n+1;
    }

    public void insert(int o) {
        if (this.root == null) {
            int novoH = o;
            this.root = novoH;
            this.heapArray[1] = this.root;
            return;
        }
        if (this.tamanho + 1 == this.capacidade)
            aumentar_capacidade();
    
        this.heapArray[this.tamanho +1 ] = o;
        this.tamanho++;
        downHeap();
    }

    public void aumentar_capacidade() {
        int[] newHeap = new int[this.capacidade*2];
        for(int i = 1; i <= this.tamanho ; i++){
            newHeap[i] = this.heapArray[i];
        }
        this.heapArray = newHeap;
        this.capacidade*=2;
    }

    public int size() {
        return this.tamanho;
    }

    public void removeMin() {
        this.root = this.heapArray[this.tamanho];
        this.heapArray[this.tamanho] = null;
        downHeap();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int min(int o) {
        return this.root;
    }

    public void SwapElements(int t1, int t2) {
        int menor = this.heapArray[t2];
        int maior = this.heapArray[i];

        this.heapArray[t1] = menor;
        this.heapArray[t2] = maior;
    }

    public void downHeap() {
        int i = 1;
        int leftSoon = 2 * i;
        int rightSoon = (2 * i) + 1;

        while (rigthSoon != null){ 
            if (this.heapArray[i] > this.heapArray[leftSoon]) {
                if (this.heapArray[i] < this.heapArray[rightSoon]) {
                    SwapElements(i, leftSoon);
                }
            }
            if (this.heapArray[i] > this.heapArray[rightSoon]) {
                if (this.heapArray[i] < this.heapArray[leftSoon]) {
                    SwapElements(i, rightSoon);
                }
            }

            i++;
            leftSoon = 2 * i;
            rightSoon = (2 * i) + 1;
        }
    }
}
