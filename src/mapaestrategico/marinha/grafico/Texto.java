package mapaestrategico.marinha.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import mapaestrategico.marinha.Ponto;

/**
 * Classe responsavel por desenhar um texto dentro de um contexto Graphics2D
 * 
 * @author 04266383797
 *
 */
public class Texto extends Geometrico{

	public static final String TABULACAO = "\t";
	public static final String QUEBRA_LINHA = "\n";
	
	private String texto;
	private Ponto coordenadaInicial;
	private Color cor;
	private int tamanhoFonte;
	private int tamanhoMaximoConteiner;
	
		
	public Texto(String texto, Ponto coordenadaInicial, Color cor, int tamanhoFonte,int tamanhoMaximoConteiner) {
		super();
		this.texto = texto;
		this.coordenadaInicial = coordenadaInicial;
		this.cor = cor;
		this.tamanhoFonte = tamanhoFonte;
		this.tamanhoMaximoConteiner = tamanhoMaximoConteiner;
	}


	private String criarSeparacaoString(Graphics2D g2d, String texto) {
		String strComSplit = "";
		
		FontMetrics fontMetrics = g2d.getFontMetrics();
		
		//Define o tamanho maximo disponível por linha para o texto no conteiner
		int tamanhoDisponivelTexto = this.tamanhoMaximoConteiner - 60;
		
		if(fontMetrics.stringWidth(texto) <= tamanhoDisponivelTexto){
			strComSplit = texto;
		}
		else {
			//Efetuar um split no texto pelo espaço;
			//Criar linhas onde o tamanho das palavras concatenadas seja menor que o tamanho maximo disponivel para o texto no conteiner
			String[] palavras = texto.split(" ");
			int numeroPalavrasUtilizadas = 0;
			String strTemp = "";
			List<String> linhas = new ArrayList<>();
			
			while(numeroPalavrasUtilizadas < palavras.length) {
				if(fontMetrics.stringWidth(strTemp + palavras[numeroPalavrasUtilizadas] + " ") < tamanhoDisponivelTexto) {
					strTemp += palavras[numeroPalavrasUtilizadas] + " ";
					numeroPalavrasUtilizadas +=1;
				}
				else {
					linhas.add(strTemp);
					strTemp = "";
				}
			}
			if(strTemp!=null && !strTemp.isEmpty()) {
				linhas.add(strTemp);
			}
			if(!linhas.isEmpty()) {
				for(String linha : linhas) {
					strComSplit += linha + Texto.QUEBRA_LINHA;
				}
				strComSplit = strComSplit.substring(0, strComSplit.length()-2);
			}
		}
		return strComSplit;
	}

	@Override
	public void desenhar(Graphics2D g2d) {
		
		g2d.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, this.tamanhoFonte));
		g2d.setColor(this.cor);
				
		int x = coordenadaInicial.getX();
        int y = coordenadaInicial.getY();
        FontMetrics fontMetrics = g2d.getFontMetrics();
        
        String textoComQuebra = criarSeparacaoString(g2d, texto);
        Rectangle2D tabBounds = fontMetrics.getStringBounds("xxxxxxxx",g2d);
        int tabWidth = (int)tabBounds.getWidth();
        String[] lines = textoComQuebra.split("\n");
        for (String line : lines) {
            int xColumn = x;
            String[] columns = line.split("\t");
            for (String column : columns) {
                if (xColumn != x) {
                    // Align to tab stop.
                    xColumn += tabWidth - (xColumn-x) % tabWidth;
                }
                Rectangle2D columnBounds = fontMetrics.getStringBounds(column,g2d);
                g2d.drawString(column,xColumn,y + fontMetrics.getAscent());
                xColumn += columnBounds.getWidth();
            }
            y += fontMetrics.getHeight();
        }
	}

}
