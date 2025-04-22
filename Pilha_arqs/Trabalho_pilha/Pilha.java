package Trabalho_pilha;

// especifica todos os métodos obrigatórios que deverão ter na pilha
public interface Pilha {
    public Object topVermelho() throws PilhaVaziaExcecao;
    public Object topPreto() throws PilhaVaziaExcecao;
    public void pushVermelha(Object o);
    public void pushPreta(Object o);
    public int sizeColorida();
    public int sizeVermelha();
    public int sizePreto();
    public Object popVermelho() throws PilhaVaziaExcecao;
    public Object popPreto() throws PilhaVaziaExcecao;

}
