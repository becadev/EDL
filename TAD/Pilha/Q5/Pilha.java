package Pilha.Q5;

// especifica todos os métodos obrigatórios que deverão ter na pilha
public interface Pilha {
    public Object topVermelho() throws PilhaVaziaExcecao;
    public Object topPreto() throws PilhaVaziaExcecao;
    public void pushVermelha(Object o);
    public void pushPreta(Object o);
    public Object popVermelho() throws PilhaVaziaExcecao;
    public Object popPreto() throws PilhaVaziaExcecao;
}
