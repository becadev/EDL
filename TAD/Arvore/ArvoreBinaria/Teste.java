package Arvore.ArvoreBinaria;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinaria t = new ArvoreBinaria();

        System.out.println("TESTE DE INSERCAO: ");


        System.out.println("TESTE DE INSERCAO: ");
        t.inserir(10);
        t.inserir(5);
        t.inserir(6);
        t.inserir(12);
        t.inserir(14);
        t.inserir(7);
        t.inserir(1);
        t.inserir(11);

        System.out.println("TESTE DE INORDER: ");
        t.inOrder();
    }



}
