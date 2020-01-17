package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Graphics2D;

import mapaestrategico.marinha.Ponto;

public class CaixaComTituloETexto extends Geometrico{

	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	private String titulo;
	private String texto;
	private Color cor;
	
	private int tamanhoFonteTitulo;
	private int tamanhoFonteTexto;
		
	
	public CaixaComTituloETexto(Ponto coordenadaInicial, int largura, int altura, String titulo, String texto, Color cor) {
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
		this.texto = texto;
		this.cor = cor;
		
		this.tamanhoFonteTitulo = 17;
		
		this.tamanhoFonteTexto = 15;
	}

	private void desenharCaixa(Graphics2D g2d) {
		
		g2d.setColor(cor);
		g2d.fillRoundRect(coordenadaInicial.getX(), coordenadaInicial.getY(), largura, altura, 25, 25);
		
	}
	
	private void desenharTitulo(Graphics2D g2d) {
			
		Ponto coordenadaInicial = new Ponto(this.coordenadaInicial.getX() + 20, this.coordenadaInicial.getY() + 20);
		Titulo titulo = new Titulo(this.titulo, coordenadaInicial, Color.WHITE, this.tamanhoFonteTitulo);
		titulo.desenhar(g2d);
		
	}
	
	private void desenharTexto(Graphics2D g2d) {
		
		Ponto coordenadaInicial = new Ponto(this.coordenadaInicial.getX() + 20, this.coordenadaInicial.getY() + 40);
		Texto texto = new Texto(this.texto, coordenadaInicial, Color.WHITE, this.tamanhoFonteTexto, this.largura);
		texto.desenhar(g2d);
		
	}
	
	@Override
	public void desenhar(Graphics2D g2d) {
		this.desenharCaixa(g2d);
		this.desenharTitulo(g2d);
		this.desenharTexto(g2d);
		
		
	}

}
