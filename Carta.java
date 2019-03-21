package VideoPoker;

public class Carta {
	private int valor;
	private int naipe;
	
	public Carta(int valor, int naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	/**
	 * 
	 * @return Valor da carta, de 0 a 12 (Onde 0 é Ás e 12 é Reis);
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
		if(this.valor<10) {
			aux += this.valor + " ";
		}
		else {
			switch(this.valor) {
				case 10: aux += "J ";
					break;
				case 11: aux += "Q ";
					break;
				case 12: aux += "K ";
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
