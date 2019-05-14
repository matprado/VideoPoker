package moedas;

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
	 * Método para setar um valor para moeda
	 * @param x - o novo valor
	 */
	public void setMoeda(int x) {
		moeda = x;
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
	
	/**
	 * Método para conferir se uma aposta é válida ou não, ou seja, se está dentro dos limites de moeda disponível.
	 * @param aposta - valor da aposta.
	 * @return - boolean com a resposta.
	 */
	public boolean apostaValida(int aposta) {
		return (aposta >= 0 && aposta <= moeda);	
	}
	
	@Override
	public String toString() {
		String aux = new String();
		aux += "$$$$     MONEY     $$$$\n";
		aux += "\t " + this.moeda;
		aux += "\n";
		aux += "$$$$\t\t   $$$$\n";
		return aux;
	}
	
}
