package cartas;

import util.Random;

/**
 * Essa classe representa o conjunto total de todas as cartas existentes que serão retiradas. 
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Baralho {
	
	private Carta[] vet = new Carta[52];
	private int cartasDisponiveis;
	private Random r;
	
	
	/**
	 * Construtor que inicializa todas as cartas do baralho e a seed do método Random()
	 */
	public Baralho() {
		for(int i=0; i<52; i++) {
			vet[i] = new Carta();
		}
		r = new Random();
		cartasDisponiveis = 52;
		for(int i=0; i<13; i++) {
			for(int j=0; j<4; j++){
				vet[(i*4)+j].setCarta(i,j); //inicializa todas as cartas possíveis
			}
		}
	}
	
	/**
	 * Método getter para cartas disponíveis;
	 * @return - quantidade de cartas dispoíveis
	 */
	public int getCartasDisponiveis() {
		return cartasDisponiveis;
	}

	/**
	 * Método para remover uma carta na posição i do baralho
	 * @param i - posição da carta
	 * @return - a Carta removida
	 */
	public Carta removeCarta(int i) {
		Carta removida = new Carta();
		removida = this.vet[i];
		/*Preenche a posição removida com a última carta do baralho atualmente*/
		vet[i] = vet[cartasDisponiveis-1];
		/*Remove a carta*/
		vet[cartasDisponiveis-1] = null;
		this.cartasDisponiveis--;
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
			ret[i] = new Carta();
		}
		for(int i=0; i<n; i++) {
			ret[i] = removeCarta(r.getIntRand(0, cartasDisponiveis));
		}
		return ret;
	}
	
	
	
}
