package Vetor.ArrayVetor;

public interface Vetor {
    public Object elemeaAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    public int size();
    public Boolean isEmpty();
}
