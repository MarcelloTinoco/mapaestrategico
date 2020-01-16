package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Graphics2D;

import mapaestrategico.marinha.Ponto;

/**
 * Classe responsavel por desenhar uma seta dentro de um contexto Graphics2D
 * 
 * @author 04266383797
 *
 */
public class Seta extends Geometrico{

	private Ponto coordenadaInicial;
	private int altura;
	private int largura;
	
	public Seta(Ponto coordenadaInicial, int largura, int altura) {
		super();
		this.coordenadaInicial = coordenadaInicial;
		this.altura = altura;
		this.largura = largura;
	}

	/**
	 * Desenhar a parte superior da seta
	 * @param g2d
	 */
	private void desenharTopo(Graphics2D g2d) {
		//Calcular coordenadas
		//3 vertices 
		Ponto v1;
		Ponto v2;
		Ponto v3;
		
		v1 = new Ponto(coordenadaInicial.getX() + new Long(largura/2).intValue(), coordenadaInicial.getY());
		v2 = new Ponto(coordenadaInicial.getX()+largura, coordenadaInicial.getY() + new Long(altura/2).intValue());
		v3 = new Ponto(coordenadaInicial.getX(), coordenadaInicial.getY() + new Long(altura/2).intValue());
		
		int [] vetorX = new int[3];
		int [] vetorY = new int[3];
		
		//definir as coordenadas X no vetorX
		vetorX[0] = v1.getX();
		vetorX[1] = v2.getX();
		vetorX[2] = v3.getX();
		
		//definir as coordenadas Y no vetorY
		vetorY[0] = v1.getY();
		vetorY[1] = v2.getY();
		vetorY[2] = v3.getY();
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillPolygon(vetorX, vetorY, 3);
		
	}
	
	/**
	 * Desenhar a base da seta
	 * @param g2d
	 */
	private void desenharBase(Graphics2D g2d) {
		
		int particaoX = new Long(this.largura/4).intValue();
		
		Ponto v1;
		Ponto v2;
		Ponto v3;
		Ponto v4;
		
		v1 = new Ponto(coordenadaInicial.getX() + particaoX, coordenadaInicial.getY() + new Long(altura/2).intValue());
		v2 = new Ponto(coordenadaInicial.getX() + particaoX + particaoX + particaoX, coordenadaInicial.getY() + new Long(altura/2).intValue() );
		v3 = new Ponto(coordenadaInicial.getX() + particaoX + particaoX + particaoX, coordenadaInicial.getY() + altura);
		v4 = new Ponto(coordenadaInicial.getX() + particaoX, coordenadaInicial.getY() + altura);
		
		int [] vetorX = new int[4];
		int [] vetorY = new int[4];
		
		vetorX[0] = v1.getX();
		vetorX[1] = v2.getX();
		vetorX[2] = v3.getX();
		vetorX[3] = v4.getX();
		
		vetorY[0] = v1.getY();
		vetorY[1] = v2.getY();
		vetorY[2] = v3.getY();
		vetorY[3] = v4.getY();
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillPolygon(vetorX, vetorY, 4);
	}
	
	@Override
	public void desenhar(Graphics2D g2d) {
		desenharTopo(g2d);
		desenharBase(g2d);
	}
	
	
	
}
