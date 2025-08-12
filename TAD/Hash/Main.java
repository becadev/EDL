package Hash;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        TabelaHash h = new TabelaHash(13);
        System.out.println("teste metodo isempty: " + h.isEmpty());
        System.out.println("teste metodo size: " + h.size());
        System.out.println("teste metodo insertion: ");
        System.out.println("inserindo as chaves:  18 41, 22, 44, 59, 32, 31, 73");

        h.insertItemHashing(18, 1);
        h.insertItemHashing(41, 2);
        h.insertItemHashing(22, 3);
        h.insertItemHashing(44, 4);
        h.insertItemHashing(59, 1);
        h.insertItemHashing(32, 7);
        h.insertItemHashing(31, 9);
        h.insertItemHashing(73, 10);
        System.out.println("teste metodo size: " + h.size());
        System.out.println("teste metodo keys: ");
        System.out.print(Arrays.toString(h.keys()) + " "); // pra transformar em array ai

        System.out.println("teste metodo elements: ");
        System.out.println(Arrays.toString(h.Elements())); // pra transformar em array ai

        System.out.println("teste metodo remove: ");
        System.out.println("removendo chave 44...");
        h.removeElement(44);

        System.out.println("estado após remoção");
        System.out.println(Arrays.toString(h.keys()));

        System.out.println("teste metodo find: ");
        System.out.println("procurando elemento da chave 59 ");
        System.out.println(h.findeElement(59)); // pra transformar em array ai

        System.out.println("removendo chave 44...");
        h.removeElement(32);

        System.out.println("inserindo a chave 89");

        h.insertItemHashing(89, 777);

        System.out.println("teste metodo keys: ");
        System.out.println(Arrays.toString(h.keys()) + " "); // pra transformar em array ai

        System.out.println("teste metodo elements: ");
        System.out.println(Arrays.toString(h.Elements())); // pra transformar em array ai

        h.status();
    }
}



