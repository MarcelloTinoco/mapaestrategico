package mapaestrategico.marinha.componentes;

import java.awt.Color;

import mapaestrategico.marinha.Ponto;
import mapaestrategico.marinha.grafico.CaixaComTexto;

/**
 * Classe que representa um Objetivo no plano estrategico
 * 
 * @author 04266383797
 *
 */
public class Objetivo {

	/**
	 * Um inteiro que identifica unicamente o objetivo
	 */
	private int id;
	/**
	 * Um inteiro que identifica com qual objetivo o objetivo corrente contribui;
	 */
	private int contribuiPara;
	
	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	
	private String sigla;
	private String titulo;
	
	private String texto;
	private Color cor;
	
	private CaixaComTexto componente;
	
	/**
	 * Identifica os pontos de conexao nas caixas
	 * 0 - topo;
	 * 1 - direita;
	 * 2 - abaixo;
	 * 3 - esquerda;
	 */
	private Ponto[]  pontosConexao =  new Ponto[4];
	
	/*
	 * Metodo responsavel por calcular os pontos de conexao
	 */
	private void calcularPontosConexao() {
		
		int x = coordenadaInicial.getX() + (largura / 2) ;
		int y = coordenadaInicial.getY();
		Ponto p0 = new Ponto(x, y);
		
		x = coordenadaInicial.getX() + largura;
		y = coordenadaInicial.getY() + (altura / 2);
		Ponto p1 = new Ponto(x,y);
		
		x = coordenadaInicial.getX() + (largura / 2);
		y = coordenadaInicial.getY() + altura;
		Ponto p2 = new Ponto(x,y);
		
		x = coordenadaInicial.getX();
		y = coordenadaInicial.getY() + (altura);
		Ponto p3 = new Ponto(x,y);
		
		pontosConexao[0] = p0;
		pontosConexao[1] = p1;
		pontosConexao[2] = p2;
		pontosConexao[3] = p3;
		
		System.out.println("p0 -> " + pontosConexao[0]);
		System.out.println("p1 -> " +pontosConexao[1]);
		System.out.println("p2 -> " +pontosConexao[2]);
		System.out.println("p3 -> " +pontosConexao[3]);
		
		
	}
	
	public Objetivo() {
	}

	public Objetivo( int id, int contribuiPara, String codigo, String titulo) {
		
	}
	public Objetivo(Ponto coordenadaInicial, int largura, int altura, int id, int contribuiPara, String sigla, String titulo, String texto, Color cor) {
		super();
		
		this.coordenadaInicial = coordenadaInicial;
		this.largura = largura;
		this.altura = altura;
		this.cor = cor;
		
		this.id = id;
		this.contribuiPara = id;
		this.sigla = sigla;
		this.titulo = titulo;
		
		this.componente = new CaixaComTexto(coordenadaInicial, largura, altura, texto, cor);
		this.calcularPontosConexao();
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

	public CaixaComTexto getComponente() {
		return componente;
	}

	public void setComponente(CaixaComTexto componente) {
		this.componente = componente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContribuiPara() {
		return contribuiPara;
	}

	public void setContribuiPara(int contribuiPara) {
		this.contribuiPara = contribuiPara;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	
}
