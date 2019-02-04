/** *****************************************************************************
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Mariana Lima>
 * Data:  <04/12/2018>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
******************************************************************************
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.Grafo;

/**
 *
 * @author Notebook
 */
public class LeituraArquivoTest {
    private Grafo grafo;
    
    public LeituraArquivoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lerArquivo method, of class LeituraArquivo.
     */
    @Test
    public void testLerArquivoTexto(){
        grafo = new Grafo("Mapa");
        try {
            new LeituraArquivo("teste.txt", grafo).lerArquivoTexto();
            System.out.println(grafo.getVertices().size());
        } catch(IOException e){
            System.out.println("Não foi possivel ler o arquivo :x");
        }
    }
    
    @Test
    public void testLerArquivoBinario() {
        grafo = new Grafo("Mapa");
        try{
            grafo = new LeituraArquivo("Mapa-Westeros.txt", grafo).lerArquivoBinario();
            System.out.println(grafo.getVertices().size());
        }catch(FileNotFoundException e){
            System.out.println("Objeto serializado nao foi encontrado");
        }catch(IOException e){
            System.out.println("ta tudo errado");            
        }
    }
}
