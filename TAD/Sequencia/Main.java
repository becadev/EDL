package Sequencia;

import Lista.ArrayList.ArrayList;

public class Main {
    public static void main(String[] args) {
        SequenciaArray a = new SequenciaArray(5);
        System.out.print("Teste size: " + a.size());
        System.out.print("Teste isEmpty: " + a.isEmpty());
        System.out.print("Inserindo elementos do 1 a 5");
        for(int i = 1 ; i <= 5 ; i++) {
            a.insertLast(i);
        }
        System.out.println('\n');
        a.status();
        System.out.println("Teste size: " + a.size());
        System.out.println("Teste isEmpty: " + a.isEmpty());

        System.out.println("Teste metodo swapElements: trocando elementos posições 2 e 3 ");
        a.swapElements(2,3);
        a.status();

        System.out.println("Teste metodo replaceElements: trocando elemento posição 4 por 6 ");
        a.replaceElements(4,6);
        a.status();

        System.out.println("Teste metodo before: elemento antes posição 4 = " + a.before(4));
        a.status();

        System.out.println("Teste metodo after: elemento depois posição 4 = " + a.after(4));
        a.status();

        System.out.println("Teste metodo fisrt: " + a.first());
        a.status();

        System.out.println("Teste metodo last: " + a.last());
        a.status();

        System.out.println("Teste metodo insertBefore: inserindo elemento 7 antes da posição 3 ");
        a.insertBefore(3,7);
        a.status();

        System.out.println("Teste metodo insertFirst: inserindo elemento 0 na primeira posição ");
        a.insertFirst(0);
        a.status();

        System.out.println("Teste atRank: "+ a.atRank(3));
        a.status();

        System.out.println("Teste atRank: "+ a.rankOf(2));
        a.status();

        System.out.println("Teste metodo remove: removendo elemento na posição 2: ");
        a.remove(2);
        a.status();
    }
}
