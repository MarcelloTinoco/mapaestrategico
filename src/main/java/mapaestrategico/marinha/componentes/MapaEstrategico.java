package mapaestrategico.marinha.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.util.List;

import mapaestrategico.marinha.grafico.Seta;

public class MapaEstrategico {

	private static final int LARGURA = 2340;
	private static final int ALTURA = 3300;
	
	private int larguraEmPixels;
	private int alturaEmPixel;
		
	private Missao missao;
	private Visao visao;
	private Seta seta;
	private List<Perspectiva> perspectivas;
	
	public MapaEstrategico() {
	}
	
	public MapaEstrategico(Missao missao, Visao visao, List<Perspectiva> perspectivas) {
		
		if(missao==null) {
			throw new IllegalArgumentException("Missão não pode ser nulla.");
		}
		if(visao==null) {
			throw new IllegalArgumentException("Visão não pode ser nulla.");
		}
		if(perspectivas==null || (perspectivas!=null && perspectivas.isEmpty())) {
			throw new IllegalArgumentException("A lista de perspectivas não pode ser nulla ou vazia.");
		}
		
		this.missao       = missao;
		this.visao        = visao;
		this.perspectivas = perspectivas;
			
	}
	public Missao getMissao() {
		return missao;
	}

	public void setMissao(Missao missao) {
		this.missao = missao;
	}

	public Visao getVisao() {
		return visao;
	}

	public void setVisao(Visao visao) {
		this.visao = visao;
	}

	public Seta getSeta() {
		return seta;
	}

	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	public List<Perspectiva> getPerspectivas() {
		return perspectivas;
	}

	public void setPerspectivas(List<Perspectiva> perspectivas) {
		this.perspectivas = perspectivas;
	}

	public int getLarguraEmPixels() {
		return (larguraEmPixels!=0 ? this.larguraEmPixels : LARGURA);
	}

	public void setLarguraEmPixels(int larguraEmPixels) {
		this.larguraEmPixels = larguraEmPixels;
	}

	public int getAlturaEmPixel() {
		
		return (alturaEmPixel!=0 ? this.alturaEmPixel : ALTURA);
	}

	public void setAlturaEmPixel(int alturaEmPixel) {
		this.alturaEmPixel = alturaEmPixel;
	}

	private void calcularCoordenadas() {
		//Calcular Missao
		
		//Calcular Visao
		
		//Calcular Perspectivas
		
		//Para cada perspectiva, calcular os objetivos
		
		//Calcular as ligacoes
	}
	public void gerarMapa(Graphics2D g2d) {
		
		Color myWhite = new Color(255, 255, 255); // Color white
		Color myWhite2 = Color.decode("#B4EEB4");
		
		g2d.setPaint(myWhite2);
	  	g2d.setBackground(Color.WHITE);
	  	//Desenhar um retangulo branco no fundo da figura
	  	g2d.fillRect(0, 0, this.getLarguraEmPixels() , this.getAlturaEmPixel());
	  	
	  	//Calcular posicoes
		this.missao.getComponente().desenhar(g2d);
		this.visao.getComponente().desenhar(g2d);
		this.seta.desenhar(g2d);
		for(Perspectiva p : this.perspectivas) {
			p.getComponente().desenhar(g2d);
			for(Objetivo o : p.getObjetivos()) {
				o.getComponente().desenhar(g2d);
			}
		}
		
	}
	
}
