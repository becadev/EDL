package Q5;
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
    public Object topVermelho() throws PilhaVaziaExcecao;
    public Object topPreto() throws PilhaVaziaExcecao;
    public void pushVermelha(Object o);
    public void pushPreta(Object o);
    public Object popVermelho() throws PilhaVaziaExcecao;
    public Object popPreto() throws PilhaVaziaExcecao;
}
