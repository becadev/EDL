package Vetor.ArrayVetor;

public class Main {
    public static void main(String[] args) {
        ArrayVetor a = new ArrayVetor(5);

        System.out.println("Teste isEmpty: " + a.isEmpty());
        System.out.println("Teste size: " + a.size());
        for(int i = 0 ; i < 6 ; i++) {
//
            a.insertAtRank(i, i+1);
        }
        System.out.println("Teste isEmpty: " + a.isEmpty());
        System.out.println("Teste size: " + a.size());
        a.Status();

        System.out.println("Teste removeAtRank: " + a.removeAtRank(3));
        System.out.println("Teste replaceAtRank: " + a.replaceAtRank(3, 5));
        System.out.println("Teste elementAtRank: " + a.elemeaAtRank(3));

        a.Status();

    }
}
