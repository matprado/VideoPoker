package VideoPoker;

/**
 * Essca classe representa um conjunto de cartas numa mão.
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class MaoDeCartas {

	private Carta[] mao;
	private int n;
	private Baralho baralho;
	
	/**
	 * Contrutor padrão que inicializa as cartas e o baralho.
	 */
	public MaoDeCartas() {
		n = 5;
		baralho = new Baralho();
		mao = new Carta[5];
	}
	
	/**
	 * Contrutor inicializa as cartas e o baralho
	 * @param n - quantidade de cartas na mão
	 */
	public MaoDeCartas(int n) {
		this.n = n;
		baralho = new Baralho();
		mao = new Carta[n];
	}
	
	/**
	 * Método para pegar n cartas do baralho
	 */
	public void pegaCartas() {
		mao = baralho.getCartas(n);
	}
	
	/**
	 * Método para pegar cartas do baralho indicadas pela string(com números entre espaços)
	 * @param quais - string com as cartas a serem modificadas
	 */
	public void pegaCartas(String quais) {
		Carta[] aux = new Carta[1];
		int num = 0;
		/*Percorre string*/
		for(int i=0; i<quais.length(); i++) {
			//pega o char atual na string
			char atual = quais.charAt(i);
			if(atual != ' ' && atual != '\0') {
				//Pega a posição da carta na mão
				num = Character.getNumericValue(atual);
				/*Se for posição válida*/
				if(num > 0 && num <= n) {
					/*Pega uma carta do baralho*/
					aux = baralho.getCartas(1);
					/*Coloca a nova carta na posicao indicada da mão(vetor representado de 0 até n-1)*/
					mao[num-1] = aux[0];
				}	
			}
		}	
	}
	
	
	
	
}
