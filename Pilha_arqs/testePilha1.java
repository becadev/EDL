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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class testePilha1 {

	public static void main(String[] args) {				
		PilhaArray1 pp = new PilhaArray1(1,0); // 1 => criação de uma pilha com 1 espaço | 0 =>  indice para controlar a posição do topo (ultimo elemento inserido) nesse caso nao tem nenhum elemento
		long beg = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linha;
            while ((linha = br.readLine()) != null && !linha.isEmpty()) {
                n = Integer.parseInt(linha);
                pp.push(n);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler a entrada: " + e.getMessage());
        }
		long end = System.currentTimeMillis();
		System.out.println(end-beg);
		sc.close();	
	}
}
