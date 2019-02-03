/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Seta;
import util.Utils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;


/*
 * Classe Aresta
 * Controla as informações sobre cada aresta
 * e a desenha na tela.
 */
public class Aresta implements Comparable<Aresta>, Serializable {

    private Vertice _inicio;
    private Vertice _fim;
    private Double _peso;
    private Seta _seta;

    private int _curvatura = 0;
    private Rectangle2D _areaDoTexto;
    private Point2D.Double _controleDeCurva;
    private Point2D.Double _posicaoFinal;

    private QuadCurve2D.Double _conexaoEmCurva;
    private Ellipse2D.Double _conexaoEmAutoLaco;
    private Line2D.Double _conexaoEmLinha;

    private double _larguraVerticeDeInicial = Vertice.LARGURA;
    private Point2D _centroVerticeInicial;
    private Point2D _centroVerticeFinal;
    private Shape _conexaoEntreOsVertices;

    /*
     * Constante com um angulo padrão de cada vertice
     */
    public static final double ANGULO = Math.PI / 25d;

    /*
     * Construtor da classe.
     */
    public Aresta(Vertice inicio, Vertice fim, Double peso) {
        this._inicio = inicio;
        this._fim = fim;
        this._peso = peso;
        this._areaDoTexto = new Rectangle2D.Double();
        this._seta = new Seta();

        this._conexaoEmCurva = new QuadCurve2D.Double();
        this._conexaoEmAutoLaco = new Ellipse2D.Double();
        this._conexaoEmLinha = new Line2D.Double();

        this._controleDeCurva = new Point2D.Double();
        this._posicaoFinal = new Point2D.Double();

        this._centroVerticeInicial = this._inicio.getCentroVertice();
        this._centroVerticeFinal = this._fim.getCentroVertice();
    }

    /*
     * Metodo que desenha a aresta na tela.
     */
    public void desenharAresta(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke());
        graphics2D.setPaint(Color.BLACK);
        /*
    	 * Desenha a aresta na tela.
         */
        graphics2D.draw(_conexaoEntreOsVertices);
        desenharValorDaAresta(graphics2D);
    }

    /*
     * Desenha o valor da aresta na tela.
     */
    private void desenharValorDaAresta(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.WHITE);
        /*
    	 * Preenche a area de texto onde será desenhado o valor da aresta.
         */
        graphics2D.fill(_areaDoTexto);

        /*
    	 * Seta a fonte que será desenhado.
         */
        graphics2D.setFont(new Font("Serif", Font.BOLD, 12));
        graphics2D.setPaint(Color.BLUE);

        /*
    	 * Desenha o valor da aresta na tela.
         */
        final FontMetrics fonteMetrics = graphics2D.getFontMetrics();
        graphics2D.drawString(String.valueOf(_peso), (int) _areaDoTexto.getX(), (int) _areaDoTexto.getY() + fonteMetrics.getHeight());
    }

    /*
     * Métoque que define a forma que a aresta será desenhada na tela.
     * Aresta em linha.
     * Aresta em auto laço.
     * Aresta em curva.
     */
    private void defineAFormaDaAresta() {
        double anguloInicial, anguloFinal = 0D;
        Point2D pontoInicial, pontoFinal = null;

        /*
	* Cria uma aresta em curva caso ela seja direcionada
	* Calcula a curva que a aresta irá fazer caso mais de uma aresta estaja
	* ligando os mesmo vertices.
         */
        double distanciaX, distanciaY, centroX, centroY, distancia, fatorX, fatorY;

        int contador = 1;
        Point2D.Double posicaoInicial = null;

        /*
	* Realiza o calculo duas vezes para que o desenho da aresta fique alinhado aos vertices.
         */
        while (contador <= 2) {
            /*
            * Pega os angulos dos vertices para arestas não direcionadas.
             */
            anguloInicial = Utils.getAngulo(_centroVerticeInicial, _centroVerticeFinal);
            anguloFinal = Utils.getAngulo(_centroVerticeFinal, _centroVerticeInicial);

            /*
             * Pega os pontos2D dos vertices para aresta não direcionadas.
             */
            pontoInicial = Utils.getPontoNoVertice(_centroVerticeInicial, anguloInicial);
            pontoFinal = Utils.getPontoNoVertice(_centroVerticeFinal, anguloFinal);

            /*
             * Pega o ponto inicial da aresta.
             */
            posicaoInicial = new Point2D.Double(pontoInicial.getX(), pontoInicial.getY());
            /*
             * Seta a posição final da aresta.
             */
            _posicaoFinal.setLocation(pontoFinal.getX(), pontoFinal.getY());

            /*
             * Pega as distancias das coordenadas X e Y da aresta.
             */
            distanciaX = _posicaoFinal.x - posicaoInicial.x;
            distanciaY = _posicaoFinal.y - posicaoInicial.y;

            /*
             * Pega os centros nas coordenadas X e Y da aresta.
             */
            centroX = (posicaoInicial.x + _posicaoFinal.x) / 2.0;
            centroY = (posicaoInicial.y + _posicaoFinal.y) / 2.0;

            /*
             * Realiza calculo para a curvar as arestas.
             */
            distancia = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
            fatorX = distancia == 0D ? 0D : distanciaX / distancia;
            fatorY = distancia == 0D ? 0D : distanciaY / distancia;

            /*
             * Seta a curva que a aresta irá fazer.
             */
            _controleDeCurva.x = (centroX + _curvatura * _larguraVerticeDeInicial * fatorY);
            _controleDeCurva.y = (centroY - _curvatura * _larguraVerticeDeInicial * fatorX);

            contador++;
        }
        _conexaoEmLinha = new Line2D.Double(posicaoInicial, _posicaoFinal);
    }

    /*
     * Calcula a area que o texto do valor da aresta irá ocupar.
     */
    private void calcularAreaTexto(FontMetrics fonteMetrics) {
        Point2D ponto2D = Utils.getPontoTextoAresta(_centroVerticeInicial, _centroVerticeFinal, _controleDeCurva);
        _areaDoTexto.setRect(ponto2D.getX() - (fonteMetrics.stringWidth(String.valueOf(_peso)) / 2),
                ponto2D.getY() - fonteMetrics.getHeight(), fonteMetrics.stringWidth(String.valueOf(_peso)), fonteMetrics.getHeight());
    }

    /* 
     * Desenha a aresta na tela.
     */
    public void desenhaAresta(Graphics2D graphics2D) {
        defineAFormaDaAresta();

        calcularAreaTexto(graphics2D.getFontMetrics());
        _conexaoEntreOsVertices = _conexaoEmLinha;
        /*
         * Caso contrario cria uma aresta com curvatura, 
        * se a aresta for direcionada e se já existir outra aresta ligando os mesmo vertices.
         */
        if (getInicio() == getFim()) {
            _conexaoEntreOsVertices = _conexaoEmCurva;
        }
        desenharAresta(graphics2D);
    }

    public Vertice getInicio() {
        return _inicio;
    }

    public Vertice getFim() {
        return _fim;
    }

    public void setCurvatura(int curvatura) {
        this._curvatura = curvatura;
    }

    public Double getPeso() {
        return _peso;
    }

    public void setPeso(Double peso) {
        this._peso = peso;
    }

    @Override
    public int compareTo(Aresta aresta) {
        return this._peso.compareTo(aresta.getPeso());
    }

}
