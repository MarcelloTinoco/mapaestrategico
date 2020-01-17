package mapaestrategico.marinha;

public class Retangulo {

	private Ponto vertice1;
	private Ponto vertice2;
	private Ponto vertice3;
	private Ponto vertice4;
	
	public Ponto getVertice1() {
		return vertice1;
	}

	public Ponto getVertice2() {
		return vertice2;
	}

	public Ponto getVertice3() {
		return vertice3;
	}

	public Ponto getVertice4() {
		return vertice4;
	}

	public Retangulo(Ponto vertice1, Ponto vertice2, Ponto vertice3, Ponto vertice4) {
		super();
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.vertice3 = vertice3;
		this.vertice4 = vertice4;
	}
	
	
}
