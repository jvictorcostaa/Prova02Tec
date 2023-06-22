package code;

public class Andador extends RoboInicial{
	public Andador(int id, String nome) {
		super(id, nome);
		this.limMovimento = 2;
	}
	public RoboInicial andar() {
		return this;
	}
}