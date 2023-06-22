package view;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//public class TelaTabuleiro extends JPanel{
//	private int tamanho;
//	public ArrayList<BotaoDoTabuleiro> botoes;
//	
//	public TelaTabuleiro() {
//	tamanho = 8;
//	botoes = new ArrayList<BotaoDoTabuleiro>();
//	criarTabuleiro();
//}
//	
//	public void criarTabuleiro() {
//		this.setLayout(new GridLayout(tamanho,tamanho,3,3));
//		for(int y = 0;y<tamanho;y++) {
//			for(int x = 0;x<tamanho;x++) {
//			if(y%2==0) {
//				if(x%2 == 0) {
//				botoes.add(new BotaoDoTabuleiro(x,y,Color.white));
//					}else {
//						botoes.add(new BotaoDoTabuleiro(x,y,Color.black)); 
//			}
//				}else {
//					if(x%2 == 0) {
//						botoes.add(new BotaoDoTabuleiro(x,y,Color.black));
//					}else {
//						botoes.add(new BotaoDoTabuleiro(x,y,Color.white));
//				}
//			}
//		}
//	}
//		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
//			this.add(botaoDoTabuleiro);
//		}
//	}
//	public void mudarCores(int x,int y) {
//		int conty = 0;
//		for (BotaoDoTabuleiro botaoDoTabuleiro : botoes) {
//			while(botaoDoTabuleiro.getX() == x && botaoDoTabuleiro.getY()<5) {
//				botaoDoTabuleiro.setBackground(Color.yellow);
//			}
//		}
//	}
//}
