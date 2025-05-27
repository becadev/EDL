package Vetor.VetorLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedVetor a = new LinkedVetor();
        System.out.println("Teste isEmpty: " + a.isEmpty());
        System.out.println("Teste size: " + a.size());
        System.out.println("Teste insertAtRank: ");
        for (int i = 1 ; i <= 5 ; i++){
            System.out.println("Inserindo elemento " + i);
            a.insertAtRank(i,i);
        }

        System.out.println("Teste elementRank no rank tres: " + a.elemeaAtRank(3));
        System.out.println("Teste size: " + a.size());
        System.out.println("-----Status atual-----");
        a.status();

        System.out.println("Teste replace: " + a.replaceAtRank(2,6));
        System.out.println("-----Status atual-----");
        System.out.println("Teste size: " + a.size());
        a.status();

        System.out.println("Teste removeRank: " + a.removeAtRank(3));
        System.out.println("Teste size: " + a.size());
        System.out.println("-----Status atual-----");
        a.status();
    }
}
