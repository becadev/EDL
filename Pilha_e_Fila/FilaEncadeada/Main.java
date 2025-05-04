package FilaEncadeada;

public class Main {
    public static void main(String[] args) {
        FilaEncadeada fila = new FilaEncadeada();

        System.out.println("Teste size inicial: " + fila.size());
        System.out.println("Teste isEmpty: " + fila.isEmpty());
        System.out.println("Teste de enqueue: ");
        System.out.print("Adicionando: ");
        for(int i = 1 ; i <= 10 ; i++ ) {
            System.out.print(i +  " ");
            fila.enqueue(i);
        }
        System.out.println('\n' + "Teste size atual: " + fila.size());
        System.out.println("Status atual da fila: ");
        fila.statusFilaEncadeada();

        System.out.println("Teste first: " + fila.first());
        System.out.println("Teste size atual: " + fila.size());
        System.out.println("Teste dequeue: " + fila.dequeue());

        System.out.println("Teste size atual: " + fila.size());
        System.out.println("Status atual da fila: ");
        fila.statusFilaEncadeada();
    }
}
