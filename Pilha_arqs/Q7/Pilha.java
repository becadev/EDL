package Q7;

import Q5.PilhaVaziaExcecao;

// especifica todos os métodos obrigatórios que deverão ter na pilha
public interface Pilha {
    public Object top() throws PilhaVaziaExcecao;
    public int size();
    public void pushP1(Object o);
    public void push(Object o);
    public void addPilha(Pilha p2);
    public Object pop() throws PilhaVaziaExcecao;
    public boolean isEmpty();
}
