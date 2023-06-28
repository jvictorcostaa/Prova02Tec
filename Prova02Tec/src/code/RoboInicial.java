package code;

import java.util.ArrayList;

public abstract class RoboInicial {
	private String nome;
	private int id;
	private int pontuaçao;
	protected int posX,posY;
	protected int limMovimento;
	private int aluFind;
	private int bugFind;
	
	public RoboInicial(int id,String nome) {
		this.id = id;
		this.nome = nome;
		posX = 0;
		posY = 0;
		pontuaçao = 0;
		aluFind = 0;
		bugFind = 0;
	}
	
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
	public int getAluFind() {
		return aluFind;
	}
	public void setAluFind(int aluFind) {
		this.aluFind = aluFind;
	}
	public int getBugFind() {
		return bugFind;
	}
	public void setBugFind(int bugFind) {
		this.bugFind = bugFind;
	}
	
}
