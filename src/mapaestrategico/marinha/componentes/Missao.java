package mapaestrategico.marinha.componentes;

import java.awt.Color;

import mapaestrategico.marinha.Ponto;
import mapaestrategico.marinha.grafico.CaixaComTituloETexto;

public class Missao {
	
	public static final String MISSAO = "Missão";
	
	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	private String titulo;
	private String texto;
	private Color cor;
	
	private int tamanhoFonteTitulo;
	private int tamanhoFonteTexto;
	
	private CaixaComTituloETexto componente;
	
	
	public Missao() {
	}
	
	public Missao(String texto) {
		this.titulo = Missao.MISSAO;
		this.texto = texto;
	}

	public Missao(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public Missao(Ponto coordenadaInicial, int largura, int altura, String titulo, String texto, Color cor,
			int tamanhoFonteTitulo, int tamanhoFonteTexto) {
		
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
		this.texto = texto;
		this.cor = cor;
		this.tamanhoFonteTitulo = tamanhoFonteTitulo;
		this.tamanhoFonteTexto = tamanhoFonteTexto;
		
		this.componente = new CaixaComTituloETexto(coordenadaInicial, largura, altura, titulo, texto, cor);
		
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public int getTamanhoFonteTitulo() {
		return tamanhoFonteTitulo;
	}

	public void setTamanhoFonteTitulo(int tamanhoFonteTitulo) {
		this.tamanhoFonteTitulo = tamanhoFonteTitulo;
	}

	public int getTamanhoFonteTexto() {
		return tamanhoFonteTexto;
	}

	public void setTamanhoFonteTexto(int tamanhoFonteTexto) {
		this.tamanhoFonteTexto = tamanhoFonteTexto;
	}

	public CaixaComTituloETexto getComponente() {
		return componente;
	}

	public void setComponente(CaixaComTituloETexto componente) {
		this.componente = componente;
	}
	
}
