package view;

public class ComponenteBotao {
	private String tipo;
	private int pontos;
	private boolean podePontuar;
	
	public ComponenteBotao() {
		this.pontos = 0;
		this.podePontuar = true;
	}
	
	public ComponenteBotao(String tipo, int pontos) {
		this.pontos=pontos;
		podePontuar = true;
	}
	
	public boolean isPodePontuar() {
		return podePontuar;
	}

	public void setPodePontuar(boolean podePontuar) {
		this.podePontuar = podePontuar;
	}

	public boolean checarComponenteBug() {
		return (this.tipo == "b");
	}
	
	public boolean componenteVazia() {
		return tipo == null;
	}
	
	public boolean checarComponenteAluno() {
		return (this.tipo == "a");		
	}
	
	public void adicionarAluno() {
		this.tipo="a";
		this.pontos = 10;
	}
	
	public void adicionarBug() {
		this.tipo="b";
		this.pontos = -15;
	}
	
	public int getPontucao() {
		this.podePontuar = false;
		return this.pontos;
	}
}
