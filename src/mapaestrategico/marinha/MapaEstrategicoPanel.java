package mapaestrategico.marinha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mapaestrategico.marinha.componentes.MapaEstrategico;
import mapaestrategico.marinha.componentes.Missao;
import mapaestrategico.marinha.componentes.Perspectiva;
import mapaestrategico.marinha.componentes.Visao;
import mapaestrategico.marinha.grafico.CaixaComTexto;
import mapaestrategico.marinha.grafico.CaixaComTitulo;
import mapaestrategico.marinha.grafico.CaixaComTituloETexto;
import mapaestrategico.marinha.grafico.Seta;

public class MapaEstrategicoPanel extends JPanel{

	@Override
	protected void paintComponent(Graphics g){
	  	super.paintComponent(g);
	  	
	  	boolean irParaArquivo = false;
	  	int LARGURA_CAIXA = 2100;
	  	
	  	
	  	
	  	//Cria um BufferedImage do tipo INT_RGB
	  	//BufferedImage bufferedImage = new BufferedImage(1500, 1500, BufferedImage.TYPE_INT_RGB);
 
	  	//400DPI
	  	//BufferedImage bufferedImage = new BufferedImage(3120, 4400, BufferedImage.TYPE_INT_RGB);
	  	
	  	
	  	//300DPI
	  	BufferedImage bufferedImage = new BufferedImage(2340, 3300, BufferedImage.TYPE_INT_RGB);
        // Create a graphics which can be used to draw into the buffered image
        //A linha seguinte é utilizada para gerar a imagen no arquivo       
	  	Graphics2D g2d = bufferedImage.createGraphics(); irParaArquivo = true;
        
	  	//Graphics2D g2d = (Graphics2D) g.create();
	  	g2d.setPaint(Color.WHITE);
	  	g2d.setBackground(Color.WHITE);
	  	  	
	  	
	  	Missao missaoNova = new Missao("Gerenciar a concessão de benefícios de veteranos militares e civis, ex-combatentes, anistiados políticos e seus respectivos pensionistas, a fim de contribuir para a Administração do pessoal da Marinha do Brasil.");
	  	Visao visaoNova = new Visao("Agregar valor aos serviços prestados à família naval, até 2026, por meio da utilização da tecnologia em seus processos internos.");
	  	List<Perspectiva> perspectivas = new ArrayList<Perspectiva>();
	  	
	  	MapaEstrategico me = new MapaEstrategico(missaoNova, visaoNova, perspectivas);
	  	
	  	
	  	
	  	
	  	//pintar o fundo de branco
	  	g2d.fillRect(0, 0, 2340 , 3300);
	  	
	  	//int larguraCaixaPerspectiva = 900;
	    int larguraCaixaPerspectiva = LARGURA_CAIXA;
	  	int meioCaixaPerspectiva = new Long(larguraCaixaPerspectiva / 2).intValue();
	  	int espacoEntreCaixasPerspectiva = 25;
	  	int larguraCaixasMissaoVisao = new Long(larguraCaixaPerspectiva / 2).intValue();
	  	int coordenadaXPerspectiva = 100;
	  	int coordenadaYPerspectiva = 50;
	  	int alturaCaixaMissaoVisao = 150;
	  	
	  	//Desenhar caixa missao
	  	Ponto pCoordenadaInicialMissao = new Ponto(coordenadaXPerspectiva, coordenadaYPerspectiva);
	  	String textoMissao = "Gerenciar a concessão de benefícios de veteranos militares e civis, ex-combatentes, anistiados políticos e seus respectivos pensionistas, a fim de contribuir para a Administração do pessoal da Marinha do Brasil.";
	  	CaixaComTituloETexto missao = new CaixaComTituloETexto(pCoordenadaInicialMissao, larguraCaixasMissaoVisao - espacoEntreCaixasPerspectiva, alturaCaixaMissaoVisao, "Missão", textoMissao, Color.LIGHT_GRAY);
	  	missao.desenhar(g2d);
	  	
	  	//Desenhar caixa visao
	  	Ponto pCoordenadaInicialVisao = new Ponto(coordenadaXPerspectiva + larguraCaixasMissaoVisao + espacoEntreCaixasPerspectiva, coordenadaYPerspectiva);
	  	String textoVisao = "Agregar valor aos serviços prestados à família naval, até 2026, por meio da utilização da tecnologia em seus processos internos.";
	  	CaixaComTituloETexto visao = new CaixaComTituloETexto(pCoordenadaInicialVisao, larguraCaixasMissaoVisao - espacoEntreCaixasPerspectiva, alturaCaixaMissaoVisao, "Visão", textoVisao, Color.BLUE);
	  	visao.desenhar(g2d);
	  		  	
	  	
	  	// Desenhar a seta
	  	
	  	//Define a largura da seta
	  	int larguraSeta = 500;
	  	//Define a altura da seta
	  	int alturaSeta = 90;
	  	//A coordenda Y do vertice da seta é calculado como o ponto Y da caixa missao visao + a altura da caixa missao visao
	  	int coordenadaYVerticeSeta = coordenadaYPerspectiva + alturaCaixaMissaoVisao;
	  	//A coordenada X da seta e calculado como o ponto x da perspectiva + (tamanho da metade da caixa perspectiva - a metade da largura da seta)
	  	int coordenadaXSeta = new Long(coordenadaXPerspectiva + (meioCaixaPerspectiva - (larguraSeta/2))).intValue();
	  	Ponto pCoordenadaInicialSeta = new Ponto(coordenadaXSeta, coordenadaYVerticeSeta);
	  	Seta seta = new Seta(pCoordenadaInicialSeta, larguraSeta, alturaSeta);
	  	seta.desenhar(g2d);
	  	
	  	// Desenhar as caixas
	  	int coordenadaInicialAlturaDaCaixa = coordenadaYVerticeSeta + alturaSeta;
	  	int alturaDaCaixa = 150;
	  	Ponto pCoordenadaInicialCaixa1 = new Ponto(coordenadaXPerspectiva,coordenadaInicialAlturaDaCaixa);
	  	CaixaComTitulo cct1 = new CaixaComTitulo(pCoordenadaInicialCaixa1, larguraCaixaPerspectiva, alturaDaCaixa, "Resultado para Sociedade", Color.LIGHT_GRAY);
	  	cct1.desenhar(g2d);
	  	
	  	Ponto pCoordenadaInicialCaixa2 = new Ponto(coordenadaXPerspectiva,coordenadaInicialAlturaDaCaixa+alturaDaCaixa);
	  	CaixaComTitulo cct2 = new CaixaComTitulo(pCoordenadaInicialCaixa2, larguraCaixaPerspectiva, alturaDaCaixa, "Processos Finalísticos", Color.LIGHT_GRAY);
	  	cct2.desenhar(g2d);
	  	
	  	Ponto pCoordenadaInicialCaixa3 = new Ponto(coordenadaXPerspectiva,coordenadaInicialAlturaDaCaixa + (2 * alturaDaCaixa));
	  	CaixaComTitulo cct3 = new CaixaComTitulo(pCoordenadaInicialCaixa3, larguraCaixaPerspectiva, alturaDaCaixa, "Processos de Apoio", Color.LIGHT_GRAY);
	  	cct3.desenhar(g2d);
	  	
	  	Ponto pCoordenadaInicialCaixa4 = new Ponto(coordenadaXPerspectiva,coordenadaInicialAlturaDaCaixa + (3 * alturaDaCaixa));
	  	CaixaComTitulo cct4 = new CaixaComTitulo(pCoordenadaInicialCaixa4, larguraCaixaPerspectiva, alturaDaCaixa, "Institucional", Color.LIGHT_GRAY);
	  	cct4.desenhar(g2d);
	  		  
	  	//Desenhar as caixas com texto
	  	Ponto pCoordenadaInicialCaixaComTexto1 = new Ponto (pCoordenadaInicialCaixa1.getX()+10, pCoordenadaInicialCaixa1.getY()+25);
	  	CaixaComTexto ccTexto1 = new CaixaComTexto(pCoordenadaInicialCaixaComTexto1, 250, 100 , "Promover a excelência no gerenciamento dos direitos e deveres dos inativos e pensionistas da marinha", Color.BLACK);
	  	ccTexto1.desenhar(g2d);
	
	  	if(irParaArquivo) {
	  		try {
	  			// Save as PNG
	  			File file = new File("c:\\desenvolvimento\\mapaEstrategico.png");
		        ImageIO.write(bufferedImage, "png", file);
		        
				// Save as JPEG
			    file = new File("c:\\desenvolvimento\\mapaEstrategico.jpg");
			    ImageIO.write(bufferedImage, "jpg", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	  	}
	  	
	  	g2d.dispose();
	  	
	  	
	  	
	}
}
