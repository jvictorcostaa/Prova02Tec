package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TelaBotoes extends JPanel {
	private TelaPrincipal telainicial;
	
	public TelaBotoes(TelaPrincipal inicial) {
		telainicial = inicial;
		criarTelaBotoes();
	}
	public void criarTelaBotoes() {
		this.setBackground(new Color(158, 77, 36));
		Botao jogar = new Botao("Jogar",Color.cyan);
		jogar.addActionListener(new acaojogar());
		Botao relatorio = new Botao("Relatorio do Jogo",Color.cyan);
		relatorio.addActionListener(new acaorelatorio());
		this.add(jogar);
		this.add(relatorio);
	}
	private class acaojogar implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			telainicial.visiTelaOpcoes(true);
		}
		
	}
	private class acaorelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telainicial.mov.instanciarRelatorio();
			
		}
		
	}
}

