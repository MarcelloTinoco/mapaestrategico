package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import mapaestrategico.marinha.Ponto;

/**
 * Classe responsavel por desenhar uma caixa com texto dentro de um contexto Graphics2D
 * 
 * @author 04266383797
 *
 */
public class CaixaComTexto extends Geometrico{

	private Ponto coordenadaInicial;
	private int largura;
	private int altura;
	private String texto;
	private Color cor;
	
	
	
	public CaixaComTexto(Ponto coordenadaInicial, int largura, int altura, String texto, Color cor) {
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.largura = largura;
		this.altura = altura;
		this.texto = texto;
		this.cor = cor;
	}


	private void desenharCaixa(Graphics2D g2d) {
		
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRoundRect(coordenadaInicial.getX(), coordenadaInicial.getY(), largura, altura, 25, 25);
		
	}
	
	private void desenharTexto(Graphics2D g2d) {
		
		Ponto coordenadaInicial = new Ponto(this.coordenadaInicial.getX() + 20, this.coordenadaInicial.getY() + 10);
		Texto texto = new Texto(this.texto, coordenadaInicial, Color.WHITE, 15, this.largura);
		texto.desenhar(g2d);
		
	}

	@Override
	public void desenhar(Graphics2D g2d) {
		desenharCaixa(g2d);
		desenharTexto(g2d);
		
	}

}
