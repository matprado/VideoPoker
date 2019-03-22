package VideoPoker;

/**
 * Essca classe representa o jogador com sua mão de cartas e suas moedas
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Jogador {

	private MaoDeCartas mao;
	private Moeda moedas;
	
	/**
	 * Contrutor padrão que inicializa a mão de cartas e as moedas na regra padrão de jogo
	 */
	public Jogador() {
		mao = new MaoDeCartas();
		moedas = new Moeda();
	}
	
	/**
	 * Contrutor inicializa a mão de cartas e as moedas
	 * @param cartas - quantidade de cartas na mão
	 * @param moedas - quantidade de moedas
	 */
	public Jogador(int cartas, int moedas) {
		mao = new MaoDeCartas(cartas);
		this.moedas = new Moeda(moedas);
	}
	
	public void aposta(int n) {
		
	}
	
	@Override
	public void toString() {
		
	}
	
	
	/**
	 * Método para embaralhar, ou seja, se perde as cartas que estavam na mão no jogador voltando ao baralho(situação inicial).
	 */
	public void Embaralha() {
		mao = new MaoDeCartas();
	}
	
		
}
