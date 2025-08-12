package Heap;

/*
Para o nó na colocação i
 o filho esquerdo está em 2i
 o filho direito está em 2i + 1

*/

public class Heap implements HeapInter {
    protected Integer[] heapArray;
    protected int tamanho;
    protected int capacidade;

    Heap(int n) {
        this.heapArray = new Integer[n+1];
        this.tamanho = 0;
        this.capacidade = n+1;
    }

    public void print(Object o) {
        System.out.println(o);
    }

    public void insert(Integer o) {
        if (this.heapArray[1] == null){
            this.heapArray[1] = o;

            this.tamanho++;
            return;
        }
        if (this.tamanho + 1 == this.capacidade)
            aumentar_capacidade();

        this.heapArray[this.tamanho + 1] = o;
        this.tamanho++;
        upHeap(); // restaura a heaporder
    }

    public void aumentar_capacidade() {
        Integer[] newHeap = new Integer[this.capacidade*2];
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
        this.heapArray[1] = this.heapArray[tamanho];
        this.tamanho--;
        downHeap(); // restaurar a ordem
    }

    public boolean isEmpty() {
        return this.heapArray[1] == null;
    }

    public Integer min() {
        return this.heapArray[1];
    }


    public void downHeap() {
        Integer i = 1;
        Integer soonLeft = 2 * i;
        Integer soonRigth = (2 * i) + 1;

        while (i < tamanho+1) {
            if (this.heapArray[i] > this.heapArray[soonLeft]) {
                if (this.heapArray[i] < this.heapArray[soonRigth]) {
                    swapElement(i, soonLeft);
                }
            }

            if (this.heapArray[i] > this.heapArray[soonRigth]) {
                if (this.heapArray[i] < this.heapArray[soonLeft]) {
                    swapElement(i, soonRigth);
                }
            }

            i++;
            soonLeft = 2 * i;
            soonRigth = (2 * i) + 1;
        }
    }

    public void swapElement(Integer filho, Integer pai) {
        Integer menor = this.heapArray[filho];
        Integer maior = this.heapArray[pai];

        // pai vai virar filho e filho vai virar pai
        this.heapArray[pai] = menor;
        this.heapArray[filho] = maior;
    }


    public void upHeap() {
        Integer i = this.tamanho;
        Integer paileft = (i)/2;
        Integer pairight = (i-1)/2;

        while(i > 0) {

            if (i % 2 == 0){ // se o filho tiver no index par entao ele é filho esquerdo
                if(paileft > 0
                        && this.heapArray[paileft] != null
                        && this.heapArray[i] != null
                        && this.heapArray[i] <= this.heapArray[paileft]){
                    swapElement(i,paileft);

                }
            }

            if (i % 2 != 0){ // se o filho tiver no index impar entao ele é filho direito
                if(pairight > 0
                        && this.heapArray[pairight] != null
                        && this.heapArray[i] != null
                        && this.heapArray[i] < this.heapArray[pairight]){
                    swapElement(i,pairight);

                }
            }
            i--;
            paileft = (i)/2;
            pairight = (i-1)/2;

        }
    }

    public void status() {
        for (int i = 1; i <= tamanho; i++) {
            System.out.print(this.heapArray[i] + " ");
        }
        System.out.println();
    }

    public void mostrarHeap() {
        printHeap(1, 0);
    }

    public void printHeap(int i, int nivel) {
        if (i > this.tamanho) {
            return;
        }
        for(int k = 0 ; k < nivel ; k ++ ){
            System.out.print(" ");
        }
        System.out.println(this.heapArray[i]);

        printHeap(2 * i, nivel+1);
        printHeap((2 * i)+1, nivel+1);

    }

    public Integer[] heap() {
        return this.heapArray;
    }


    public void juntarHeap(Integer[] heapA, Integer[] heapB, Integer chave, int tamA, int tamB) {
        Integer[] heaps = new Integer[tamA + tamB + 2];
        this.tamanho = tamA + tamB + 1;
        this.capacidade = tamA + tamB + 2;
        int k = 1;

        heaps[1] = chave; // elemento que vai juntar as heaps
        for (int i = 2; i <= this.tamanho ; i += 2) {
            heaps[i] = heapA[k];
            heaps[i+1] = heapB[k];
            k++;
            if (k > tamA || k > tamB)
                break;
        }
        this.heapArray = heaps;
        System.out.println("Resultado da junção das heaps antes do upHeap");
        status();
        System.out.println("Depois do upHeap");
        upHeap();
        status();
        mostrarHeap();
    }
}
