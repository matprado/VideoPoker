package VideoPoker;

/**
 * Essca classe representa um conjunto de cartas numa mão que são pegadas de um baralho.
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
		this.n = 5;
		baralho = new Baralho();
		mao = new Carta[5];
		for(int i=0; i<5; i++) {
			mao[i] = new Carta();
		}
	}
	
	/**
	 * Contrutor inicializa as cartas e o baralho
	 * @param n - quantidade de cartas na mão
	 */
	public MaoDeCartas(int n) {
		this.n = n;
		baralho = new Baralho();
		mao = new Carta[n];
		for(int i=0; i<n; i++) {
			mao[i] = new Carta();
		}
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
		for(int i=0; i<1; i++) {
			aux[i] = new Carta();
		}
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
	/**
	 * 
	 * @return Retorna um booleano se sao naipes iguais ou nao
	 */
	private boolean naipesIguais() {
		int p = this.n-1;
		int[] naipes = new int[this.n];
		boolean verify = true;
		for(int i=0; i<this.n; i++) {
			naipes[i] = mao[i].getNaipe();
		}
		for(int i=0; i<(this.n); i++) {
			for(int j=1; j<=(p); j++) {
				if(naipes[i] != naipes[i+j]) {
					verify = false;
				}
			}
			p--;
		}
		return verify;
	}
	/**
	 * 
	 * @return Retorna um booleano se sao naipes iguais ou nao
	 */
	private boolean cartasSeguidasMaior10() {
		boolean verify = false;
		int[] valores = {1,1,1,1,1};
		int aux = 0;
		int maior = 0, menor = 12;
		for(int i=0; i<this.n; i++) {
			if(mao[i].getValue() > maior) maior = mao[i].getValue();
			if(mao[i].getValue() < menor) menor = mao[i].getValue();
		}
		if(menor>7 && maior<13) {
			//VERIFICANDO SE HÀ UMA SEQUENCIA de 10 a AS
			for(int i=0; i<this.n; i++) {
				valores[(mao[i].getValue())-8] = 0;
			}
			for(int i=0; i<this.n; i++) {
				aux += valores[i];
			}
			if(aux == 0) {
				verify = true;
			}
		}
		return verify;
	}
	
	private boolean cartasSeguidasMenor10() {
		boolean verify = false;
		int[] valores = {0,0,0,0,0,0,0,0,0,0,0,0};
		int aux = 0;
		int maior = 0, menor = 12;
		for(int i=0; i<this.n; i++) {
			if(mao[i].getValue() > maior) maior = mao[i].getValue();
			if(mao[i].getValue() < menor) menor = mao[i].getValue();
		}
		if(maior<12 && menor>1){
			for(int i=0; i<this.n; i++) {
				valores[(mao[i].getValue())-8] = 1;
			}
			for(int i=0; i<12; i++) {
				if(valores[i] == 1 && valores[i+1] == 1 && valores[i+2] == 1 && valores[i+3] == 1 && valores[i+4] == 1 && i<8) {
					verify = true;
				}
			}
		}
		return verify;
	}
	
	public int aposta(int valor) {
		int[] contagem = new int[13];
		contagem = contarCartas();
		int resultado = 0;
		int maisFrequente = this.maiorOcorrencia();
		int segundoMaisFrequente = this.segundaMaiorOcorrencia();
		
		if(maisFrequente == 1) {
			//FLUSH
			if(naipesIguais() && !cartasSeguidasMenor10()){
				resultado = valor*10;
			}
			//STRAIGHT
			else if(!naipesIguais() && cartasSeguidasMenor10()){
				resultado = valor*5;
			}
			//STRAIGHT FLUSH
			else if(naipesIguais() && cartasSeguidasMenor10()){
				resultado = valor*100;
			}
			//ROYAL STRAIGHT FLUSH
			else if(naipesIguais() && cartasSeguidasMaior10()){
				resultado = valor*200;
			}
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
	
	public void embaralhar() {
		baralho = new Baralho();
		//MAO PEGA AS CARTAS NA MAIN
	}
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
}
