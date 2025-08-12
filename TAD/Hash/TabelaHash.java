package Hash;
// o indice que o elemento é guardado no array é calculado a partir da key que fica dentro do box
// box = (chave,elemento)

public class TabelaHash implements Hash{
    private static final Box NO_SUCH_KEY = null; // era pra ser object para retrorn no such key
    private static final Box AVALIABLE = null;
    private int size;
    private Box[] tabela;
    private int capacidade, tamanho;
    // tamanho se refere ao tamanho do array e capacidade aos espaços livres

    TabelaHash(int tam){
        this.capacidade = verificaPrimo(tam);
        this.tabela = new Box[this.capacidade];
        this.tamanho = this.capacidade;
        this.size = 0;
    }

    public int verificaPrimo(int tam) {
        int a = 0;
        for(int i = 1 ; i <= tam ; i++) {
            if(tam%i==0)
                a++;
        }
        if (a==2)
            return tam;

        else if((tam - 1) % 2 != 0 || (tam - 1) % 3 != 0)
            return tam-1;

        return tam+1;
    }

    public int findeElement(int k) {
        Box[] aux = new Box[this.tamanho];
        int j = 0;
        for(int i = 0 ; i < this.tamanho ; i++) {
            if(this.tabela[i] != null) { // para salvar apenas os elementos sem os nulls
                aux[j] = this.tabela[i];
                j++;
            }
        }
        Insertion(aux); // ordenando as chaves
        if (BuscaBinaria(aux, k,0, size()-1) != null)
            return BuscaBinaria(aux, k,0, size()).getElement();
        return -1;
    }

    public Box BuscaBinaria(Box[] aux, int k, int min, int max) {
        int m = (min + max)/2;
        Box c = aux[m];
        if (min>max) {
            return NO_SUCH_KEY;
        }

        else if(c != null && c.getKey() == k) {
            return c;
        }

        else if(c != null && c.getKey() > k) {
            return BuscaBinaria(aux, k, min, m - 1);
        }

        else if (c != null && k > c.getKey()) {
            return BuscaBinaria(aux, k, min + 1, max);
        }
        return NO_SUCH_KEY;
    }


    public Box[] Insertion(Box[] aux_array) {
        for (int i = 1; i < aux_array.length; i++) {
            Box aux = aux_array[i];
            if (aux == null || aux == AVALIABLE) continue; // pular posições vazias

            int j = i - 1;
            while (j >= 0 && aux_array[j] != null && aux_array[j] != AVALIABLE && aux_array[j].getKey() > aux.getKey()) {
                aux_array[j + 1] = aux_array[j];
                j--;
            }
            aux_array[j + 1] = aux;
        }
        return aux_array;
    }

    public void print(Object o){
        System.out.println(o);
    }

    @Override
    public void insertItem(int k, int o) {
        int h = k % this.tamanho;
        Box newBox = new Box(k,o);

        if(this.capacidade - this.size == 0) // nao tem espaços vazios;
            increaseCapacity();

        if (this.tabela[h] != AVALIABLE && this.tabela[h] != null) { // se o h calculado estiver ocupado
            while(this.tabela[h] != null && this.tabela[h] != AVALIABLE) {
                h++;
                if(h == this.tamanho)
                    h = 0;
            }
        }
        this.tabela[h] = newBox;
        this.capacidade--;
        this.size++;
    }

    public int HashingDuplo(int h, int k) {
        int d = 7 - (k % 7);
        h = (h + d) % this.tamanho;
        return h;
    }

    public void insertItemHashing(int k, int o) {
        if(this.capacidade - this.size == 0) // nao tem espaços vazios;
            increaseCapacity();

        int h = k % this.tamanho;
        Box newBox = new Box(k,o);

        if (this.tabela[h] != AVALIABLE && this.tabela[h] != null) { // se o h calculado estiver ocupado
            while(this.tabela[h] != null && this.tabela[h] != AVALIABLE) {
                h = HashingDuplo(h,k);
                if (h >= this.tamanho)  // se h passar do tamanho ele dá uma volta e vai para o inicio do array
                    h = this.tamanho - h;
            }
        }
        this.tabela[h] = newBox;
        this.capacidade--;
        this.size++;
    }

    public void increaseCapacity() {
        Box[] newTabela = new Box[this.tamanho*2];

        for(int i = 0 ; i < this.tamanho ; i++) {
            newTabela[i] = this.tabela[i];
        }

        this.tabela = newTabela;
        this.tamanho*=2;
        this.capacidade = this.tamanho - size();
    }

    @Override
    public void removeElement(int k) {
        this.capacidade++;
        this.size--;

        int h = k % 13; // linear probing pra achar a chave
        if (this.tabela[h].getKey() == k) {
            this.tabela[h] = AVALIABLE;
            return;
        }
        int h_aux = h;
        while (this.tabela[h].getKey() != k){
            h++;
            if(h == this.tamanho)
                h = 0;
            if(h == h_aux) {
                noSuchKey();
                return;
            }
        }
        this.tabela[h] = AVALIABLE;
    }

    public Object noSuchKey() {
        return "NO SUCH KEY";
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int[] keys() {
        int i = 0;
        int[] keys = new int[size()];
        for (Box k: this.tabela) {
            if(k != null) {
                keys[i] = k.getKey();
                i++;
            }
        }
        return keys;
    }

    @Override
    public int[] Elements() { // retorna os elementos salvos nas chaves ('indices calculados')
        int i = 0;
        int[] elements = new int[size()];
        for (Box k: this.tabela) {
            if(k != null) {
                elements[i] = k.getElement();
                i++;
            }
        }
        return elements;
    }
    public void status() {
        System.out.println("Keys da tabela e espaços");
        for (int i = 0 ; i < this.tamanho ; i++){
            if (this.tabela[i] == null)
                System.out.print(0 + " ");
            else
                System.out.print(this.tabela[i].getKey() + " ");
        }
        System.out.println();
        System.out.println("Elementos da tabela e espaços");
        for (int i = 0 ; i < this.tamanho ; i++){
            if (this.tabela[i] == null)
                System.out.print(0 + " ");
            else
                 System.out.print(this.tabela[i].getElement() + " ");
        }
    }
}
