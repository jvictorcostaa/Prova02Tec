package code;

import java.util.ArrayList;

import persistencia.Gravacao;
import persistencia.Leitura;
import view.JFrameRelatorio;
import view.TelaPrincipal;

public class Interacoes {
	public ArrayList<RoboInicial> robos;
	private TelaPrincipal tp;
	private Gravacao gv;
	private Leitura lt;
	
	public Interacoes(TelaPrincipal tp) {
		this.tp = tp;
		gv = new Gravacao();
		lt = new Leitura();
		robos = new ArrayList<RoboInicial>();
		Andador a1 = new Andador(0,"andador");
		robos.add(a1);
		Cavalo c1 = new Cavalo(1,"cavalo");
		robos.add(c1);
		Rei r1 = new Rei(2,"rei");
		robos.add(r1);
	}
	public void attPosicaoRobo(int x,int y,int id, int pontos) {
		for (RoboInicial roboInicial : robos) {
			if(roboInicial.getId() == id) {
				roboInicial.setPosX(x);
				roboInicial.setPosY(y);
				roboInicial.setPontuaçao(pontos);
			}
//			System.out.println(roboInicial.getPosX()+" "+roboInicial.getPosY()+" pontos:"+roboInicial.getPontuaçao());
		}
	}
	public int pontuacaoRobo(int id) {
		for (RoboInicial roboInicial : robos) {
			if(roboInicial.getId() == id)
				return roboInicial.getPontuaçao();
		}
		return 4;
	}
	private int somaPontuar() {
		int somaPontuacao = 0;
		for (RoboInicial roboInicial : robos) {
			somaPontuacao += roboInicial.getPontuaçao();
		}
		return somaPontuacao;
	}
	private int somaAlunos() {
		int somaAl = 0;
		for (RoboInicial roboInicial : robos) {
			somaAl += roboInicial.getAluFind();
		}
		return somaAl;
	}
	private int somaBug() {
		int somaBug = 0;
		for (RoboInicial roboInicial : robos) {
			somaBug += roboInicial.getBugFind();
		}
		return somaBug;
	}
	public void escreverArquivo() {
		String dados = tp.getNome()+";"+tp.passarCelula()+";"+somaPontuar()+";"+somaAlunos()+";"+somaBug()+";"+tp.getRodadas()+";"
						+robos.get(0).getPontuaçao()+";"+robos.get(1).getPontuaçao()+";"+robos.get(2).getPontuaçao();
		
		gv.gravarConcatString(dados);
		
	}
	public void instanciarRelatorio() {
		new JFrameRelatorio(lt.lerLinhas(), tp);
		
	}
}
