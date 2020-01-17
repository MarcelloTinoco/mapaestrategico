package mapaestrategico.marinha.componentes;

import java.awt.Color;
import java.util.List;

import mapaestrategico.marinha.Ponto;
import mapaestrategico.marinha.grafico.CaixaComTitulo;

public class Perspectiva {

	
	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	private String titulo;
	private Color cor;
	
	private CaixaComTitulo componente;
	
	private List<Objetivo> objetivos;
	
	public Perspectiva() {
	}

	public Perspectiva(String titulo) {
		this.titulo = titulo;
	}
	
	public Perspectiva(Ponto coordenadaInicial, int largura, int altura, String titulo, Color cor) {
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
		this.cor = cor;
		
		this.componente = new CaixaComTitulo(coordenadaInicial, largura, altura, titulo, cor);
		
	}

	public Ponto getCoordenadaInicial() {
		return coordenadaInicial;
	}

	public void setCoordenadaInicial(Ponto coordenadaInicial) {
		this.coordenadaInicial = coordenadaInicial;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public CaixaComTitulo getComponente() {
		return componente;
	}

	public void setComponente(CaixaComTitulo componente) {
		this.componente = componente;
	}

	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}
	
}
