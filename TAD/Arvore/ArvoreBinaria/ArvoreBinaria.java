package Arvore.ArvoreBinaria;
import java.util.ArrayList;
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
        return (hasLeft(v)) ? v.getFilhoLeft().getChave() : "nao tem filho esquerdo";
    }

    @Override
    public Object rightchild(No v) { // pega o filho direito de v
//        if (v.getFilhoRight().getChave() == null) return null;
        return (hasRight(v)) ? v.getFilhoRight().getChave() : "nao tem filho direito";
//        return v.getFilhoRight().getChave();
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
            if (w != null)
                h = Math.max(h, height(w));
        }
        return 1 + h;
    }

    @Override
    public boolean isEmpty() { //
        return this.root == null;
    }

    @Override
    public List<Object> elements() { // retorna um iterador para os elementos da arvore
        this.visitados = new ArrayList<>();
        preOrder(this.root);
        return this.visitados;
    }

    @Override
    public List<No> nos() { // retorna um iterador para os nós da arvore
        this.nosVisitados = new ArrayList<>();
        preOrder(this.root);
        return this.nosVisitados;
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
    public List<Object> children(No no) { // retorna um iterator para os filhos
        List<Object> filhos = new ArrayList<>();

        if (no.getFilhoLeft() != null) {
            filhos.add(no.getFilhoLeft().getChave());
        }

        if (no.getFilhoRight() != null) {
            filhos.add(no.getFilhoRight().getChave());
        }
        return filhos;
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
        return no.getChave() == this.root.getChave();
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

    public No inserir(Object k) { // para poder usar na classe teste
        No novoNo = new No(k);
        this.tamanho++;
        this.root = insercao(this.root, novoNo);
        return novoNo;
    }

    public No insercao(No v, No k) {
        if (this.root == null) {
            this.root = k;
            return this.root;
        } else {
            if (v == null) {
                v = k;
                return v;
            }
            Comparable chave = (Comparable) v.getChave();
            if (chave.compareTo(k.getChave()) < 0) {// v > k então vai para direita
                v.setFilhoRight(insercao(v.getFilhoRight(), k));
                v.getFilhoRight().setPai(v);
            } else if (chave.compareTo(k.getChave()) > 0) {// v < k então vai para esquerda
                v.setFilhoLeft(insercao(v.getFilhoLeft(), k));
                v.getFilhoLeft().setPai(v);
            }
        }
        return v;
    }

    @Override
    public void remocao(Object k) {
        No v = treeSearch(k, this.root); // retorna o nó que tem esse objeto
        if (v == null) return;
        if (v.qtdFilhos() == 0) {
            System.out.println("ta entrando no caso 1");
            Caso01remocao(v);
        } else if (v.qtdFilhos() == 1) {
            System.out.println("ta entrando no caso 2");
            Caso02remocao(v, k);
        } else if (v.qtdFilhos() == 2) {
            System.out.println("ta entrando no caso 3");
            Caso03remocao(v, k);
        }
        this.tamanho--;
    }

    public void Caso01remocao(No k) { // caso folha, nao tem filhos
        No paideK = k.getPai();
        if (paideK.getPai() == null) {// então é a raiz que tá sendo deletada
            this.root = null;
            return;
        }
        Object chave = comparable(k.getChave(), paideK.getChave());
        if (k.getChave() == chave) {//  paideK < k então k ta na direita
            paideK.setFilhoRight(null);
            return;
        }
        paideK.setFilhoLeft(null); // paideK > k então k ta na esquerda
    }

    public void Caso02remocao(No v, Object k) { // tem um filho
        if (v.getFilhoLeft() != null) { // o filho que v tem é o esquerdo
            No filhodeV = v.getFilhoLeft();
            filhodeV.setPai(v.getPai());
            System.out.println("pai do filho de v" + filhodeV.getPai().getChave() + " v = " + v.getChave() + "filho esquerdo de v =  " + v.getFilhoLeft().getChave() + "filho direito de v =  " + v.getFilhoRight());
            No paideV = v.getPai();
            paideV.setFilhoLeft(filhodeV);
            return;
        } // senão o filho que v tem é direito
        No filhodeV = v.getFilhoRight();
        filhodeV.setPai(v.getPai());
        System.out.println("direito" + filhodeV.getPai().getChave());
        No paideV = v.getPai();
        paideV.setFilhoRight(filhodeV);
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
        if (chave.compareTo(k) < 0)// v > k então k ta na esquerda
            return v;
            // v < k então k ta na direita
        System.out.println("v<k " + k + " " + v);
        return k;
    }

        public List<Object> inOrder() {
            this.visitados = new ArrayList<>();
            inOrderRec(this.root);
            return this.visitados;
        }

        public List<Object> preOrder(No v) {
            this.visitados = new ArrayList<>();
            preOrderRec(v);
            return this.visitados;
        }

        public void preOrderRec (No v){ // um nó é visitado antes dos seus descendentes
            visite(v);
            for (No soon : v.getFilhos()) {
                if(soon != null)
                    preOrderRec(soon);
            }
        }
        public List<Object> postOrder(No v) {
            this.visitados = new ArrayList<>();
            postOrderRec(v);
            return this.visitados;
        }


        public void postOrderRec (No v){ // um nó é visitado depois de seus descendentes
            if (v == null) return;
            for (No filho : v.getFilhos()) {
                postOrderRec(filho);
            }
            visite(v);
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
            this.nosVisitados.add(v);
        }

}
