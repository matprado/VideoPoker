package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import exception.ETException;


/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa funções para
 * ler strings, inteiros e doubles. 
 * Ela não faz verificações se o que foi digitado realmente
 * é o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, até que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usuário.
	 */
	public static String leString(){
		String x;
		try {
			x = br.readLine();
		}catch(Exception e) {
			throw new ETException("Erro na entrada do teclado!");
		}
		return x;
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num inteiro. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usuário. 
	 */
	public static int leInt(){
		String x;
		int n;
		try {
			x = leString();
			n = Integer.parseInt(x);
		}catch(Exception e) {
			throw new ETException("Erro na entrada do teclado!");
		}
		return n;
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num double. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usuário. 
	 */
	public static double leDouble(){
		String x;
		double n;
		try{
			x = leString();
			n = Double.parseDouble(x);
		}catch(Exception e) {
			throw new ETException("Erro na entrada do teclado!");	
		}
		return n;
	}
}
