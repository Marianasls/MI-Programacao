package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;
import model.Vertice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CLASSE TESTE DO GRAFO, Adiciona as 30 cidades ao grafo e suas respectivas arestas,
 * e escreve o objeto grafo marcado como serializable em um arquivo bínario para
 * ser lido posteriormente. 
 * @author Notebook
 */
public class GrafoTest {

    private Grafo grafo;

    public GrafoTest() {
    }

    @Before
    public void setUp() {
        grafo = new Grafo("Westeros");
    }

    /**
     * Test of adicionarVertice method, of class Grafo.
     */
    @Test
    public void testAdicionarVertice() throws FileNotFoundException, IOException, ClassNotFoundException {
        grafo.adicionarVertice("Shadow Tower", 90, 400);  //0
        grafo.adicionarVertice("Castle Black", 100, 400);
        grafo.adicionarVertice("Eastwatch", 110, 400);
        grafo.adicionarVertice("Winterfell", 90, 350);
        grafo.adicionarVertice("Castle Cerwyn", 90, 340);
        grafo.adicionarVertice("Moat Cailin", 100, 320);   //5
        grafo.adicionarVertice("White Harbor", 120, 330);
        grafo.adicionarVertice("The Twins", 80, 300);
        grafo.adicionarVertice("Seagard", 80, 298);
        grafo.adicionarVertice("Pyke", 60, 295);
        grafo.adicionarVertice("Raventree Hall", 80, 295);  //10
        grafo.adicionarVertice("Riverrun", 80, 290);
        grafo.adicionarVertice("Stone Hedge", 90, 290);
        grafo.adicionarVertice("The Eyrie", 130, 300);
        grafo.adicionarVertice("High Heart", 130, 300);
        grafo.adicionarVertice("Harrenhal", 110, 285);     //15   
        grafo.adicionarVertice("Casterly Rock", 60, 270);
        grafo.adicionarVertice("Lannisport", 60, 265);
        grafo.adicionarVertice("Deep Den", 60, 265);
        grafo.adicionarVertice("Crakehall", 55, 260);
        grafo.adicionarVertice("Old Oak", 60, 255);        //20
        grafo.adicionarVertice("Highgarden", 70, 245);
        grafo.adicionarVertice("Oldtown", 60, 235);
        grafo.adicionarVertice("Kings Landing", 120, 265);
        grafo.adicionarVertice("Fetwood", 120, 265);
        grafo.adicionarVertice("Bitterbrigde", 120, 265);   //25
        grafo.adicionarVertice("Bronzegate", 120, 265);
        grafo.adicionarVertice("Storms End", 125, 255);
        grafo.adicionarVertice("Tarth", 125, 255);
        grafo.adicionarVertice("Summerhall", 120, 250);
        grafo.adicionarVertice("Yronwood", 110, 235);       //30

        Object[] vertice = grafo.getVertices().toArray();
        grafo.adicionarAresta((Vertice) vertice[0], (Vertice) vertice[1], 10.0);
        grafo.adicionarAresta((Vertice) vertice[1], (Vertice) vertice[2], 10.0);
        grafo.adicionarAresta((Vertice) vertice[1], (Vertice) vertice[3], 50.0);
        grafo.adicionarAresta((Vertice) vertice[3], (Vertice) vertice[4], 20.0);
        grafo.adicionarAresta((Vertice) vertice[4], (Vertice) vertice[5], 30.0);
        grafo.adicionarAresta((Vertice) vertice[5], (Vertice) vertice[6], 10.0);
        grafo.adicionarAresta((Vertice) vertice[5], (Vertice) vertice[7], 50.0);
        grafo.adicionarAresta((Vertice) vertice[7], (Vertice) vertice[8], 10.0);
        grafo.adicionarAresta((Vertice) vertice[8], (Vertice) vertice[9], 50.0);
        grafo.adicionarAresta((Vertice) vertice[8], (Vertice) vertice[10], 10.0);
        grafo.adicionarAresta((Vertice) vertice[10], (Vertice) vertice[11], 10.0);
        grafo.adicionarAresta((Vertice) vertice[11], (Vertice) vertice[12], 10.0);
        grafo.adicionarAresta((Vertice) vertice[12], (Vertice) vertice[13], 50.0);
        grafo.adicionarAresta((Vertice) vertice[11], (Vertice) vertice[14], 10.0);
        grafo.adicionarAresta((Vertice) vertice[14], (Vertice) vertice[15], 10.0);
        grafo.adicionarAresta((Vertice) vertice[12], (Vertice) vertice[15], 15.0);
        grafo.adicionarAresta((Vertice) vertice[11], (Vertice) vertice[16], 50.0);
        grafo.adicionarAresta((Vertice) vertice[16], (Vertice) vertice[17], 10.0);
        grafo.adicionarAresta((Vertice) vertice[17], (Vertice) vertice[18], 40.0);
        grafo.adicionarAresta((Vertice) vertice[16], (Vertice) vertice[18], 50.0);
        grafo.adicionarAresta((Vertice) vertice[17], (Vertice) vertice[19], 10.0);
        grafo.adicionarAresta((Vertice) vertice[19], (Vertice) vertice[20], 10.0);
        grafo.adicionarAresta((Vertice) vertice[20], (Vertice) vertice[21], 10.0);
        grafo.adicionarAresta((Vertice) vertice[21], (Vertice) vertice[22], 10.0);
        grafo.adicionarAresta((Vertice) vertice[5], (Vertice) vertice[23], 70.0);
        grafo.adicionarAresta((Vertice) vertice[23], (Vertice) vertice[18], 50.0);
        grafo.adicionarAresta((Vertice) vertice[23], (Vertice) vertice[25], 50.0);
        grafo.adicionarAresta((Vertice) vertice[23], (Vertice) vertice[26], 40.0);
        grafo.adicionarAresta((Vertice) vertice[26], (Vertice) vertice[27], 10.0);
        grafo.adicionarAresta((Vertice) vertice[27], (Vertice) vertice[28], 30.0);
        grafo.adicionarAresta((Vertice) vertice[25], (Vertice) vertice[21], 50.0);
        grafo.adicionarAresta((Vertice) vertice[27], (Vertice) vertice[29], 30.0);
        grafo.adicionarAresta((Vertice) vertice[27], (Vertice) vertice[29], 30.0);
        grafo.adicionarAresta((Vertice) vertice[29], (Vertice) vertice[30], 50.0);
        
        ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(new File("Mapa-Westeros.txt")));
        a.writeObject(grafo);
        ObjectInputStream b = new ObjectInputStream(new FileInputStream(new File("Mapa-Westeros.txt")));
        
        System.out.println(b.readObject());
    }

    /**
     * Test of desenharGrafo method, of class Grafo.
     */
    @Test
    public void testDesenharGrafo() {
        
    }

    /**
     * Test of isExisteVerticeNo method, of class Grafo.
     */
    @Test
    public void testIsExisteVerticeNo() {
    }

    /**
     * Test of getVertices method, of class Grafo.
     */
    @Test
    public void testGetVertices() {
    }

    /**
     * Test of getArestas method, of class Grafo.
     */
    @Test
    public void testGetArestas() {
    }
}
