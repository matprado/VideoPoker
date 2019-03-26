package VideoPoker;

/**
 * Essa classe representa o conjunto total de todas as cartas existentes que serão retiradas. 
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Baralho {
	
	private Carta[] vet;
	private int cartasDisponiveis;
	private Random r;
	
	/**
	 * Construtor que inicializa todas as cartas do baralho e a seed do método Random()
	 */
	public Baralho() {
		r = new Random();
		cartasDisponiveis = 52;
		vet = new Carta[52];
		for(int i=2; i<15; i++) {
			for(int j=0; j<4; j++)
				vet[(i*4)+j] = new Carta(i, j); //inicializa todas as cartas possíveis
		}
	}
	
	/**
	 * Método para remover uma carta na posição i do baralho
	 * @param i - posição da carta
	 * @return - a Carta removida
	 */
	public Carta removeCarta(int i) {
		Carta removida = vet[i];
		/*Preenche a posição removida com a última carta do baralho atualmente*/
		vet[i] = vet[cartasDisponiveis];
		/*Remove a carta*/
		vet[cartasDisponiveis--] = null;
		return removida;
	}
	
	/**
	 * Método que devolve n cartas aleatórias do baralho, removendo as mesmas
	 * @param n - quantidade de cartas a serem pegas
	 * @return - as n cartas. 
	 */
	public Carta[] getCartas(int n) {
		Carta[] ret = new Carta[n];
		for(int i=0; i<n; i++) {
			ret[i] = this.removeCarta(r.getIntRand(0, cartasDisponiveis+1));
		}
		return ret;
	}
	
	
	
}
