package Lista.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList(5);
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
        a.replaceElement(4,6);
        a.status();

        System.out.println("Teste metodo before: elemento antes posição 4 = " + a.before(4));
        a.status();

        System.out.println("Teste metodo after: elemento depois posição 4 = " + a.after(4));
        a.status();

        System.out.println("Teste metodo fisrt: " + a.First());
        a.status();

        System.out.println("Teste metodo last: " + a.Last());
        a.status();

        System.out.println("Teste metodo insertBefore: inserindo elemento 7 antes da posição 3 ");
        a.insertBefore(3,7);
        a.status();

        System.out.println("Teste metodo insertFirst: inserindo elemento 0 na primeira posição ");
        a.insertFirst(0);
        a.status();
        System.out.println("Teste metodo isFirst: elemento 1 é primeiro? " + a.isFirst(1));
        a.status();

        System.out.println("Teste metodo isFirst: elemento 0 é primeiro? " + a.isFirst(0));
        a.status();

        System.out.println("Teste size: " + a.size());

        System.out.println("Teste metodo isLast: elemento 6 é ultimo? " + a.isLast(6));
        a.status();

        System.out.println("Teste metodo isLast: elemento 5 é ultimo? " + a.isLast(5));
        a.status();

        System.out.println("Teste metodo remove: removendo elemento na posição 2: ");
        a.remove(2);
        a.status();
    }
}
