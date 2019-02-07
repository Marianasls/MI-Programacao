/** *****************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima> e <Nadime Centeno>
 * Data:  <08/02/2019>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
 * ****************************************************************************
 */
package util;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

/*
 * Classe que desenha a seta na aresta.
 * @author Mariana Lima
 * @author Nadime
 */
public class Seta implements Serializable {
	
	/*
	 * Constantes usadas para calcular a seta.
	 */
	public static double ANGULO_SETA = Math.PI / 15d;
	public static double COMPRIMENTO_SETA = 10d;

	private Line2D _linha1;
	private Line2D _linha2;

	public Seta(){
		_linha1 = new Line2D.Float();
		_linha2 = new Line2D.Float();
	}

	public void desenhar(Graphics2D graphics2D, boolean isMesmoVertice){
		if (isMesmoVertice) { return; }

		/*
		 * Desenha a seta na tela.
		 */
		graphics2D.draw(_linha1);
		graphics2D.draw(_linha2);
	}

	/*
	 * Calcula o formato e a posição da Seta
	 */
	public void calcular(Point2D controleDeCurva, Point2D pontoFinal, boolean isMesmoVertice) {
		if (isMesmoVertice) { return; }
		
		/*
		 * Pega o angulo que a seta irá se posicionar.
		 */
		double angulo = Math.atan2((controleDeCurva.getX() - pontoFinal.getX()), (controleDeCurva.getY() - pontoFinal.getY()));
		angulo += ANGULO_SETA;
		
		/*
		 * Pega as coordenadas X e Y, com base no angulo e nas coordenadas do vertice final.
		 */
		double coordenadaX = Math.sin(angulo) * COMPRIMENTO_SETA + pontoFinal.getX();
		double coordenadaY = Math.cos(angulo) * COMPRIMENTO_SETA + pontoFinal.getY();

		/*
		 * Cria a primeira linha da seta.
		 */
		_linha1.setLine(pontoFinal.getX(), pontoFinal.getY(), coordenadaX, coordenadaY);

		/*
		 * Pega o novo angulo e as novas coordenadas X e Y da linha.
		 */
		angulo -= 2 * ANGULO_SETA;
		coordenadaX = Math.sin(angulo) * COMPRIMENTO_SETA + pontoFinal.getX();
		coordenadaY = Math.cos(angulo) * COMPRIMENTO_SETA + pontoFinal.getY();

		/*
		 * Cria a segunda linha da seta.
		 */
		_linha2.setLine(pontoFinal.getX(), pontoFinal.getY(), coordenadaX, coordenadaY);
	}


}