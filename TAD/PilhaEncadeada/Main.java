package PilhaEncadeada;

public class Main {
    public static void main(String[] args) {
        PilhaEncadeada pilha = new PilhaEncadeada();

        System.out.println("Teste size inicial: " + pilha.size());
        System.out.println("Teste isEmpty: " + pilha.isEmpty());
        System.out.println("Teste de push: ");
        System.out.print("Adicionando: ");
        for(int i = 1 ; i <= 10 ; i++ ) {
            System.out.print(i +  " ");
            pilha.push(i);
        }
        System.out.println('\n' + "Teste size atual: " + pilha.size());
        System.out.println("Status atual da pilha: ");
        pilha.statusPilhaEncadeada();

        System.out.println("Teste top: " + pilha.top());
        System.out.println("Teste size atual: " + pilha.size());
        System.out.println("Teste pop: " + pilha.pop());

        System.out.println("Teste size atual: " + pilha.size());
        System.out.println("Status atual da pilha: ");
        pilha.statusPilhaEncadeada();
    }
}
