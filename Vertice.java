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
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Classe Vertice.
 * Controla todas as ações dos vertices.
 * @author Mariana Lima
 * @author Nadime
 */
public class Vertice implements Comparable<Vertice>, Serializable {

    public static Double LARGURA = 10D;

    private String _id;
    private List<Aresta> _adjacente;
    private double _coordenadaX;
    private double _coordenadaY;
    private Shape _desenhoVertice;
    private Point2D _centroVertice;
    private Double _distancia;
    private boolean _visitado = false;
    private Vertice _pai;

    /*
     * Construtor da classe.
     * Cria o desenho de um circulo para representar um vertice.
     * Calcula o centro do vertice.
     */
    public Vertice(String id, double coordenadaX, double coordenadaY) {
        this._id = id;
        this._adjacente = new ArrayList<Aresta>();
        this._coordenadaX = coordenadaX;
        this._coordenadaY = ((coordenadaY *-1)+400);
    }

    /*
     * Lista de arestas ligadas ao vertice.
     */
    public List<Aresta> getListaAdjacentes() {
        return this._adjacente;
    }

    public void adicionaAdj(Aresta aresta) {
        _adjacente.add(aresta);
    }

    public String getId() {
        return this._id;
    }

    /*
     * Metodo que desenha o vertice na tela.
     */
    public void desenharVertice(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.WHITE);
        /*
		 * Preenche a area do desenha onde ficará o vertice.
         */
        graphics2D.fill(_desenhoVertice);

        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setPaint(Color.BLACK);

        /*
		 * Desenha o vertice na tela.
         */
        graphics2D.draw(_desenhoVertice);

        /*
		 * Desenha o nome do vertice na tela.
         */
    }

    /*
	 * Metodo que verifica se na posição passada como parametro existe algum vertice.
     */
    public boolean isExisteVerticeNo(Point2D ponto) {
        return _desenhoVertice.contains(ponto);
    }

    public Double getCoordenadaX() {
        return _coordenadaX;
    }

    public void setCoordenadaX(Double coordenadaX) {
        this._coordenadaX = coordenadaX;
    }

    public Double getCoordenadaY() {
        return _coordenadaY;
    }

    public void setCoordenadaY(Double coordenadaY) {
        this._coordenadaY = coordenadaY;
    }

    public Point2D getCentroVertice() {
        return _centroVertice;
    }
    
    public Double getDistancia() {
        return _distancia;
    }

    public void setDistancia(double distancia) {
        this._distancia = distancia;
    }
    
    public void setVisitar(boolean visitar) {
        this._visitado = visitar;
    }

    public boolean isVisitado() {
        return this._visitado;
    }

    public Vertice getPai() {
        return _pai;
    }

    public void setPai(Vertice pai) {
        this._pai = pai;
    }

    @Override
    public int compareTo(Vertice vertice) {
        return this.getDistancia().compareTo(vertice.getDistancia());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_id == null) ? 0 : _id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vertice other = (Vertice) obj;
        if (_id == null) {
            if (other._id != null) {
                return false;
            }
        } 
        return (_id.equals(other._id));
    }
}
