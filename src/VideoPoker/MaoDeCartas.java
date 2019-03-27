package VideoPoker;

/**
 * Essca classe representa um conjunto de cartas numa mão que são pegadas de um baralho.
 * @author Mateus Prado(10851707) e Matheus Tomieiro(10734630)
 *
 */
public class MaoDeCartas {

	private Carta[] mao = new Carta[5];
	private int n;
	private Baralho baralho;
	
	/**
	 * Contrutor padrão que inicializa as cartas e o baralho.
	 */
	public MaoDeCartas() {
		this.n = 5;
		baralho = new Baralho();
		//mao = new Carta[5];
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
	
	public int aposta(int valor) {
		int[] contagem = new int[13]; 
		contagem = contarCartas();
		int resultado = 0;
		int maisFrequente = this.maiorOcorrencia();
		int segundoMaisFrequente = this.segundaMaiorOcorrencia();
		
		if(maisFrequente == 1) {
			/*STRAIGHT, FLUSH, STRAIGHT FLUSH E ROYAL STRAIGHT FLUSH*/
		}
		if(maisFrequente == 2 && segundoMaisFrequente == 2) {
			/*Dois Pares*/
			resultado = valor;
		}
		if(maisFrequente == 3){
			if(segundoMaisFrequente == 2) {
				/*FULL HAND*/
				resultado = valor * 20;
			}
			else {
				/*TRINCA*/
				resultado = valor * 2;
			}
		}
		else if(maisFrequente == 4 || maisFrequente == 5) {
			/*QUADRA*/
			resultado = valor * 50;
		}
		
		return resultado;
	}

	public int[] contarCartas() {
		int[] contador = new int[13];
		for(int i=0; i<n; i++) {
			contador[mao[i].getValue()]++;
		}
		return contador;
	}
	
	private int maiorOcorrencia() {
		int[] contador = new int[13];
		contador = contarCartas();
		int maior = -1;
		for(int i=0; i<13; i++) {
			if(contador[i] > maior) { 
				maior = contador[i];
			}
		}
		return maior;
	}
	
	private int segundaMaiorOcorrencia() {
		int[] contador = new int[13];
		contador = contarCartas();
		int maior = -1;
		int posMaior = 0;
		for(int i=0; i<13; i++) if(contador[i] > maior) {
			maior = contador[i];
			posMaior = i;
		}
		int segundaMaior = -1;
		for(int i=0; i<13; i++) if(i != posMaior && contador[i] > segundaMaior) segundaMaior = contador[i];
		return segundaMaior;
	}
	
	/*
	public boolean ocorrenciaDe(int x) {
		for(int i=0; i<n; i++) if(x == mao[i].getValue()) return true;
		return false;
	}*/
	
	/**
	 * Método para embaralhar, ou seja, se perde as cartas que estavam na mão do jogador voltando ao baralho(situação inicial).
	 */
	public void embaralhar() {
		baralho = new Baralho();
		mao = new Carta[n];
	}
	/*
	@Override
	public String toString() {
		String[] vetstr = new String[this.n];
		for(int i=0; i<this.n; i++) {
			vetstr[i] = mao[i].toString();
		}
		String aux = new String();
		for(int i=0; i<this.n; i++) {
			aux += (i+1) + "\t\t";
		}
		aux += "\n";
		for(int i=0; i<5; i++) {
			for(int j=0; j<this.n; j++) {
				for(int k=0; k<vetstr[j].length(); k++) {
					if(vetstr[j].charAt(k) == '\n') {
						vetstr[j] = vetstr[j].substring(k+1,vetstr[j].length());
						break;
					}
					aux += vetstr[j].charAt(k);
				}
				aux += "\t\t";
			}
			aux += "\n";
		}
		return aux;
	}
	*/
}
