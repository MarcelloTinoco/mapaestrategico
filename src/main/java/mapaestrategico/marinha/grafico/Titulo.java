package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import mapaestrategico.marinha.Ponto;

/**
 * Classe responsavel por desenhar um titulo dentro de um contexto Graphics2D
 * 
 * @author 04266383797
 *
 */
public class Titulo extends Geometrico{

	private String titulo;
	private Ponto coordenadaInicial;
	private Color cor;
	private int tamanhoFonte;
	
	public Titulo(String titulo, Ponto coordenadaInicial, Color cor, int tamanhoFonte) {
		super();
		this.titulo = titulo;
		this.coordenadaInicial = coordenadaInicial;
		this.cor = cor;
		this.tamanhoFonte = tamanhoFonte;
	}

	@Override
	public void desenhar(Graphics2D g2d) {
		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, this.tamanhoFonte));
		g2d.setColor(this.cor);
		g2d.drawString(this.titulo, this.coordenadaInicial.getX(), this.coordenadaInicial.getY());
		
	}

}
