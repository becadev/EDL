package Arvore.ArvoreBinaria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreBinaria implements AB {
    protected No root; //raiz
    protected int tamanho;
    protected List<Object> visitados;
    protected List<No> nosVisitados;

    ArvoreBinaria() {
        this.root = null;
        this.tamanho = 0;
        this.visitados = new ArrayList<>();
        this.nosVisitados = new ArrayList<>();
    }

    @Override
    public Object leftchild(No v) { // pega o filho esquerdo de v
        return v.getFilhoLeft().getChave();
    }

    @Override
    public Object rightchild(No v) { // pega o filho direito de v
        return v.getFilhoRight().getChave();
    }

    @Override
    public boolean hasLeft(No v) { // retorna se V tem filho esquerdo
        return v.getFilhoLeft() != null;
    }

    @Override
    public boolean hasRight(No v) { // retorna se V tem filho direito
        return v.getFilhoRight() != null;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public int height(No v) { // retorna a altura
        if (isExternal(v))
            return 0;
        int h = 0;
        for (No w : v.getFilhos()) {
            h = Math.max(h, height(w));
        }
        return 1 + h;
    }

    @Override
    public boolean isEmpty() { //
        return this.root == null;
    }

    @Override
    public Iterator<Object> elements() { // retorna um iterador para os elementos da arvore
        inOrder();
        return this.visitados.iterator();
//  Iterator é um objeto que permite percorrer essa lista elemento por elemento, sem expor a estrutura interna.
    }

    @Override
    public Iterator<No> nos() { // retorna um iterador para os nós da arvore
        inOrder();
        return this.nosVisitados.iterator();
    }

    @Override
    public No root() {
        return this.root;
    }

    @Override
    public No parent(No no) { // retorna o pai de um nó
        return no.getPai();
    }

    @Override
    public Iterator<No> children(No no) { // retorna um iterator para os filhos
        List<No> filhos = new ArrayList<>();

        if (no.getFilhoLeft() != null) {
            filhos.add(no.getFilhoLeft());
        }

        if (no.getFilhoRight() != null) {
            filhos.add(no.getFilhoRight());
        }
        return filhos.iterator();
    }

    @Override
    public boolean isInternal(No no) { // verifica se o nó é interno com pelo menos um filho
//        if(no == null) return false;
        return ((no.qtdFilhos() > 0));
    } // tem pelo menos um filho

    @Override
    public boolean isExternal(No no) { // verifica se o nó é externo ou folha, nó sem filhos
        return (no.qtdFilhos() == 0);
    } // externo não tem filho

    @Override
    public boolean isRoot(No no) { // verifica se o nó é raiz
        return no.getPai().getChave() == this.root.getChave();
    }

    @Override
    public int depth(No no) { // verifica profundidade de um nó
        return profundidade(no);
    }

    public int profundidade(No v) { // chamada recursiva pela depth
        if (v == this.root)
            return 0;
        return (1 + profundidade(v.getPai()));
    }

    @Override
    public void replace(No no, Object o) { // altera o objeto armazenado em um nó
        no.setChave(o);
    }

    /*
    Para procurar uma chave k, procuramos a partir da raiz
    comparando com a chave do nó.
    */

    @Override
    public No treeSearch(Object k, No v) { // busca um nó, o V na primeira chamada será a raiz
        Comparable chave = (Comparable) v.getChave();
        if (isExternal(v))
            return v;
        if (chave.compareTo(k) < 0)
            return treeSearch(k, v.getFilhoLeft());
        else if (chave.compareTo(k) == 0)
            return v;
        else if (chave.compareTo(k) > 0)
            return treeSearch(k, v.getFilhoRight());
        return null;
    }

    public void inserir(Object k) { // para poder usar na classe teste
        this.root = insercao(this.root, k);
    }

    public No insercao(No v, Object k) {
        if (this.root == null) {
            this.root = new No(k);
            return this.root;
        } else {
            if (v == null) {
                return new No(k);
            }
            Comparable chave = (Comparable) v.getChave();
            if (chave.compareTo(k) < 0) {// v < k então vai para esquerda
                v.setFilhoLeft(insercao(v.getFilhoLeft(), k));
                v.getFilhoLeft().setPai(v);
            } else if (chave.compareTo(k) > 0) {// v > k então vai para direita
                v.setFilhoRight(insercao(v.getFilhoRight(), k));
                v.getFilhoRight().setPai(v);
            }
        }
        return v;
    }

    @Override
    public void remocao(Object k) {
        No v = treeSearch(k, this.root); // retorna o nó que tem esse objeto
        if (v == null) return;
        if (v.qtdFilhos() == 0) {
            Caso01remocao(v);
        } else if (v.qtdFilhos() == 1) {
            Caso02remocao(v, k);
        } else if (v.qtdFilhos() == 2) {
            Caso03remocao(v, k);
        }
    }

    public void Caso01remocao(No k) { // caso folha, nao tem filhos
        No paideK = k.getPai();
        if (paideK.getPai() == null) {// então é a raiz que tá sendo deletada
            this.root = null;
            return;
        }
        Object chave = comparable(k.getChave(), paideK.getChave());
        if (k.getChave() == chave) {//  paideK > k então k ta na esquerda
            paideK.setFilhoLeft(null);
        }
        paideK.setFilhoRight(null); //  paideK < k então k ta na direita
    }

    public void Caso02remocao(No v, Object k) { // tem um filho
        if (v.getFilhoLeft() != null) { // o filho que v tem é o esquerdo
            No filhodeV = v.getFilhoLeft();
            filhodeV.setPai(v.getPai());
        } // senão o filho que v tem é direito
        No filhodeV = v.getFilhoRight();
        filhodeV.setPai(v.getPai());
    }

    public void Caso03remocao(No v, Object k) { // tem dois filhos, será reajeitado com o menor da subarvore a direita
        No subArvoreDireita = v.getFilhoRight();
        No substituto = minDaSubArvore(subArvoreDireita);
        if (v.getPai() != null)
            substituto.setPai(v.getPai());
        substituto.setFilhoRight(v.getFilhoRight());
    }

    public No minDaSubArvore(No v) { // chamada recursiva para pegar o menor da subarvore a diretia do nó que será removido
        if (v.getFilhoLeft() == null)
            return v;
        return minDaSubArvore(v.getFilhoLeft());
    }

    public Object comparable(Object v, Object k) {
        Comparable chave = (Comparable) v;
        if (chave.compareTo(k) < 0)// v < k então k ta na direita
            return v;
            // v > k então k ta na esquerda
        return k;
    }

        public void inOrder () {
            inOrderRec(this.root);
        }


        public void preOrder (No v){ // um nó é visitado antes dos seus descendentes
            System.out.println(v.getChave());
            for (No soon : v.getFilhos()) {
                preOrder(soon);
            }
        }
        public void postOrder (No v){ // um nó é visitado depois de seus descendentes
            for (No filho : v.getFilhos()) {
                postOrder(filho);
            }
            System.out.print(v.getChave() + " ");
        }

        public void inOrderRec (No v){
            if (v == null) return;
            if (isInternal(v))
                inOrderRec(v.getFilhoLeft());
            visite(v);
            if (isInternal(v))
                inOrderRec(v.getFilhoRight());
        }

        public void visite (No v){ // vai colocar em um array ai com todos os coisado visitado, sei la
            this.visitados.add(v.getChave());
            System.out.print(v.getChave() + " ");
            this.nosVisitados.add(v);
        }

}
