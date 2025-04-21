package Trabalho_pílha;

public class Main {
    public static void main(String[] args) {
        PilhaColorida pc = new PilhaColorida(4,5); // 4 = tamanho da pilha vermelha | 5 = tamanho da pilha preta | pilha colorida terá tamanho igual a 11(a soma das duas pilhas mais dois)

        pc.pushPreta(2);
        pc.pushVermelha(3);
        pc.pushPreta(7);
        pc.pushVermelha(8);
        pc.pushPreta(72);
        pc.pushVermelha(10);
        pc.pushPreta(21);
        pc.pushVermelha(11);
        pc.pushPreta(2);
        pc.pushVermelha(1);
        pc.pushVermelha(3);
        pc.pushVermelha(4);
        pc.status();
    }
}
