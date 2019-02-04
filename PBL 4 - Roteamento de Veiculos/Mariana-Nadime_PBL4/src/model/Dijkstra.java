package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Grafo;

/**
 * Classe que escolhe o menor caminho entre dois vertices
 * @author Mariana Lima
 */

public class Dijkstra {

    // Lista que guarda os vertices pertencentes ao menor caminho encontrado
    List<Vertice> menorCaminho = new ArrayList<Vertice>();

    // Variavel que recebe os vertices pertencentes ao menor caminho
    Vertice verticeCaminho = new Vertice();

    // Variavel que guarda o vertice que esta sendo visitado
    Vertice atual = new Vertice();

    // Variavel que marca o vizinho do vertice atualmente visitado
    Vertice vizinho = new Vertice();

    // Lista dos vertices que ainda nao foram visitados
    List<Vertice> naoVisitados = new ArrayList<Vertice>();
    
    /**
     * Método que calcula o menor caminho entre dois vertices utilizando o algoritmo
     * de Dijkstra
     * @param grafo
     * @param v1 vertice origem
     * @param v2 vertice destino
     * @return lista de vertices do menor caminho para sair da origem e chegar ao destino 
     */
    public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {
        // Adiciona a origem na lista do menor caminho
        menorCaminho.add(v1);

        for (int i = 0; i < grafo.getVertices().size(); i++) {

            // Vertice atual tem distancia zero, e todos os outros,
            // 9999("infinita")
            if (grafo.getVertices().get(i).getId().equals(v1.getId())) {
                grafo.getVertices().get(i).setDistancia(0);
            } else {
                grafo.getVertices().get(i).setDistancia(9999);
            }
            // Insere o vertice na lista de vertices nao visitados
            this.naoVisitados.add(grafo.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        // O algoritmo continua ate que todos os vertices sejam visitados
        while (!this.naoVisitados.isEmpty()) {

            // Toma-se sempre o vertice com menor distancia, primeiro da lista
            atual = this.naoVisitados.get(0);
            System.out.println("Pegou esse vertice:  " + atual.getId());
            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */
            for (int i = 0; i < atual.getListaAdjacentes().size(); i++) {
                vizinho = atual.getListaAdjacentes().get(i).getFim();
                System.out.println("Olhando o vizinho de " + atual.getId() + ": " + vizinho.getId());
                if (!vizinho.isVisitado()) {
                    // Comparando a distância do vizinho com a possível
                    // distância
                    if (vizinho.getDistancia() > (atual.getDistancia() + atual.getListaAdjacentes().get(i).getPeso())) {
                        vizinho.setDistancia(atual.getDistancia() + atual.getListaAdjacentes().get(i).getPeso());
                        vizinho.setPai(atual);
                        /*
			 * Se o vizinho eh o vertice procurado, e foi feita uma
			 * mudanca na distancia, a lista com o menor caminho
			 * anterior eh apagada, pois existe um caminho menor
			 * vertices pais, ateh o vertice origem.
                         */
                        if (vizinho == v2) {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (verticeCaminho.getPai() != null) {
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }
                            // Ordena a lista do menor caminho, para que ele
                            // seja exibido da origem ao destino.
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }
            // Marca o vertice atual como visitado e o retira da lista de nao
            // visitados
            atual.setVisitar(true);
            this.naoVisitados.remove(atual);
            /*
             * Ordena a lista, para que o vertice com menor distancia fique na
             * primeira posicao
             */
            Collections.sort(naoVisitados);
        }

        return menorCaminho;
    }

}
