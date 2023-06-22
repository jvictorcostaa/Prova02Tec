package code;

import java.util.ArrayList;

public class Movimentaçao {
	public ArrayList<RoboInicial> robos;
	
	public Movimentaçao() {
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
			System.out.println(roboInicial.getPosX()+" "+roboInicial.getPosY()+" pontos:"+roboInicial.getPontuaçao());
		}
	}
	public int pontuacaoRobo(int id) {
		for (RoboInicial roboInicial : robos) {
			if(roboInicial.getId() == id)
				return roboInicial.getPontuaçao();
		}
		return 4;
	}
//	public int movimentarCimaAndador(RoboInicial robo) {
//		
//	}
}
