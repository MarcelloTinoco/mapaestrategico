package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import mapaestrategico.marinha.Ponto;

/**
 * Classe responsavel por desenhar uma caixa com titulo dentro de um contexto Graphics2D
 * 
 * @author 04266383797
 *
 */
public class CaixaComTitulo extends Geometrico{

	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	private String titulo;
	private Color cor;
	
	
	public CaixaComTitulo(Ponto coordenadaInicial, int largura, int altura, String titulo, Color cor) {
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.altura = altura;
		this.largura = largura;
		this.titulo = titulo;
		this.cor = cor;
	}

	public void desenharCaixa(Graphics2D g2d) {
		
		//CoordenadaInicial - X
		//CoordenadaInicial - Y
		//Largura
		//Altura
		//curvaturaX
		//curvaturaY
		g2d.setColor(cor);
		g2d.drawRoundRect(coordenadaInicial.getX(), coordenadaInicial.getY(), largura, altura, 25, 25);
		
	}
	
	public void desenharTitulo(Graphics2D g2d) {
		
		Ponto coordenadaInicial = new Ponto(this.coordenadaInicial.getX() + 20, this.coordenadaInicial.getY() + 20);
		Titulo titulo = new Titulo(this.titulo, coordenadaInicial, cor, 17);
		titulo.desenhar(g2d);
				
	}

	@Override
	public void desenhar(Graphics2D g2d) {
		desenharCaixa(g2d);
		desenharTitulo(g2d);
	}
}
