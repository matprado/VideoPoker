package VideoPoker;

/**
 * Essca classe representa uma quantidade de moedas em um jogo.
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Moeda {
	
	private int moeda;
	
	/**
	 * Construtor para inicializar a moeda com o padrão de 200.
	 */
	public Moeda() {
		moeda = 200;
	}
	
	/**
	 * Construtor para inicializar a moeda com n de quantidade.
	 */
	public Moeda(int n) {
		moeda = n;
	}
	
	/**
	 * Método get para as moedas.
	 * @return as moedas.
	 */
	public int getMoeda() {
		return moeda;
	}
	
	/**
	 * Método para descontar n no saldo de moedas.
	 * @param n - o número a ser descontado
	 */
	public void perdeMoeda(int n) {
		moeda -= n;
	}
	
	/**
	 * Método para acrescentar n no saldo de moedas.
	 * @param n - o valor a ser acrescentado.
	 */
	public void ganhaMoeda(int n) {
		moeda += n;
	}
	
	/**
	 * Método para informar se há saldo negativo de moedas.
	 * @return - boolean
	 */
	public boolean saldoNegativo() {
		return (moeda < 0);
	}
	
	/**
	 * Método para informar se há saldo zerado de moedas.
	 * @return - boolean
	 */
	public boolean saldoZero() {
		return (moeda == 0);
	}
	
}
