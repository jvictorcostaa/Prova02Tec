package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import code.*;

public class TelaJogabilidade extends JPanel{
	private TelaPrincipal inicial;
	private JLabel pontAndador;
	private JLabel pontCavalo;
	private JLabel pontRei;
	
	public TelaJogabilidade(TelaPrincipal inicial){
		this.inicial = inicial;
		fazerTelaJogabilidade();
	}
	public void fazerTelaJogabilidade(){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.YELLOW);
		JPanel icons = new JPanel();
		icons.setLayout(new GridLayout(6,1));
		JPanel jogabilidade = new JPanel();
		jogabilidade.setLayout(new GridLayout(3,1,30,30));
		Botao andadorBOT = new Botao("Andador",Color.lightGray);
		pontAndador = new JLabel("Pontos : 0");
		andadorBOT.addActionListener(new acaoAndador(0));
		Botao cavaloBOT = new Botao("Cavalo",Color.lightGray);
		pontCavalo= new JLabel("Pontos : 0");
		cavaloBOT.addActionListener(new acaoCavalo(1));
		Botao reiBOT = new Botao("Rei",Color.lightGray);
		pontRei= new JLabel("Pontos : 0");
		reiBOT.addActionListener(new acaoRei(2));
		
		
		Botao verificar = new Botao("Verificar",Color.green);
		Botao nextplay = new Botao("Proxima Jogada",Color.green);
		nextplay.addActionListener(new proximaJogada());
		
		Botao sair = new Botao("Sair do Jogo",Color.green);
		
		icons.add(andadorBOT);
		icons.add(pontAndador);
		icons.add(cavaloBOT);
		icons.add(pontCavalo);
		icons.add(reiBOT);
		icons.add(pontRei);
		this.add(icons,BorderLayout.NORTH);
		jogabilidade.add(verificar);
		jogabilidade.add(nextplay);
		jogabilidade.add(sair);
		this.add(jogabilidade);
	}
	public void attPontos() {
		pontAndador.setText("Pontos :"+" "+String.valueOf(inicial.mov.pontuacaoRobo(0)));
		pontCavalo.setText("Pontos :"+" "+String.valueOf(inicial.mov.pontuacaoRobo(1)));
		pontRei.setText("Pontos :"+" "+String.valueOf(inicial.mov.pontuacaoRobo(2)));
	}
private class acaoAndador implements ActionListener {
	private int selecionarRobo;
	public acaoAndador(int numRobo) {
		selecionarRobo = numRobo; 
	}
		public void actionPerformed(ActionEvent e) {
			RoboInicial robo = inicial.mov.robos.get(selecionarRobo);
			inicial.mudarCoresAndador(robo);
		}
		
	}
private class acaoCavalo implements ActionListener {
	private int selecionarRobo;
	public acaoCavalo(int numRobo) {
		selecionarRobo = numRobo; 
	}
		public void actionPerformed(ActionEvent e) {
			RoboInicial robo = inicial.mov.robos.get(selecionarRobo);
			inicial.mudarCoresDiagonal(robo);
		}
		
	}
private class acaoRei implements ActionListener {
	private int selecionarRobo;
	public acaoRei(int numRobo) {
		selecionarRobo = numRobo; 
	}
		public void actionPerformed(ActionEvent e) {
			RoboInicial robo = inicial.mov.robos.get(selecionarRobo);
			inicial.mudarCoresDiagonal(robo);
		}
		
	}
private class proximaJogada implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(inicial.fimDeJogo()) {
			inicial.resetarTab();
			attPontos();
			System.out.println("resetou");
		}else 
			inicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("cabou o jogo");
		}
		
	}
}
