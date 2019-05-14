package videopoker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import cartas.Carta;
import cartas.MaoDeCartas;
import util.EntradaTeclado;
import moedas.Moeda;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	
	MaoDeCartas mao;
	Moeda creditos;
	private String escolha;
	private int apostando;
	private int trocas;
	
	public Gui(String nome){
		super(nome);
		mao = new MaoDeCartas();
		creditos = new Moeda();
		escolha = "";
		apostando = 0;
		this.setSize(800, 600);
		this.setLocation(300,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void escolheu(String s) {
		escolha += s;
	}
	
	public String getEscolha() {
		return escolha;
	}
	
	public void resetaEscolha() {
		escolha = "";
	}
	
	public void aumentaAposta(int x) {
		apostando += x;
	}
	
	public void zeraAposta() {
		apostando = 0;
	}
	
	public int getAposta() {
		return apostando;
	}
	
	public int getTrocas() {
		return trocas;
	}
	
	public void setTrocas(int x) {
		trocas = x;
	}
	
	public static void main(String[] args) {

		Gui corpus = new Gui("VIDEO POKER");
		corpus.desenhaMenu();
	
	}
	
	private void desenhaMenu() {
		/*BEGINNING OF MENU INICIAL*/	
		this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
		JLabel label = new JLabel(new ImageIcon("png/LOGO.png"), JLabel.CENTER);
		this.add(BorderLayout.CENTER,label);
		this.setSize(800, 600);
		this.setLocation(300,100);
		JButton iniciar = new JButton();
		iniciar.add(BorderLayout.CENTER, new JLabel(new ImageIcon("png/botaoIniciar.png"), JLabel.CENTER));
		this.add(BorderLayout.SOUTH, iniciar);
		Gui aux = this;
		/*END OF MENU INICIAL*/
		ActionListener clickIniciar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aux.mudarTelaAposta();
		    }
		};
		iniciar.addActionListener(clickIniciar);
		this.setVisible(true);
	}
	
	private void mudarTelaAposta() {
		zeraAposta();
		this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
        this.setLayout(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(new JLabel());
        JLabel valorGrana = new JLabel(creditos.getMoeda() + " FICHAS", JLabel.CENTER);
        Color green = new Color(0, 103, 0);
        valorGrana.setFont(new Font(valorGrana.getFont().getName(), Font.PLAIN, 80));
        valorGrana.setSize(800,300);
        valorGrana.setForeground(Color.WHITE);
        JPanel grana = new JPanel();
        panel.setBackground(green);
        grana.setBackground(new Color(0, 50, 0));
        grana.add(BorderLayout.CENTER, valorGrana);
        
        panel.add(grana);
        panel.add(new JLabel());
        
        this.add(panel);
        
        JPanel interativo = new JPanel(new GridLayout(3, 1));
        
        interativo.setBackground(green);
        JTextField qtdAposta = new JTextField(apostando + "");
        qtdAposta.setFont(new Font(qtdAposta.getFont().getName(), Font.PLAIN, 40));
        qtdAposta.setHorizontalAlignment(JTextField.CENTER);
        interativo.add(qtdAposta);
        
        JButton b1, b10, b50, b100, b1000;
        
        Gui gui = this;
        ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("1".equals(e.getActionCommand())) {
					aumentaAposta(1);
					qtdAposta.setText(getAposta() + "");
				}
				else if("10".equals(e.getActionCommand())) {
					aumentaAposta(10);
					qtdAposta.setText(getAposta() + "");
				}
				else if("50".equals(e.getActionCommand())) {
					aumentaAposta(50);
					qtdAposta.setText(getAposta() + "");
				}
				else if("100".equals(e.getActionCommand())) {
					aumentaAposta(100);
					qtdAposta.setText(getAposta() + "");
				}
				else if("1000".equals(e.getActionCommand())) {
					aumentaAposta(1000);
					qtdAposta.setText(getAposta() + "");
				}
				else if("limpa".equals(e.getActionCommand())) {
					zeraAposta();
					qtdAposta.setText(getAposta() + "");
				}
				else if("apostar".equals(e.getActionCommand())) {
					if(getAposta() == 0) {
						JOptionPane.showMessageDialog(gui, "Aposta nula.\nTente novamente!");
					}
					else if(getAposta() <= creditos.getMoeda()) {
						mao.pegaCartas();
						setTrocas(3);
						resetaEscolha();
						creditos.perdeMoeda(getAposta());
						mudarTelaPartida();
					}
					else {
						zeraAposta();
						qtdAposta.setText(getAposta() + "");
						JOptionPane.showMessageDialog(gui, "Aposta acima da quantidade de fichas possuídas.\nTente novamente!");
					}
				}
				else if("sair".equals(e.getActionCommand())) {
					desenhaMenu();
				}
		    }
		};
		
        b1 = new JButton("1");
        b1.addActionListener(listener);
        b1.setActionCommand("1");
        
        b10 = new JButton("10");
        b10.addActionListener(listener);
        b10.setActionCommand("10");
        
        b50 = new JButton("50");
        b50.addActionListener(listener);
        b50.setActionCommand("50");
        
        b100 = new JButton("100");
        b100.addActionListener(listener);
        b100.setActionCommand("100");
        
        b1000 = new JButton("1000");
        b1000.addActionListener(listener);
        b1000.setActionCommand("1000");
        
        JPanel botoes = new JPanel(new GridLayout(1, 5));
        botoes.add(b1);
        botoes.add(b10);
        botoes.add(b50);
        botoes.add(b100);
        botoes.add(b1000);
        interativo.add(botoes);
        
        JPanel botoes2 = new JPanel(new GridLayout(1, 3));
        JButton sair, limpa, apostar;
        
        sair = new JButton("Sair");
        sair.addActionListener(listener);
        sair.setActionCommand("sair");
        
        limpa = new JButton("Limpar");
        limpa.addActionListener(listener);
        limpa.setActionCommand("limpa");
        
        apostar = new JButton("Apostar");
        apostar.addActionListener(listener);
        apostar.setActionCommand("apostar");
        
        botoes2.add(limpa);
        botoes2.add(apostar);
        botoes2.add(sair);
        
        interativo.add(botoes2);
        
        this.add(interativo);
        this.setVisible(true);
	}
	
	private void mudarTelaPartida() {
		
		this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
        this.setLayout(new GridLayout(2,1));
        
		JPanel painelCartas = new JPanel(new GridLayout(1,5));
		JLabel[] cartas = new JLabel[5];
		int x=0;
		for(int i=0; i<5; i++) {
			cartas[i] = associarImagemCarta(mao.getMao()[i]);
			JPanel aux = new JPanel(new BorderLayout());
			aux.add(cartas[i], BorderLayout.SOUTH);
			aux.setBackground(new Color(0, 80+x, 0));
			x+=20;
			painelCartas.add(aux);
		}
		
		//painelCartas.setBackground(new Color(0, 103, 0));
		this.add(painelCartas);
		
		JPanel painel1 = new JPanel(new GridLayout(3,1));
		JPanel checks = new JPanel(new GridLayout(1, 5));
		
		JCheckBox trocarCarta1 = new JCheckBox();
		trocarCarta1.setBackground(new Color(0, 80, 0));
		JPanel jp = new JPanel(new BorderLayout());
		jp.add(trocarCarta1, BorderLayout.NORTH);
		jp.setBackground(new Color(0, 80, 0));
		checks.add(jp);
		
		JCheckBox trocarCarta2 = new JCheckBox();
		trocarCarta2.setBackground(new Color(0, 100, 0));
		jp = new JPanel(new BorderLayout());
		jp.add(trocarCarta2, BorderLayout.NORTH);
		jp.setBackground(new Color(0, 100, 0));
		checks.add(jp);
		
		JCheckBox trocarCarta3 = new JCheckBox();
		trocarCarta3.setBackground(new Color(0, 120, 0));
		jp = new JPanel(new BorderLayout());
		jp.add(trocarCarta3, BorderLayout.NORTH);
		jp.setBackground(new Color(0, 120, 0));
		checks.add(jp);
		
		JCheckBox trocarCarta4 = new JCheckBox();
		trocarCarta4.setBackground(new Color(0, 140, 0));
		jp = new JPanel(new BorderLayout());
		jp.add(trocarCarta4, BorderLayout.NORTH);
		jp.setBackground(new Color(0, 140, 0));
		checks.add(jp);
		
		JCheckBox trocarCarta5 = new JCheckBox();
		trocarCarta5.setBackground(new Color(0, 160, 0));
		jp = new JPanel(new BorderLayout());
		jp.add(trocarCarta5, BorderLayout.NORTH);
		jp.setBackground(new Color(0, 160, 0));
		checks.add(jp);
        
        painel1.setBackground(new Color(0, 103, 0));
        painel1.add(checks);
        
        JPanel painel2 = new JPanel(new GridLayout(1, 5));
        painel2.add(new JLabel());
        painel2.add(new JLabel());
       
        
        JButton trocar = new JButton();
        if(trocar.getText().equals("")) trocar.setText("Trocar");
        if(getTrocas() == 1) {
			trocar.setText("Finalizar");
		}
        Gui aux = this;
        ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTrocas() == 0) {
		        	int resultado = mao.aposta(getAposta());
					creditos.ganhaMoeda(resultado);
					if(creditos.getMoeda() <= 0) {
						JOptionPane.showMessageDialog(aux, "Sem fichas para continuar. Faliu!");
						desenhaMenu();
					}else {
						if((resultado-getAposta()) > 0)
							JOptionPane.showMessageDialog(aux, "Ganhou "+(resultado-getAposta())+" créditos!");
						else if((resultado-getAposta()) < 0)
							JOptionPane.showMessageDialog(aux, "Perdeu "+(-(resultado-getAposta()))+" créditos!");
						else
							JOptionPane.showMessageDialog(aux, "Créditos mantidos!");
						mao.embaralhar();
						mudarTelaAposta();
					}
				}
				else{
					setTrocas(getTrocas()-1);
					if (trocarCarta1.isSelected()) {
					    escolheu("1 ");
					}
			        if (trocarCarta2.isSelected()) {
						escolheu("2 ");
					}
			        if (trocarCarta3.isSelected()) {
						escolheu("3 ");
					}
			        if (trocarCarta4.isSelected()) {
						escolheu("4 ");
					}
			        if (trocarCarta5.isSelected()) {
						escolheu("5 ");
					}
					mao.pegaCartas(getEscolha());
					resetaEscolha();
					mudarTelaPartida();
				}	
			}
		};
		trocar.addActionListener(listener);
		painel2.setBackground(new Color(0, 103, 0));
		painel2.add(trocar);
		painel2.add(new JLabel());
        painel2.add(new JLabel());
        painel1.add(painel2);
        
        JPanel painel3 = new JPanel(new GridLayout(1, 2));
        JTextField texto1 = new JTextField("Fichas apostadas: "+getAposta()+".");
        texto1.setBackground(new Color(0, 103, 0));
        texto1.setForeground(Color.WHITE);
        texto1.setFont(new Font(texto1.getFont().getName(), Font.PLAIN, 20));
        JTextField texto2 = new JTextField("Trocas faltando: "+getTrocas()+".");
        texto2.setFont(new Font(texto2.getFont().getName(), Font.PLAIN, 20));
        texto2.setBackground(new Color(0, 103, 0));
        texto2.setForeground(Color.WHITE);
        painel3.add(texto1);
        painel3.add(texto2);
        painel1.add(painel3);
        
        
        this.add(painel1);
        this.setVisible(true);
	}
	
	private JLabel associarImagemCarta(Carta c) {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("png/carta_"+c.getValor()+"_"+c.getNaipe()+".png").getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT)));
		return label;
	}
	
	
}
