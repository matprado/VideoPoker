package VideoPoker;

/**
 * Essca classe representa uma carta com um valor e um naipe;
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class Carta {
	private int valor;
	private int naipe;
	
	public Carta(int valor, int naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	public Carta() {
		this.valor = 0;
		this.naipe = 0;
	}
	
	/**
	 * 
	 * @return Valor da carta, de 0 a 12 (Onde 0 é 2 e 12 é As);
	 */
	public int getValue(){
		return this.valor;
	}
	
	/**
	 * 
	 * @return Retorna o naipe da carta. Onde 0 é Paus, 1 é Copas, 2 é Espadas e 3 é Ouros.
	 */
	public int getNaipe() {
		return this.naipe;
	}
	
	@Override
	public String toString() {
		String aux = new String();
		aux += " - - -\n|     |\n| ";
		if(this.valor<9 && this.valor > -1) {
			aux += this.valor + " ";
		}
		else {
			switch(this.valor) {
				case 9: aux +=  "J ";
					break;
				case 10: aux += "Q ";
					break;
				case 11: aux += "K ";
					break;
				case 12: aux += "A ";
					break;
			}
		}
		switch(this.naipe) {
			case 0: aux += "♣";
					break;
			case 1: aux += "♥";
				break;
			case 2: aux += "♠";
				break;
			case 3: aux += "♦";
				break;
		}
		aux += "  |\n|     |\n - - -\n";
		return aux;
	
	}
}
