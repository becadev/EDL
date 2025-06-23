package Arvore.ArvoreBinaria;

import java.util.Iterator;

public interface AB {
    //  Métodos da AB
    public Object leftchild(No v);
    public Object rightchild(No v);
    public boolean hasLeft(No v);
    public boolean hasRight(No v);

    //  Métodos genéricos
    public int size();
    public int height(No v) ;
    public boolean isEmpty();
    public Iterator<Object> elements();
    public Iterator<No> nos();
    // Métodos de acesso
    public No root();
    public No parent(No no);
    public Iterator<No> children(No no);

    // Métodos de consulta
    public boolean isInternal(No no);
    public boolean isExternal(No no);
    public boolean isRoot(No no);
    public int depth(No no);

    // Métodos de atualização
    public void replace(No no, Object o);

    // Método de busca
    public No treeSearch(Object k, No v); // k = elemento que será buscado, v = pai dele

    // Método de inserção
    public No insercao(No v, Object k);
    // primeiro verifica se K ta na arvore

    // Método de remoção
    public void remocao(Object k);
}
