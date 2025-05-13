package FilaTwoPilha;

public class Main {
    public static void main(String[] args) {
        FilaArray f = new FilaArray(10);
        System.out.println("Teste isEmpty: " + f.isEmpty());
        System.out.println("Capacidade total incial: " + f.capacity());
        System.out.println("Teste size: " + f.size());

        long beg = System.nanoTime();
        for(int i = 1 ; i <= f.capacity() ; i++)
            f.enqueue(i);
        double runtime = (System.nanoTime() -  beg) / 1_000_000.0;
        System.out.printf("runtime enqueue sem aumento de capacidade em ms: %.4f ms %n", runtime);
        System.out.println("Teste size pos enqueue: " + f.size());
        f.status();

        // tempo de execuçao com increase capacity
        beg = System.nanoTime();
        f.enqueue(11);
        runtime = (System.nanoTime() -  beg) / 1_000_000.0;
        System.out.printf("runtime enqueue com aumento de capacidade em ms %.4f ms %n:", runtime);
        System.out.println("Teste size pos enqueue: " + f.size());
        System.out.println("Teste capacidade total: " + f.capacity());
        System.out.println("Status da fila: ");
        f.status();

        System.out.println("Teste isEmpty: " + f.isEmpty());
        System.out.println("Teste first: " + f.first());

        // tempo de execução dequeue
        beg = System.nanoTime();
        System.out.println("Teste dequeue: " + f.dequeue());
        System.out.println("Teste size depois do dequeue: " + f.size());
        runtime = (System.nanoTime() -  beg) / 1_000_000.0;
        System.out.printf("runtime dequeue em ms: %.4f ms %n", runtime);
//        %.4f ms %n -> %n = pula linha
        f.status();

    }
}
