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
	private JButton andadorBOT;
	private JButton cavaloBOT;
	private JButton reiBOT;
	
	public TelaJogabilidade(TelaPrincipal inicial){
		this.inicial = inicial;
		fazerTelaJogabilidade();
	}
	public void fazerTelaJogabilidade(){
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(158, 77, 36));
		JPanel icons = new JPanel();
		icons.setBackground(new Color(191, 101, 55));
		icons.setLayout(new GridLayout(6,1));
		JPanel jogabilidade = new JPanel();
		jogabilidade.setBackground(new Color(191, 101, 55));
		jogabilidade.setLayout(new GridLayout(3,1,30,30));
		andadorBOT = new Botao("Andador",Color.white);
		pontAndador = new JLabel("Pontos : 0");
		andadorBOT.addActionListener(new acaoAndador(0));
		cavaloBOT = new Botao("Cavalo",Color.white);
		pontCavalo = new JLabel("Pontos : 0");
		cavaloBOT.addActionListener(new acaoCavalo(1));
		reiBOT = new Botao("Rei",Color.white);
		pontRei = new JLabel("Pontos : 0");
		reiBOT.addActionListener(new acaoRei(2));
		
		
		Botao nextplay = new Botao("Proxima Jogada",Color.green);
		nextplay.addActionListener(new proximaJogada());
		
		Botao sair = new Botao("Sair do Jogo",Color.green);
		sair.addActionListener(new acaosair());
		
		icons.add(andadorBOT);
		icons.add(pontAndador);
		icons.add(cavaloBOT);
		icons.add(pontCavalo);
		icons.add(reiBOT);
		icons.add(pontRei);
		this.add(icons,BorderLayout.NORTH);
		jogabilidade.add(nextplay);
		jogabilidade.add(sair);
		this.add(jogabilidade);
	}
	public void attPontos() {
		pontAndador.setText("Pontos :"+" "+(inicial.mov.pontuacaoRobo(0)));
		pontCavalo.setText("Pontos :"+" "+(inicial.mov.pontuacaoRobo(1)));
		pontRei.setText("Pontos :"+" "+(inicial.mov.pontuacaoRobo(2)));
	}
//	public void visiBotoes(boolean estado) {
//		andadorBOT.setEnabled(estado);
//		cavaloBOT.setEnabled(estado);
//		reiBOT.setEnabled(estado);
//	}
private class acaoAndador implements ActionListener {
	private int selecionarRobo;
	public acaoAndador(int numRobo) {
		selecionarRobo = numRobo; 
	}
		public void actionPerformed(ActionEvent e) {
			inicial.visiTabuleiro(true);
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
			inicial.visiTabuleiro(true);
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
			inicial.visiTabuleiro(true);
			RoboInicial robo = inicial.mov.robos.get(selecionarRobo);
			inicial.mudarCoresDiagonal(robo);
		}
	}
private class proximaJogada implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(inicial.fimDeJogo()) {
			inicial.resetarTab();
			attPontos();
			inicial.rodadas++;
		}else{
			attPontos();
			JOptionPane optionPane = new JOptionPane();
		    optionPane.setMessage("Parabéns,todos os alunos foram resgatados!!!");
		    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		    JDialog dialog = optionPane.createDialog(null, "FIM DE JOGO");
	        dialog.setVisible(true);
			inicial.mov.escreverArquivo();
			inicial.mov.instanciarRelatorio();
			inicial.dispose();
		}

		}
		
	}
private class acaosair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inicial.mov.escreverArquivo();
			inicial.mov.instanciarRelatorio();
			inicial.dispose();
		}
	}
}
