package Fila;
public class Main {
    public static void main(String[] args) {
        FilaArray f = new FilaArray(5);

        System.out.println("Teste isEmpty: " + f.isEmpty());
        System.out.println("Teste size: " + f.size());
        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(3);
        f.enqueue(4);
        System.out.println("Teste size pos enqueue: " + f.size());
        System.out.println("Status da fila: ");
        f.status();

        System.out.println("Teste size: " + f.size());

        System.out.println("Teste isEmpty: " + f.isEmpty());

        System.out.println("Teste first: " + f.first());

        System.out.println("Teste dequeue: " + f.dequeue());
        f.status();

        System.out.println("Teste de fila config quebrada");
        f.enqueue(5);
        f.status();
        f.enqueue(6);
        f.status();
        System.out.println("Teste size: " + f.size());


        System.out.println("Teste de increase capacity");
        f.enqueue(7);
        f.status();
        System.out.println("Teste dequeue: " + f.dequeue());
        f.status();

    }
}
