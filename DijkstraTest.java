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
 * @author Nadime
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
