package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import cards.MaoDeCartas;
import util.EntradaTeclado;
import videopoker.Moeda;

public class VideoPoker {
	
	private static void desenhaMenu(JFrame f) {
		/*BEGINNING OF MENU INICIAL*/		
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(800, 600);
		f.setLocation(300,100);
		JLabel label = new JLabel(new ImageIcon("/Users/matheus/git/VideoPoker/img/iniciar/logo.png"),
								  JLabel.CENTER);
		f.add(BorderLayout.CENTER,label);
		f.setSize(800, 600);
		f.setLocation(300,100);
		JButton iniciar = new JButton();
		iniciar.add(BorderLayout.CENTER, 
					new JLabel(new ImageIcon("/Users/matheus/git/VideoPoker/img/iniciar/botaoIniciar.png"),
					JLabel.CENTER));
		f.add(BorderLayout.SOUTH, iniciar);
		ActionListener clickIniciar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				f.getContentPane().removeAll();
		        f.revalidate();
		        f.repaint();
		    }
		};
		iniciar.addActionListener(clickIniciar);
		
		/*END OF MENU INICIAL*/
	}
	
	public static void main(String[] args) {
		JFrame corpus = new JFrame("VIDEO POKER");
		MaoDeCartas mao = new MaoDeCartas();
		Moeda creditos = new Moeda();
		String escolha = "";
		int aposta	 = 0;
		boolean naoJogou = true;
		boolean querJogar = true;
		boolean erroLeitura = false;
		desenhaMenu(corpus);
		
		do{	
			System.out.print("\n\n" + creditos.toString() + "\n");
			
			System.out.print("Digite a quantidade de moedas que você vai apostar:\n(apostar 0 moedas termina o jogo!)\n");
			
			//Lê a aposta
			do{
				erroLeitura = false;
				try{
					aposta = EntradaTeclado.leInt();
				}catch(Exception e) {
					System.out.println("ENTRADA INVÁLIDA -> DIGITE NOVAMENTE!");
					erroLeitura = true;
				}
			}while(erroLeitura);
			
			//Confere se a aposta é inválida
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
				
				/*jogou pelo menos uma vez*/
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
				
				//Pega as cartas do baralho
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
				
				//Pega as cartas escolhidas do baralho
				mao.pegaCartas(escolha);
				
				//Faz a aposta
				creditos.ganhaMoeda(mao.aposta(aposta));
				
				System.out.print(mao.toString() + "\n");
				
				//embaralha as cartas da mão no baralho
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
