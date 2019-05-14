package videopoker;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import cartas.MaoDeCartas;
import util.EntradaTeclado;
import moedas.Moeda;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	
	public Gui(String nome){
		super(nome);
		this.setSize(800, 600);
		this.setLocation(300,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void desenhaMenu() {
		/*BEGINNING OF MENU INICIAL*/	
		
	
		JLabel label = new JLabel(new ImageIcon("/home/mateusp_8877/Desktop/POO/exercicios/VideoPoker/png/LOGO.png"),
								  JLabel.CENTER);
		this.add(BorderLayout.CENTER,label);
		this.setSize(800, 600);
		this.setLocation(300,100);
		JButton iniciar = new JButton();
		iniciar.add(BorderLayout.CENTER, 
					new JLabel(new ImageIcon("/home/mateusp_8877/Desktop/POO/exercicios/VideoPoker/png/botaoIniciar.png"),
					JLabel.CENTER));
		this.add(BorderLayout.SOUTH, iniciar);
		Gui aux = this;
		/*END OF MENU INICIAL*/
		ActionListener clickIniciar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aux.getContentPane().removeAll();
		        aux.revalidate();
		        aux.repaint();
		        aux.comecaJogo();
		    }
		};
		iniciar.addActionListener(clickIniciar);
	}
	
	
	private void comecaJogo() {
		
		MaoDeCartas mao = new MaoDeCartas();
		Moeda creditos = new Moeda();
		String escolha = "";
		int aposta	 = 0;
		boolean naoJogou = true;
		boolean querJogar = true;
		boolean erroLeitura = false;
		
		
		
		
		do{	
			System.out.print("\n\n" + creditos.toString() + "\n");
			
			System.out.print("Digite a quantidade de moedas que você vai apostar:\n(apostar 0 moedas termina o jogo!)\n");
			
			
			
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
	
	public static void main(String[] args) {

		Gui corpus = new Gui("VIDEO POKER");
		corpus.desenhaMenu();
	
	}
	
}
