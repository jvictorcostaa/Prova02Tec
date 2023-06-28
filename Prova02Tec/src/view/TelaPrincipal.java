package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import code.Interacoes;
import code.RoboInicial;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
	protected Interacoes mov;
	protected JPanel tabuleiro;
	private JPanel telaopcoes;
	private int tamanho;
	private ArrayList<BotaoDoTabuleiro> botoes;
	private int alunos;
	private int bugs;
	protected int rodadas;
	private String nome;
	
	TelaPrincipal(){
		digitarNome();
		this.setTitle("RESGATE DOS ALUNOS NA ILHA DE JAVA");
		this.setSize(700,700);
//		this.setForeground(getBackground());
		this.setResizable(false);
		mov = new Interacoes(this);
		alunos = 5;
		bugs = 5;
		tamanho = 8;
		botoes = new ArrayList<BotaoDoTabuleiro>();
		tabuleiro = criarTabuleiro();
		setLayout(new BorderLayout());
		//tabuleiro = new TelaTabuleiro();
		this.add(tabuleiro,BorderLayout.CENTER);
		
		telaopcoes = new TelaJogabilidade(this);
		JPanel direita = new JPanel();
		direita.setBackground(new Color(158, 77, 36));
		direita.add(telaopcoes,BorderLayout.EAST);
		
		JPanel teste = new JPanel();
		teste.setBackground(new Color(158, 77, 36));
		JPanel relatorio = new TelaBotoes(this);
		teste.add(relatorio);
		this.add(teste,BorderLayout.NORTH);
		this.add(direita,BorderLayout.EAST);
		
		telaopcoes.setVisible(false);
		tabuleiro.setVisible(false);
//		direita.setVisible(false);
		setVisible(true);
	}
	public JPanel criarTabuleiro() {
		JPanel tab = new JPanel();
		tab.setLayout(new GridLayout(tamanho,tamanho,3,3));
		tab.setBorder(new LineBorder(Color.black));
		int tempNum = 0;
		for(int y = 0;y<tamanho;y++) {
			for(int x = 0;x<tamanho;x++) {
			if(y%2==0) {
				if(x%2 == 0) {
				botoes.add(new BotaoDoTabuleiro(x,y,Color.white,this));
					}else {
						botoes.add(new BotaoDoTabuleiro(x,y,Color.black,this)); 
			}
				}else {
					if(x%2 == 0) {
						botoes.add(new BotaoDoTabuleiro(x,y,Color.black,this));
					}else {
						botoes.add(new BotaoDoTabuleiro(x,y,Color.white,this));
				}
			}	
		}
	}
		Random numAleatorio = new Random();
		ArrayList<Integer> listaNumAleatorios = new ArrayList<>();
		int num;
		while(listaNumAleatorios.size()<(alunos+bugs)) {
			do {
				num = numAleatorio.nextInt(tamanho*tamanho);
			} while(listaNumAleatorios.contains(num) || tempNum == num);
			listaNumAleatorios.add(num);
		}
		for (int i = 0;i<listaNumAleatorios.size();i++) {
			if(i<bugs) {
				botoes.get(listaNumAleatorios.get(i)).setTrueTemBug();
			}else
				botoes.get(listaNumAleatorios.get(i)).setTrueTemAluno();
		}
		
//		botoes.get(9).setTrueTemAluno();
//		botoes.get(18).setTrueTemAluno();
//		botoes.get(8).setTrueTemBug();
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
			tab.add(botaoDoTabuleiro);
		}
		return tab;
	}
	public void mudarVisible() {
		tabuleiro.setVisible(true);
		telaopcoes.setVisible(true);
	}
	//tentar passar o robo
	public void mudarCoresAndador(RoboInicial robo) {
		resetarTab();
		int limAndar = robo.getPosY()+robo.getLimMovimento();
		int limVoltar = robo.getPosY()-robo.getLimMovimento();
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
			if(botaoDoTabuleiro.getX() == robo.getPosX() && (limVoltar<=botaoDoTabuleiro.getY() && botaoDoTabuleiro.getY()<=limAndar)
					&& robo.getPosY() != botaoDoTabuleiro.getY()) {
				botaoDoTabuleiro.setBackground(Color.yellow);
				botaoDoTabuleiro.setMovRobo(robo.getId());
			}else
				botaoDoTabuleiro.setEnabled(false);
		}
	}
	public void mudarCoresDiagonal(RoboInicial robo) {
		resetarTab();
//		int limAndarY = robo.getPosY()+robo.getLimMovimento();
//		int limVoltarY = robo.getPosY()-robo.getLimMovimento();
		int limAndarX = robo.getPosX()+robo.getLimMovimento();
		int limVoltarX = robo.getPosX()-robo.getLimMovimento();
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
			if((botaoDoTabuleiro.getX() == botaoDoTabuleiro.getY()) && (botaoDoTabuleiro.getX()<=limAndarX
				&& limVoltarX<=botaoDoTabuleiro.getX())&& (robo.getPosX() != botaoDoTabuleiro.getX() && robo.getPosY() != botaoDoTabuleiro.getY())) {
				botaoDoTabuleiro.setBackground(Color.yellow);
				botaoDoTabuleiro.setMovRobo(robo.getId());
			}else
				botaoDoTabuleiro.setEnabled(false);
		}
		
		
	}		
	public int verificarPontos(int roboX,int roboY) {
		for (BotaoDoTabuleiro botoesDoTabuleiro : botoes) {
				if((botoesDoTabuleiro.getX() == roboX && botoesDoTabuleiro.getY() == roboY)){
					if(botoesDoTabuleiro.comp.isPodePontuar())
					return botoesDoTabuleiro.comp.getPontucao();
					}
		}
		return 0;
	}
	public boolean fimDeJogo() {
		int contAlu = 0;
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
			if(botaoDoTabuleiro.comp.checarComponenteAluno() && !(botaoDoTabuleiro.comp.isPodePontuar())) {
				contAlu++;
			}
		}
		if(contAlu >= this.alunos) {
			return false;
			}
		return true;
	}
	
	protected void visiTelaOpcoes(boolean estado){
		telaopcoes.setVisible(estado);
	}
	protected void visiTabuleiro(boolean estado){
		tabuleiro.setVisible(estado);
	}
	
	public void resetarTab() {
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
		if(botaoDoTabuleiro.isTinhaRobo() && botaoDoTabuleiro.isTemAluno()) {
				botaoDoTabuleiro.setBackground(Color.green);
				}else if(botaoDoTabuleiro.isTinhaRobo() && botaoDoTabuleiro.isTemBug()) {
					botaoDoTabuleiro.setBackground(Color.red);
					}else if(botaoDoTabuleiro.isTinhaRobo()) {
						botaoDoTabuleiro.setBackground(Color.gray);
						}else if(botaoDoTabuleiro.getY()%2 == 0) {
							if(botaoDoTabuleiro.getX()%2 == 0) {
							botaoDoTabuleiro.setBackground(Color.white);
								}else {
									botaoDoTabuleiro.setBackground(Color.black);
				}
					}else {
						if(botaoDoTabuleiro.getX()%2 == 0) {
							botaoDoTabuleiro.setBackground(Color.black);
						}else {
							botaoDoTabuleiro.setBackground(Color.white);
					}
				}
				botaoDoTabuleiro.setEnabled(true);
		}
		visiTabuleiro(true);
	}
	public void digitarNome() {
		    this.nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
		  }
	public int passarCelula() {
		int celulavazia = 0;
		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
			if(!(botaoDoTabuleiro.isTinhaRobo()))
				celulavazia++;
		}
		return celulavazia;
		}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRodadas() {
		return rodadas;
	}
	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}
	}
