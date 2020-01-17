package mapaestrategico.marinha;

public class Linha {

	private Ponto origem;
	private Ponto destino;
	
	public Linha(Ponto origem, Ponto destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public Ponto getOrigem() {
		return origem;
	}

	public Ponto getDestino() {
		return destino;
	}
	
	
}
