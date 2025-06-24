package Arvore.ArvoreBinaria;

import java.util.Iterator;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinaria t = new ArvoreBinaria();
        System.out.println("Teste isEmpty(): ");
        System.out.println(t.isEmpty());

        System.out.println("---------------------------------------");

        System.out.println("Teste size(): ");
        System.out.println(t.size());

        System.out.println("---------------------------------------");
        System.out.println("TESTE DE INSERCAO: ");
        No no1 = t.inserir(10);
        No no2 = t.inserir(5);
        No no3 = t.inserir(6);
        No no4 = t.inserir(12);
        No no5 = t.inserir(14);
        No no6 = t.inserir(7);
        No no7 = t.inserir(1);
        No no8 = t.inserir(11);

        System.out.println("---------------------------------------");
        System.out.println("Teste isEmpty(): ");
        System.out.println(t.isEmpty());

        System.out.println("---------------------------------------");
        System.out.println("Teste size(): ");
        System.out.println(t.size());

        System.out.println("---------------------------------------");
        System.out.println("TESTE DE INORDER: ");
        System.out.println(t.inOrder());

        System.out.println("---------------------------------------");
        System.out.println("TESTE DE PREORDER PASSANDO NO2(objeto 5): ");
        System.out.println(t.preOrder(no2));

        System.out.println("---------------------------------------");
        System.out.println("Teste posOrder passando o no2(objeto 5): ");
        System.out.println(t.postOrder(no2));

        System.out.println("---------------------------------------");
        System.out.println("TESTE DE ELEMENTs USANDO PREORDER: ");
        System.out.println(t.elements());

        System.out.println("---------------------------------------");
        System.out.println("Teste parent() do no6 com o objeto 7: ");
        No paiDoNo = t.parent(no6);
        System.out.println(paiDoNo.getChave());


        System.out.println("---------------------------------------");
        System.out.println("Teste root(): ");
        System.out.println(t.root().getChave());


        System.out.println("---------------------------------------");
        System.out.println("Teste depth(): ");
        System.out.println(t.depth(no6));


        System.out.println("---------------------------------------");
        System.out.println("Teste rigthchild(): ");
        System.out.println(t.rightchild(no3));


        System.out.println("---------------------------------------");
        System.out.println("Teste leftchild(): ");
        System.out.println(t.leftchild(no3));


        System.out.println("---------------------------------------");
        System.out.println("Teste hasleft(): ");
        System.out.println(t.hasLeft(no1));


        System.out.println("---------------------------------------");
        System.out.println("Teste hasrigth(): ");
        System.out.println(t.hasRight(no1));


        System.out.println("---------------------------------------");
        System.out.println("Teste replace() trocando a raiz 10 por 20: ");
        t.replace(no1, 20);
        System.out.println(t.elements());


        System.out.println("---------------------------------------");
        System.out.println("Teste isRoot() no6: ");
        System.out.println(t.isRoot(no6));


        System.out.println("---------------------------------------");
        System.out.println("Teste isRoot() no1: ");
        System.out.println(t.isRoot(no1));


        System.out.println("---------------------------------------");
        System.out.println("Teste children no2: ");
        System.out.println(t.children(no2));



        System.out.println("---------------------------------------");
        System.out.println("Teste Altura no2: ");
        System.out.println(t.height(no2));
        System.out.println("Teste Altura no1: ");
        System.out.println(t.height(no1));
        System.out.println("Teste Altura no6: ");
        System.out.println(t.height(no6));


        System.out.println("---------------------------------------");
        System.out.println("Teste nos(): ");
        System.out.println(t.nos());

        System.out.println("_._._._._._._._._._._._._._._._._._._._.");
        System.out.println("Elementos antes da remoção: ");
        System.out.println(t.elements());
        System.out.println("---------------------------------------");
        System.out.println("Teste remocao(): ");
        System.out.println("Caso 1: ");
        System.out.println("No que sera removido = " + no7.getChave());
        System.out.println("Filhos do no que sera removido: " + t.children(no7));
        t.remocao(no7.getChave()); // sem filho
        System.out.println(t.elements());
        System.out.println("Size: " + t.size());




        System.out.println("Filhos da raiz: " + t.children(no1));


        System.out.println("_._._._._._._._._._._._._._._._._._._._.");
        System.out.println("Caso 2: ");
        System.out.println("No que sera removido = " + no2.getChave());
        System.out.println("Filhos do no que sera removido: " + t.children(no2));
        t.remocao(no2.getChave()); // com 1 filho
        System.out.println(t.elements());
//
//        System.out.println("_._._._._._._._._._._._._._._._._._._._.");
//        System.out.println("Caso 3: ");
//        t.remocao(no4); // com 2 filho
//        System.out.println(t.elements());




    }
}
