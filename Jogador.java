package VideoPoker;

/**
 * Essca classe representa o jogador com suas cartas e moedas
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Jogador {

	private Carta[] mao;
	private int n;
	private double moeda;
	private Baralho deck;
	
	/**
	 * Contrutor inicializa as cartas, as moedas e o baralho
	 * @param n - quantidade de cartas na mão
	 * @param moeda - quantidade de moedas
	 */
	public Jogador(int n, double moeda) {
		this.n = n;
		deck = new Baralho();
		this.moeda = moeda;
		mao = new Carta[n];
	}
	/**
	 * Método para pegar n cartas do baralho
	 */
	public void pegaCartas() {
		mao = deck.getCartas(n);
	}
	/**
	 * Método para pegar cartas do baralho indicadas pela string
	 * @param quais - string com as cartas a serem modificadas
	 */
	public void pegaCartas(String quais) {
		Carta[] aux = new Carta[1];
		int num = 0;
		for(int i=0; i<quais.length(); i++) {
			if(quais.charAt(i) != ' ' && quais.charAt(i) != '\0') {
				aux = deck.getCartas(1);
				num = Character.getNumericValue(quais.charAt(i));
				mao[num-1] = aux[0];
			}
		}	
	}
	
	
		
}
