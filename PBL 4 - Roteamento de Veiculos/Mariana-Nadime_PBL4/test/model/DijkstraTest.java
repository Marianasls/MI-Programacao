package model;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Grafo;

/**
 *
 * @author Mariana Lima
 */

public class DijkstraTest {
    private Grafo grafo;
    public DijkstraTest() {
    }
    
    @Before
    public void setUp() {
        grafo = new Grafo("Mapa");
    
    }

    /**
     * Test of encontrarMenorCaminhoDijkstra method, of class Dijkstra.
     */
    @Test
    public void testEncontrarMenorCaminhoDijkstra() {
        try {
            grafo = new LeituraArquivo("Mapa-Westeros.txt", grafo).lerArquivoBinario();
        } catch (IOException ex) {
            System.out.println("ta tudo errado"); 
        }
        List cidades = grafo.getVertices();
        System.out.println(cidades.size());
        List menorCaminho = new Dijkstra().encontrarMenorCaminhoDijkstra(grafo, (Vertice)cidades.get(0), (Vertice)cidades.get(cidades.size()-1));
        System.out.println("nome: "+ grafo.getNomeDoMapa());
        for(int i = 0; i<menorCaminho.size(); i++){
            Vertice v = (Vertice)menorCaminho.get(i);
            System.out.println("Menor caminho: "+ v.getId() +" - "+ v.getDistancia());
        }
    }
    
    @Test
    public void testEncontraCaminhoGeral() {
     
    
    }
}
