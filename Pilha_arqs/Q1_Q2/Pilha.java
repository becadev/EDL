package Q1_Q2;
/*
 * Created on 19/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

 // especifica todos os métodos obrigatórios que deverão ter na pilha
public interface Pilha {    
    public int size();    
    public boolean isEmpty();
    public boolean Empty() throws PilhaVaziaExcecao;
    public Object top() throws PilhaVaziaExcecao;
    public void push(Object o);
    public Object pop() throws PilhaVaziaExcecao;
}
