package Pilha.Trabalho_pilha;

public class Main {
    public static void main(String[] args) {
        PilhaColorida pc = new PilhaColorida(2,2); // 4 = tamanho da pilha vermelha | 5 = tamanho da pilha preta | pilha colorida terá tamanho igual a 11(a soma das duas pilhas mais dois)

        System.out.println("__________ Teste metodo isEmpty __________");
        System.out.println(pc.isEmptyPreta());
        System.out.println(pc.isEmptyVermelha());
        System.out.println("___________________________________________");

        pc.pushPreta(2);
        pc.pushVermelha(3);

        pc.pushPreta(7);
        pc.pushVermelha(8);

        pc.pushPreta(72);
        pc.pushVermelha(10);

        pc.pushPreta(21);
        pc.pushVermelha(11);

//        pc.pushPreta(2);
//        pc.pushVermelha(1);

        System.out.println("__________ Teste metodo Pop __________");
        System.out.println("Antes de realizar os Pops: ");
        pc.status();

        System.out.println("Pop vermelho: " + pc.popVermelho());
        System.out.println("Pop preto: " + pc.popPreto());

        System.out.println("Apos os Pops");
        pc.status();
        System.out.println("_______________________________________");

        System.out.println("___________ Teste metodo Top ___________");
        System.out.println("Top vermelho: " + pc.topVermelho());
        System.out.println("Top preto: " + pc.topPreto());
        System.out.println("_______________________________________");



        System.out.println("___________ Teste metodo Reduzir array ___________");
        pc.status();
        pc.popVermelho();
        pc.popPreto();
        pc.popPreto();
        pc.status();
        System.out.println("_______________________________________");



        System.out.println("__________ Teste metodo size __________");
        System.out.println("Size vermelho:" + pc.sizeVermelha());
        System.out.println("Size preto:" + pc.sizePreto());
        System.out.println("Size pilha colorida:" + pc.sizeColorida());
        System.out.println("________________________________________");






        System.out.println("__________ Teste metodo isEmpty __________");
        System.out.println(pc.isEmptyPreta());
        System.out.println(pc.isEmptyVermelha());
        System.out.println("___________________________________________");


        System.out.println("Status Final:");
        pc.status();
    }
}
