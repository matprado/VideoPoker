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
	
	/**
	 * 
	 * @return Valor da carta, de 2 a 14 (Onde 2 é 2 e 14 é As);
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
		if(this.valor<11 && this.valor > 1) {
			aux += this.valor + " ";
		}
		else {
			switch(this.valor) {
				case 11: aux += "J ";
					break;
				case 12: aux += "Q ";
					break;
				case 13: aux += "K ";
					break;
				case 14: aux += "A ";
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
		return aux;
	
	}
}
