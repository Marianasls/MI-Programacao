/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.Aresta;
import model.Vertice;

/*
 * Classe Grafo
 * Controla todas as ações do grafo.
 */
public class Grafo {

    List<Vertice> _vertices;
    List<Aresta> _arestas;
    private int _valorTabelaAscii = 64;

    /*
     * Construtor da classe.
     * Inicializa as listas de vertices e arestas.
     */
    public Grafo() {
        _vertices = new ArrayList<Vertice>();
        _arestas = new ArrayList<Aresta>();
    }

    public void adicionarVertice(double posX, double posY) {
        final Vertice vertice = new Vertice(getId(), posX, posY);
        _vertices.add(vertice);
    }

    /*
     * Metodo que adiciona um vertice no grafo.
     */
    public void adicionarVertice(Point2D ponto) {
        final Vertice vertice = new Vertice(getId(), ponto.getX(), ponto.getY());
        _vertices.add(vertice);
    }

    public void adicionarAresta(Vertice inicio, Vertice fim, Double peso) {
        final Aresta aresta = new Aresta(inicio, fim, peso);
        inicio.adicionaAdj(aresta);
        _arestas.add(aresta);
    }

    public void adicionarAresta(double posX, double posY, Double peso) {
        final Vertice verticePonto1 = buscaVerticePelo(posX);
        final Vertice verticePonto2 = buscaVerticePelo(posY);

        if (verticePonto1 == null && verticePonto2 == null) {
            return;
        }

        adicionarAresta(verticePonto1, verticePonto2, peso);
    }
    
    /*
     * Metodo que adiciona uma aresta a partir de posições selecionadas na tela.
     * Para cada posição passada como parametro
     * irá busca o vertice daquela posição.
     */
    public void adicionarAresta(Point2D ponto1, Point2D ponto2, Double peso) {
        final Vertice verticePonto1 = buscaVerticePelo(ponto1);
        final Vertice verticePonto2 = buscaVerticePelo(ponto2);

        if (verticePonto1 == null && verticePonto2 == null) {
            return;
        }

        adicionarAresta(verticePonto1, verticePonto2, peso);
    }
    /*
     * Metodo que busca o vertice que está na posição
     * passada como parametro.
     */
    private Vertice buscaVerticePelo(Point2D ponto) {
        for (Vertice vertice : _vertices) {
            if (vertice.isExisteVerticeNo(ponto)) {
                return vertice;
            }
        }

        return null;
    }

    /*
     * Metodo que desenha o grafo na tela.
     */
    public void desenharGrafo(Graphics2D graphics2D) {
        /*
    	 * Desenhas os vertices na tela.
         */
        for (Vertice vertice : _vertices) {
            vertice.desenharVertice(graphics2D);
        }

        /*
    	 * Desenha as arestas na tela.
         */
        for (Aresta aresta : _arestas) {
            aresta.desenhaAresta(graphics2D);
        }
    }

    /*
     * Metodo que verifica se no ponto passado como parametro
     * existe algum vertice.
     */
    public boolean isExisteVerticeNo(Point2D ponto) {
        for (Vertice vertice : _vertices) {
            if (vertice.isExisteVerticeNo(ponto)) {
                return true;
            }
        }

        return false;
    }

    /*
     * Metodo que retorna um identificador para o vertice.
     */
    private String getId() {
        /*
    	 * Transforma um valor inteiro em caracter com base na tabela ASCII.
         */
        _valorTabelaAscii++;
        final String id = new Character((char) _valorTabelaAscii).toString();

        return id;
    }

    public List<Vertice> getVertices() {
        return _vertices;
    }

    public List<Aresta> getArestas() {
        return _arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this._arestas = arestas;
    }

}
