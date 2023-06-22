package code;

import java.util.ArrayList;

public abstract class RoboInicial {
	private String nome;
	protected ArrayList<Integer> coordenadaX;
	protected ArrayList<Integer> coordenadaY;
	private int id;
	private int pontuaçao;
	private char icone;
//	protected Tabuleiro tabuleiroRobo;
	protected int posX,posY;
	protected int limMovimento;
	private int aluFind;
	private int bugFind;
	
	public RoboInicial(int id,String nome) {
		this.id = id;
		this.nome = nome;
//		this.tabuleiroRobo = t1;
		posX = 0;
		posY = 0;
		pontuaçao = 0;
//		tabuleiroRobo.adicionarRobo(this);
		coordenadaX = new ArrayList<Integer>();
		coordenadaY = new ArrayList<Integer>();
		aluFind = 0;
		bugFind = 0;
	}
	public abstract RoboInicial andar();
	
	public String getNome() {
		return nome;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPontuaçao() {
		return pontuaçao;
	}
	public int getLimMovimento() {
		return limMovimento;
	}
	public void setLimMovimento(int limMovimento) {
		this.limMovimento = limMovimento;
	}
	public void setPontuaçao(int pontuaçao) {
		this.pontuaçao += pontuaçao;
		if(pontuaçao>0)
			aluFind++;
		else if(pontuaçao<0)
			bugFind++;
			
	}
}
