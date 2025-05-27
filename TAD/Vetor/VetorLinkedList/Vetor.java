package Vetor.VetorLinkedList;

public interface Vetor {
    public Object elemeaAtRank(int r)  throws LinkedListVetorException;
    public Object replaceAtRank(int r, Object o)  throws LinkedListVetorException;
    public void insertAtRank(int r, Object o)  throws LinkedListVetorException;
    public Object removeAtRank(int r)  throws LinkedListVetorException;
    public int size();
    public Boolean isEmpty();
}
