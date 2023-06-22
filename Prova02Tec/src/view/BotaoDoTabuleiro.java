package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Movimentaçao;

public class BotaoDoTabuleiro extends JButton {
	private TelaPrincipal inicio;
	private int x;
	private int y;
	private boolean tinhaRobo;
	private int movRobo;
	protected ComponenteBotao comp;
	
		public BotaoDoTabuleiro(int x,int y, Color cor,TelaPrincipal inicio) {
			this.x = x;
			this.y = y;
			this.inicio = inicio;
			tinhaRobo = false;
			this.setBackground(cor);
			this.setEnabled(true);
			comp = new ComponenteBotao();
		}

		public boolean isTinhaRobo() {
			return tinhaRobo;
		}

		public void setTinhaRobo(boolean tinhaRobo) {
			this.tinhaRobo = tinhaRobo;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	public int getMovRobo() {
			return movRobo;
		}

		public void setMovRobo(int movRobo) {
			this.movRobo = movRobo;
			this.addActionListener(new getcord(x,y,getMovRobo()));
		}
		public boolean isTemAluno() {
			return comp.checarComponenteAluno();
		}

		public void setTrueTemAluno() {
			comp.adicionarAluno();
		}

		public boolean isTemBug() {
			return comp.checarComponenteBug();
		}

		public void setTrueTemBug() {
			comp.adicionarBug();
		}
	private class getcord implements ActionListener {
		private int x,y,id;
		
		public getcord(int x,int y,int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}

		public void actionPerformed(ActionEvent e) {
			inicio.mov.attPosicaoRobo(x, y, id,inicio.verificarPontos(x, y));
			inicio.confirmarJogada();
			setTinhaRobo(true);
		}
			
				
	}
}
