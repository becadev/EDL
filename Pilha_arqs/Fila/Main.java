package Fila;
public class Main {
    public static void main(String[] args) {
        FilaArray f = new FilaArray(5);

        System.out.println("Teste isEmpty: " + f.isEmpty());

        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(3);
        f.enqueue(4);

        System.out.println("Status da fila: ");
        f.status();

        System.out.println("Teste size: " + f.size());

        System.out.println("Teste isEmpty: " + f.isEmpty());

        System.out.println("Teste first: " + f.first());

        System.out.println("Teste dequeue: " + f.dequeue());
        f.status();
        /*
        * Quando for fazer a quebra da fila, ele pode ficar [6 2 3 4 5]
        * pq a fila nunca pode ficar com cheia, sempre tem que ter 1 espaço sobrando
        * então nesse caso teria que aumentar a capacidade, mas se fosse maior tipo: 6 null 2 3 4 5
        * ai daria certo
        * */

        System.out.println("Teste de fila config quebrada");
        f.enqueue(5);
        f.status();
        f.enqueue(6);
        f.status();
        System.out.println("Teste size: " + f.size());


//        System.out.println("Teste de increase capacity");
//        f.enqueue(7);
//        f.status();


    }
}
