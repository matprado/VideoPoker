package util;


import java.util.Calendar;

/**
 * Essa classe produz números aleatórios baseados em uma semente.
 * @author Mateus Prado
 *
 */

public class Random {
	
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023;
	
	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente.
	 * @param semente - a seed.
	 */
	public Random(int semente){
		xi = semente;
	}
	
	/**
	 * Construtor que usa uma semente aleatória, adquirida usando o método Calendar.getTimeInMillis().
	 */
	public Random() {
		xi = ((int)Calendar.getInstance().getTimeInMillis() % p);
		if(xi < 0) xi = -xi;
	}
	
	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente e com um boolean que diz
	 * se mescla com o método Calendar.getTimeInMillis() ou não.
	 * @param semente - a seed.
	 * @param usarTempo - boolean que diz se mescla com tempo ou não.
	 */
	public Random(int semente, boolean usarTempo){
		if(usarTempo) {
			xi = ((semente+1) * (int)Calendar.getInstance().getTimeInMillis()) % p;
			if(xi < 0) xi = -xi;
		}else {
			xi = semente;
		}
	}
	
	/**
	 * Método público getRand retorna um double randômico entre 0 e 1 - [0,1) 
	 */
	public double getRand() {
		xi = (a + m * xi) % p; //Calcula próximo xi		
		return ((double)xi / (double)p); // Divide por p para ficar entre 0 e 1 e retorna
	}
	
	/**
	 * Método público getIntRand retorna um número inteiro randômico baseado entre 0 e max - [0,max)
	 */
	public int getIntRand(int max) {
		double aux = getRand(); // Sorteia um número entre 0 e 1
		return (int)(max * aux); // multiplica pelo argumento max e retorna
	}
	/**
	 * Método público getIntRand retorna um número inteiro randômico baseado entre min e max - [min,max)
	 */
	public int getIntRand(int min, int max) throws IllegalArgumentException{
		if(max <= min) {
			throw new IllegalArgumentException("Parâmetros inválidos");
		}
		double aux = getRand();
		return (int)(((max-min)*aux)+min);
	}
	/**
	 * Método público getIntRand retorna um número inteiro randômico entre todos os inteiros possíveis(4 bytes) - [0,2147483647)
	 */
	public int getIntRand() {
		double aux = getRand();
		return (int)(aux * Integer.MAX_VALUE);
	}

	@Override
	public String toString() {
		return xi + "";
	}
	
	/**
	 * Método público que 'seta' uma nova semente s
	 */
	public void setSemente(long semente){
		xi = semente;
	}
	
}
