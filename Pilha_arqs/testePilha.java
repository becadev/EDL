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
public class testePilha {

	public static void main(String[] args) {				
		PilhaArray pp = new PilhaArray(1,0); // 1 => criação de uma pilha com 1 espaço | 0 =>  indice para controlar a posição do topo (ultimo elemento inserido) nesse caso nao tem nenhum elemento
		pp.push(5);
		pp.push(3);
		pp.pop();
		pp.push(2);
		pp.push(8);
		pp.pop();
		pp.pop();
		pp.push(9);
		pp.push(1);
		pp.pop();
		pp.push(7);
		pp.push(6);
		pp.pop();
		pp.pop();
		pp.push(4);
		pp.pop();
		pp.pop();
		pp.status();
	}
}
