package VideoPoker;


public class VideoPoker {
	public static void main(String[] args) {
		
		MaoDeCartas mao = new MaoDeCartas();
		Moeda creditos = new Moeda();
		String escolha = "";
		int aposta = 0;
		boolean naoJogou = true;
		boolean querJogar = true;
		boolean erroLeitura = false;
		
		System.out.print("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
		System.out.print("-    V I D E O   P O K E R    -\n");
		System.out.print("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n\n");
		System.out.print("Aperte Enter para começar...");
	
		
		try{
			EntradaTeclado.leString();
		}catch(Exception e) {
			;
		}
		
		do{	
			System.out.print("\n\n" + creditos.toString() + "\n");
			
			System.out.print("Digite a quantidade de moedas que você vai apostar:\n(apostar 0 moedas termina o jogo!)\n");

			do{
				erroLeitura = false;
				try{
					aposta = EntradaTeclado.leInt();
				}catch(Exception e) {
					System.out.println("ENTRADA INVÁLIDA -> DIGITE NOVAMENTE!");
					erroLeitura = true;
				}
			}while(erroLeitura);
			
			while(!creditos.apostaValida(aposta)) {
				System.out.print("Erro -> aposta inválida!\nPor favor, digite novamente.\n");
				System.out.print("Digite a quantidade de moedas que você vai apostar:\n(apostar 0 moedas termina o jogo!)\n");
				do{
					erroLeitura = false;
					try{
						aposta = EntradaTeclado.leInt();
					}catch(Exception e) {
						System.out.println("ENTRADA INVÁLIDA -> DIGITE NOVAMENTE!");
						erroLeitura = true;
					}
				}while(erroLeitura);
			}
			
			querJogar = (aposta != 0);
			
			if(querJogar) {
				
				naoJogou = false;
				creditos.perdeMoeda(aposta);
	
				mao.pegaCartas();
				
				System.out.print(mao.toString() + "\n");
				System.out.print("Escolha quais cartas deseja trocar(digite entre espaços):\n");
				
				do{
					erroLeitura = false;
					try{
						escolha = EntradaTeclado.leString();
					}catch(Exception e) {
						System.out.println("ENTRADA INVÁLIDA -> DIGITE NOVAMENTE!");
						erroLeitura = true;
					}
				}while(erroLeitura);
				
				mao.pegaCartas(escolha);
				
				System.out.print("\n" + mao.toString() + "\n");
				System.out.print("Escolha quais cartas deseja trocar(digite entre espaços):\n");
				do{
					erroLeitura = false;
					try{
						escolha = EntradaTeclado.leString();
					}catch(Exception e) {
						System.out.println("ENTRADA INVÁLIDA -> DIGITE NOVAMENTE!");
						erroLeitura = true;
					}
				}while(erroLeitura);
				
				mao.pegaCartas(escolha);
				
				creditos.ganhaMoeda(mao.aposta(aposta));
				
				System.out.print(mao.toString() + "\n");
				
				mao.embaralhar();
			}
			
		}while(querJogar && !creditos.saldoNegativo());
		
		
		if(!naoJogou) {
			System.out.print("\n\n" + creditos.toString() + "\n");
			
		}
		
		if(!querJogar) {
			System.out.print("Lembre-se: o que se faz em Vegas, fica em Vegas!\n\nFIM DE JOGO!\n");
		}else {
			System.out.print("Você está com o nome sujo na praça!\n\nFIM DE JOGO\n");
		}
		
	}
}
