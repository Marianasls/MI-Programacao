package util;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Aresta;
import model.Vertice;

/*
 * Classe Grafo
 * Controla todas as ações do grafo.
 */
public class Grafo implements Serializable {

    private List<Vertice> _vertices;
    private List<Aresta> _arestas;
    private String nomeDoMapa;

    /*
     * Construtor da classe.
     * Inicializa as listas de vertices e arestas.
     */
    public Grafo(String nome) {
        this.nomeDoMapa = nome;
        _vertices = new ArrayList<Vertice>();
        _arestas = new ArrayList<Aresta>();
    }

    public String getNomeDoMapa() {
        return nomeDoMapa;
    }

    /*
     * Metodo que adiciona um vertice no grafo.
     */
    public Vertice adicionarVertice(String id, double posX, double posY) {
        final Vertice vertice = new Vertice(id, posX, posY);
        _vertices.add(vertice);
        return vertice;
    }

    /*
     * Metodo que adiciona arestas do grafo.
     */
    public void adicionarAresta(Vertice inicio, Vertice fim, Double peso) {
        final Aresta aresta = new Aresta(inicio, fim, peso);
        inicio.adicionaAdj(aresta);
        _arestas.add(aresta);
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

    public List<Vertice> getVertices() {
        return _vertices;
    }

    public List<Aresta> getArestas() {
        return _arestas;
    }

}
