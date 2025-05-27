package Sequencia;

public interface Sequencia {

    // --- Métodos Genéricos ---
    public int size();            // Retorna o número de elementos na estrutura
    public boolean isEmpty();         // Verifica se a estrutura está vazia

    // --- Métodos de Vetor ---
    public Object elemAtRank();      // Retorna o elemento na posição (rank) especificada
    public void replaceAtRank();   // Substitui o elemento na posição (rank) especificada
    public void insertAtRank();    // Insere um novo elemento na posição (rank) especificada
    public void removeAtRank();    // Remove o elemento da posição (rank) especificada

    // --- Métodos de Lista ---
    public Object first();           // Retorna a primeira posição da lista
    public Object last();            // Retorna a última posição da lista
    public Object before (int p);          // Retorna a posição anterior a uma posição dada
    public Object after(int p);           // Retorna a posição seguinte a uma posição dada
    public void replaceElements(int n, Object o);  // Substitui o elemento armazenado em uma posição
    public void swapElements(int n, int q);    // Troca os elementos entre duas posições
    public void insertAfter(int n, Object o);    // Insere um novo elemento antes de uma posição dada
    public void insertBefore(int q, Object o);     // Insere um novo elemento depois de uma posição dada
    public void insertFirst(Object o);     // Insere um novo elemento no início da lista
    public  void insertLast(Object o) ;      // Insere um novo elemento no final da lista
    public void remove(int n);          // Remove o elemento de uma posição da lista

    // --- Métodos Ponte ---
    public Object atRank(int rank);         // Retorna a posição correspondente a um rank
    public int rankOf(Object o);          // Retorna o rank correspondente a uma posição

    /*
    * Ex: [ A, B, C, D]
    *       0  1  2  3 -> Esse são os ranks(indices)
    *       atrank(2) = C   | retorna o elemento do rank passado
    *       rankOf(C) = 2   | retorna o indice do elemento passado
    * */

}
