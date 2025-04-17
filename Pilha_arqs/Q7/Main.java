package Q7;

public class Main {
    public static void main(String[] args) {
        PilhaArray p1 = new PilhaArray(1,-1);
        PilhaArray p2 = new PilhaArray(1,-1);
        p1.push(1);
        p1.push(2);
        p1.push(3);
        p1.push(4);
        p1.push(5);

        p2.push(6);
        p2.push(7);
        p2.push(8);
        p2.push(9);
        p2.push(10);

        p1.addPilha(p2);
        System.out.println(p1.size());


        System.out.println(p1.isEmpty()); // verifica se está vazia
        System.out.println(p1.pop()); // remove e retorna  o ultimo elemento
        System.out.println(p1.top()); // retorna  o ultimo elemento sem remover
        p1.status();

        p1.Empty(); // esvazia a pilha
        System.out.println(p1.size());
    }
}
