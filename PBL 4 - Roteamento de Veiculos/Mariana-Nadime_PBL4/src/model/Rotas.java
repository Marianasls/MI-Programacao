package model;

import java.util.ArrayList;
import java.util.List;
import util.Grafo;

/**
 * Classe da rota com menor caminho.
 * @author Nadine
 * @author Mariana
 */
public class Rotas {

    private double distancia;
    private double consumoTotal;
    private final List<List<Vertice>> lista_de_rota;
    private Veiculos veiculo;
    private final Grafo grafo;
    
    public Rotas(Grafo grafo) {
        this.grafo = grafo;
        
        lista_de_rota = new ArrayList();
    }

    public void setVeiculo(Veiculos v) {
        veiculo = v;
    }

    
    /**
     * Encontra a rota de menor caminho para a lista de cidades selecionadas pelo
     * usuario.
     * @param cidadesSelecionadas lista de cidades 
     */
    public void MenorCaminho(List<Vertice> cidadesSelecionadas) {
        Dijkstra dijkstra = new Dijkstra();
        int j;
        // Adicionando feira de santana como ponto de destino após encontrar o menor
        // caminho entre feira e a primeira cidade selecionada do mapa.
        lista_de_rota.add(dijkstra.encontrarMenorCaminhoDijkstra(grafo, grafo.getVertices().get(0),
                cidadesSelecionadas.get(0)));
        
        //Variavel que guarda a posição do ultimo vertice da lista de vertices na posição zero da lista de rota 
        j = lista_de_rota.get(0).size() - 1;
        //somando a distancia do ultimo vertice na distancia geral da rota
        distancia += lista_de_rota.get(0).get(j).getDistancia();
      
        // percorre a lista de cidades selecionadas ate o penultimo elemento, aplicando
        // o algoritmo de dijkstra de dois em dois vertices.
        for (int i = 0; i < cidadesSelecionadas.size() - 1; i++) {

            //Adiciona na lista de menor caminho geral, uma lista de vertices do menor caminho entre dois vertices.
            lista_de_rota.add(dijkstra.encontrarMenorCaminhoDijkstra(
                    grafo, cidadesSelecionadas.get(i), cidadesSelecionadas.get(i + 1))
            );

            //Setando j igual a posição do ultimo vertice da lista de vertices na posição i+1 
            //(considerando que ja tem uma lista de vertices na lista_de_rota)
            j = lista_de_rota.get(i+1).size()-1;
            //somando a distancia do ultimo vertice na distancia geral da rota
            distancia += lista_de_rota.get(i+1).get(j).getDistancia();
        }
        
        // Adiciona ao final da lista, o menor caminho de volta, entre a ultima cidade
        // selecionada, e feira de santana(cidade origem.
        lista_de_rota.add(dijkstra.encontrarMenorCaminhoDijkstra(
                grafo, grafo.getVertices().get(0), cidadesSelecionadas.get(cidadesSelecionadas.size() - 1))
        );     
        consumoTotal = distancia;
    }
    
    public double getDistancia() {
        return distancia;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public List<List<Vertice>> getLista_de_rota() {
        return lista_de_rota;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

}
