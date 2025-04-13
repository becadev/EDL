package Q5;
/*
 * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class testePilhaColorida {
	public static void main(String[] args) {				
		PilhaColorida pc = new PilhaColorida(4,5); // 4 = tamanho da pilha vermelha | 5 = tamanho da pilha preta | pilha colorida terá tamanho igual a 11(a soma das duas pilhas mais dois)
		pc.pushPreta(2);
		pc.pushVermelha(3);
	}
}
